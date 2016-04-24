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
	Map<String,ParsedClass> parsedClassMap;
	Map<String,GeneratedClass> genClassMap = new HashMap<String,GeneratedClass>();
	List<Register> regs;
	int freeReg =0;
	boolean debug = true;
	
	public BasicCodeGenerator(Map<String,ParsedClass> map){
		this.parsedClassMap = map;
		this.initRegs();
	}

	private void initRegs() {
		//TODO
		regs = new ArrayList<Register>();
		for(int i=0;i<10;i++){
			regs.add(new Register("t",i));
		}
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
							output.addAll(this.SystemPrintFunction(this.regs.get(freeReg)));
						}
						
					}
					break;
			case 2: //to 16 are for expressions
					//TODO 
					break;
			case 17:if(debug) System.out.println("Token "+pt.getText());
					if(((Token) pt.getPayload()).getType() == MiniJavaLexer.INTEGER){
						this.regs.get(freeReg).setTree(pt);
						output.add("li "+this.regs.get(freeReg)+", "+pt.getText());
					}
					break;
		}
		return output;
	}
	
	private List<String> SystemPrintFunction(Register reg){
		List<String> output = new ArrayList<String>();
		output.add("li $v0, 1");
		output.add("add $a0, "+reg.toString()+", $zero");
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
	
	private int getCaseNumber(ParseTree pt){
		if(pt instanceof MiniJavaParser.StmtListContext){
			return 0;
		}else if(pt instanceof MiniJavaParser.StmtContext){
			return 1;
		}else if(pt.getPayload() instanceof Token){
			return 17;
		}
		return -1;
	}
}
