package CodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.ParsedClass;
import parser.ParsedMethod;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class BasicCodeGenerator {
	private Map<String,ParsedClass> parsedClassMap;
	private Map<String,GeneratedClass> genClassMap = new HashMap<String,GeneratedClass>();
	private RegisterHandler regs;
	private int freeReg =0;
	boolean debug = true;
	
	public BasicCodeGenerator(Map<String,ParsedClass> map){
		this.parsedClassMap = map;
		this.regs=new RegisterHandler();
	}

	public Map<String,GeneratedClass> generate(){
		for(String key: parsedClassMap.keySet()){
			this.createGenClass(parsedClassMap.get(key));
		}
		return null;
	}

	private void createGenClass(ParsedClass parsedClass) {
		GeneratedClass genClass = new GeneratedClass(parsedClass.getName());
		Map<String,GeneratedMethod> methodMap = new HashMap<String,GeneratedMethod>();
		genClass.setFieldMap(parsedClass.getNameToField());
		for(String key: parsedClass.getNameToMethod().keySet()){
			methodMap.put(key,this.createGenMethod(parsedClass.getNameToMethod().get(key)));
		}
		genClass.setMethodMap(methodMap);
		this.genClassMap.put(genClass.name,genClass);
	}
	
	//TODO return statement is not part of the parsedMethod tree need to go back and add it
	private GeneratedMethod createGenMethod(ParsedMethod parsedMethod) {
		ParseTree pt = parsedMethod.getTree();
		return new GeneratedMethod(parsedMethod.getName(),this.walkTree(pt));
	}
	private List<String> walkTree(ParseTree pt){
		List<String> output = new ArrayList<String>();
		switch(this.getCaseNumber(pt)){
			case 0: if(debug) System.out.println("stmtList : "+ pt.getText());
					//TODO environment stuff 
					for(ParseTree child: ((MiniJavaParser.StmtListContext) pt).children){
						output.addAll(this.walkTree(child));
					}
					break;
			case 1: if(debug) System.out.println("stmt :" + pt.getText());
					if(pt.getChildCount()==5){
						//could be a while, print, or deceleration
						if(true){//TODO change to check System print
							output.addAll(this.walkTree(pt.getChild(2)));
							output.addAll(this.SystemPrintFunction(this.regs.getAssignment(pt.getChild(2).getText())));
						}
						
					}
					break;
			case 2: //cases 2 to 16 are for different possible expressions
					//TODO 
					break;
			case 9: if(debug) System.out.println("Add or Sub "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 10:if(debug) System.out.println("Add or Sub Prime"+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					String parentString = this.getParentsNonPrime(pt.getParent());
					if(pt.getChild(0).getText().equals("+")){
						output.add("add "+regs.getNextReg()+", "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}else{
						output.add("sub "+regs.getNextReg()+", "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}
					regs.setAssignment(parentString+pt.getChild(0).getText()+pt.getChild(1).getText());
					if(pt.getChild(2).getChildCount()!=0){
						output.addAll(this.walkTree(pt.getChild(2)));
					}
					break;
			case 11:if(debug) System.out.println("Multiply or divide "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 12:if(debug) System.out.println("Multiply or divide Prime");
					output.addAll(this.walkTree(pt.getChild(1)));
					parentString = this.getParentsNonPrime(pt.getParent());
					if(pt.getChild(0).getText().equals("*")){
						output.add("mult "+regs.getNextReg()+", "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}else{
						output.add("div "+regs.getNextReg()+", "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}
					regs.setAssignment(parentString+pt.getChild(0).getText()+pt.getChild(1).getText());
					if(pt.getChild(2).getChildCount()!=0){
						output.addAll(this.walkTree(pt.getChild(2)));
					}
					break;
			case 16:if(debug) System.out.println("HPE: "+pt.getText());
					break;
			case 17:if(debug) System.out.println("Token "+pt.getText());
					if(((Token) pt.getPayload()).getType() == MiniJavaLexer.INTEGER){
						this.regs.setAssignment(pt.getText());
						output.add("li "+this.regs.getAssignment(pt.getText())+", "+pt.getText());
					}
					break;
			default:if(debug) System.out.println("unidentifed case: "+pt.getText());
					if(debug) System.out.println("case number: "+String.valueOf(this.getCaseNumber(pt)));
					break;
		}
		return output;
	}

	private String getParentsNonPrime(ParseTree pt) {
		int type = this.getCaseNumber(pt);
		if(type==2||type==4||type==6||type==8||type==9||type==11||type==13||type==14){
			return pt.getChild(0).getText();
		}else{
			return this.getParentsNonPrime(pt.getParent())+pt.getChild(0).getText()+pt.getChild(1).getText();
		}
	}

	private List<String> SystemPrintFunction(Register reg){
		List<String> output = new ArrayList<String>();
		output.add("li $v0, 1");
		output.add("add $a0, "+reg.toString()+", $zero");
		output.add("syscall");
		output.add("li $a0 10");
		output.add("li $v0 11");
		output.add("syscall");
		return output;
	}

	public List<String> getProgram() {
		List<String> output = new ArrayList<String>();
		for(String key : this.parsedClassMap.keySet()){
			GeneratedClass genClass= this.genClassMap.get(key);
			for(String method : genClass.methodMap.keySet()){
				output.addAll(genClass.methodMap.get(method).code);
			}
		}
		return output;
	}
	/**
	 * Give number type for type of pt tree give
	 * @param pt
	 * @return -1 unknown, 0 statement list, 1 statement
	 * 2 oE, 3 oEP, 4 aE, 5 aEP, 6, cE, 7 cEP, 8 eQE, 9 aSE, 10 aSEP, 11 mDE, 12 mDEP, 13 nE, 14 dE, 15 dEP, 16 hPE
	 */
	public static int getCaseNumber(ParseTree pt){
		if(pt instanceof MiniJavaParser.StmtListContext){
			return 0;
		}else if(pt instanceof MiniJavaParser.StmtContext){
			return 1;
		}else if(pt instanceof MiniJavaParser.OEContext){
			return 2;
		}else if(pt instanceof MiniJavaParser.OEPContext){
			return 3;
		}else if(pt instanceof MiniJavaParser.AEContext){
			return 4;
		}else if(pt instanceof MiniJavaParser.AEPContext){
			return 5;
		}else if(pt instanceof MiniJavaParser.CEContext){
			return 6;
		}else if(pt instanceof MiniJavaParser.CEPContext){
			return 7;
		}else if(pt instanceof MiniJavaParser.EQEContext){
			return 8;
		}else if(pt instanceof MiniJavaParser.ASEContext){
			return 9;
		}else if(pt instanceof MiniJavaParser.ASEPContext){
			return 10;
		}else if(pt instanceof MiniJavaParser.MDEContext){
			return 11;
		}else if(pt instanceof MiniJavaParser.MDEPContext){
			return 12;
		}else if(pt instanceof MiniJavaParser.NEContext){
			return 13;
		}else if(pt instanceof MiniJavaParser.DEContext){
			return 14;
		}else if(pt instanceof MiniJavaParser.DEPContext){
			return 15;
		}else if(pt instanceof MiniJavaParser.HPEContext){
			return 16;
		}else if(pt.getPayload() instanceof Token){
			return 17;
		}
		return -1;
	}
}
