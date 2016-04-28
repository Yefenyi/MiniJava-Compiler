package CodeGenerator;

import java.util.ArrayList;
import java.util.Collection;
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
	private int labelNumber =0;
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
		switch(BasicCodeGenerator.getCaseNumber(pt)){
			case 0: if(debug) System.out.println("stmtList: "+ pt.getText());
					output.add("#enter enviroment");
					for(ParseTree child: ((MiniJavaParser.StmtListContext) pt).children){
						output.addAll(this.walkTree(child));
					}
					output.add("#exit enviroment");
					break;
			case 1: if(debug) System.out.println("stmt: " + pt.getText());
					output.addAll(this.getStmtString(pt));
					
					break;
			case 2: //cases 2 to 16 are for different possible expressions
					//TODO 
					break;
			case 6: if(debug) System.out.println("Comparison Expresion: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 7: if(debug) System.out.println("Comparison Expresion Prime: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					String parent = this.getParentsNonPrime(pt.getParent());
					if(pt.getChild(0).getText().equals("<")){
						output.add("slt "+regs.getNextReg()+", "+regs.getAssignment(parent)+", "+regs.getAssignment(pt.getChild(1).getText()));
					} else if(pt.getChild(0).getText().equals("<=")){
						output.add("sge "+regs.getNextReg()+", "+regs.getAssignment(pt.getChild(1).getText())+", "+regs.getAssignment(parent));
					}else if(pt.getChild(0).getText().equals(">")){
						output.add("sgt "+regs.getNextReg()+", "+regs.getAssignment(parent)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}else{
						output.add("sge "+regs.getNextReg()+", "+regs.getAssignment(parent)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}
					regs.setAssignment(parent+pt.getChild(0).getText()+pt.getChild(1).getText());
					break;
			case 8: if(debug) System.out.println("Comparision: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(2)));
					String command = "";
					if(pt.getChild(1).getText().equals("==")){
						command = "seq ";
					}else{
						command = "snq ";
					}
					command += regs.getNextReg() +", "+regs.getAssignment(pt.getChild(0).getText())+", "+regs.getAssignment(pt.getChild(2).getText());
					output.add(command);
					regs.setAssignment(pt.getText());
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
						output.add("mult "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}else{
						output.add("div "+regs.getAssignment(parentString)+", "+regs.getAssignment(pt.getChild(1).getText()));
					}
					output.add("mflo "+regs.getNextReg());
					regs.setAssignment(parentString+pt.getChild(0).getText()+pt.getChild(1).getText());
					if(pt.getChild(2).getChildCount()!=0){
						output.addAll(this.walkTree(pt.getChild(2)));
					}
					break;
			case 13:if(debug) System.out.println("Not expression");
					//TODO
					break;
			case 16:if(debug) System.out.println("HPE: "+pt.getText());
					if(pt.getChildCount()==3){// ( pt )
						output.addAll(this.walkTree(pt.getChild(1)));
						regs.replaceLast(pt.getText());
					}else if(pt.getChildCount()==4){
						// new id()
						//TODO
					}else{
						System.out.println("shouldn't get called says alvin...");
					}
					break;
			case 17:if(debug) System.out.println("Token "+pt.getText());
					if(((Token) pt.getPayload()).getType() == MiniJavaLexer.INTEGER){
						this.regs.setAssignment(pt.getText());
						output.add("li "+this.regs.getAssignment(pt.getText())+", "+pt.getText());
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.ID){
						//Pass variable should be in register already
					}else{
						//TODO
					}
					break;
			default:if(debug) System.out.println("unidentifed case: "+pt.getText());
					if(debug) System.out.println("case number: "+String.valueOf(BasicCodeGenerator.getCaseNumber(pt)));
					break;
		}
		return output;
	}

	private List<String> getStmtString(ParseTree pt) {
		List<String> output = new ArrayList<String>();
		if(pt.getChildCount()==5){
			//could be a while, print, or deceleration
			if(pt.getChild(0).getText().equals("System.out.println")){ //system print
				output.addAll(this.walkTree(pt.getChild(2)));
				output.addAll(this.SystemPrintFunction(this.regs.getAssignment(pt.getChild(2).getText())));
			}else if(pt.getChild(2).getText().equals("=")){ //New variable def
				output.addAll(this.walkTree(pt.getChild(3)));
				output.add("#create #"+pt.getChild(0).getText()+" #"+pt.getChild(1).getText());
				regs.setAssignment(pt.getChild(1).getText());
				output.add("add "+regs.getAssignment(pt.getChild(1).getText())+", "+regs.getAssignment(pt.getChild(3).getText())+", $zero");
			}else if(pt.getChild(0).getText().equals("while")){
				//Start of loop
				int start =this.labelNumber;
				int end =this.labelNumber+1;
				this.labelNumber += 2;
				output.add("L"+String.valueOf(start)+":    nop");
				output.addAll(this.walkTree(pt.getChild(2)));//Check expression
				output.add("beq $zero, "+regs.getAssignment(pt.getChild(2).getText()) + ", L"+String.valueOf(end)  );//Branch to end if false
				output.addAll(this.walkTree(pt.getChild(4)));// loop body
				output.add("J "+"L"+String.valueOf(start));
				output.add("L"+String.valueOf(end)+":    nop"); //Exit location
			}
		} else if(pt.getChildCount()==3){
			output.addAll(this.walkTree(pt.getChild(1)));
		} else if(pt.getChildCount()==4){
			output.add("#varriable assignment");
			output.addAll(this.walkTree(pt.getChild(2)));
			output.add("add "+regs.getAssignment(pt.getChild(0).getText())+", " + regs.getAssignment(pt.getChild(2).getText())+", $zero");
		} else{
			int elsePoint = this.labelNumber++;
			int end = this.labelNumber++;
			output.addAll(this.walkTree(pt.getChild(2)));	//check
			output.add("beq $zero, "+regs.getAssignment(pt.getChild(2).getText()) + ", L"+String.valueOf(elsePoint)  );//Branch to else if false
			output.addAll(this.walkTree(pt.getChild(4)));	//body 1 
			output.add("J L"+String.valueOf(end));			//jump end
			output.add("L"+String.valueOf(elsePoint)+":    nop");
			output.addAll(this.walkTree(pt.getChild(6)));	//body 2 
			output.add("L"+String.valueOf(end)+":    nop"); //end
		}
		return output;
	}

	private String getParentsNonPrime(ParseTree pt) {
		int type = BasicCodeGenerator.getCaseNumber(pt);
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
