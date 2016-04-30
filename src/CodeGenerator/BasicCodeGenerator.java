package CodeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.ParsedClass;
import parser.ParsedMainClass;
import parser.ParsedMethod;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class BasicCodeGenerator {
	private Map<String,ParsedClass> parsedClassMap;
	private Map<String,GeneratedClass> genClassMap = new HashMap<String,GeneratedClass>();
	private RegisterHandler regs;
	private String main;
	private int labelNumber =0;
	private int methodNumber = 0;
	boolean debug = true;
	
	public BasicCodeGenerator(Map<String,ParsedClass> map){
		this.parsedClassMap = map;
		this.regs=new RegisterHandler();
		this.generate();
	}

	private Map<String,GeneratedClass> generate(){
		int start =0;
		for(String key: parsedClassMap.keySet()){
			ParsedClass parsedClass = parsedClassMap.get(key);
			if(parsedClass instanceof ParsedMainClass){
				main = parsedClass.getName();
			}
			GeneratedClass c =this.createGenClass(parsedClass,start);
			start = c.classNumber +c.methodMap.size();
		}
		return null;
	}

	private GeneratedClass createGenClass(ParsedClass parsedClass, int classNumber) {
		GeneratedClass genClass = new GeneratedClass(parsedClass.getName());
		genClass.classNumber = classNumber;
		Map<String,GeneratedMethod> methodMap = new HashMap<String,GeneratedMethod>();
		genClass.setFieldMap(parsedClass.getNameToField());
		int start =classNumber;
		for(String key: parsedClass.getNameToMethod().keySet()){
			GeneratedMethod  method  = this.createGenMethod(parsedClass.getNameToMethod().get(key));
			regs.reset();
			method.methodNumber = start++;
			methodMap.put(key,method);
		}
		genClass.setMethodMap(methodMap);
		this.genClassMap.put(genClass.name,genClass);
		return genClass;
	}
	
	private List<String> initClasses(){
		//Store each class in the $gp with first method stored pc jump
		List<String> output = new ArrayList<String>();
		List<String> postJump = new ArrayList<String>();
		output.add("jal setup");
		output.add("setup: move $t0 $ra");
		output.add("j endClass");
		for(String key : this.parsedClassMap.keySet()){
			GeneratedClass c = this.genClassMap.get(key);
			for(String method : c.methodMap.keySet()){
				output.add("j m"+String.valueOf(c.methodMap.get(method).methodNumber));
			}
			postJump.add("sw $t0, "+String.valueOf(c.classNumber*4)+"($gp)");
			postJump.add("addi $t0, $t0, "+String.valueOf(4*c.methodMap.size()));
		}
		output.add("endClass: addi $t0, $t0, 8");
		output.addAll(postJump);
		return output;
	}
	
	private GeneratedMethod createGenMethod(ParsedMethod parsedMethod) {
		ParseTree pt = parsedMethod.getTree();
		return new GeneratedMethod(parsedMethod.getName(),this.walkTree(pt));
	}
	private List<String> walkTree(ParseTree pt){
		List<String> output = new ArrayList<String>();
		switch(BasicCodeGenerator.getCaseNumber(pt)){
			case 0: if(debug) System.out.println("stmtList: "+ pt.getText());
					output.add("#enter enviroment");
					if(pt.getChildCount()!=0){
						for(ParseTree child: ((MiniJavaParser.StmtListContext) pt).children){
							output.addAll(this.walkTree(child));
						}
					}
					output.add("#exit enviroment");
					break;
			case 1: if(debug) System.out.println("stmt: " + pt.getText());
					output.addAll(this.getStmtString(pt));
					break;
			case 2: if(debug) System.out.println("Or: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 3: if(debug) System.out.println("Or Prime: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					String parent = this.getParentsNonPrime(pt.getParent());
					output.add("or "+regs.getNextReg()+", "+regs.getAssignment(parent)+", "+regs.getAssignment(pt.getChild(1).getText()));
					regs.setAssignment(parent+pt.getChild(0).getText()+pt.getChild(1).getText());
					break;
			case 4: if(debug) System.out.println("And:"+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 5: if(debug) System.out.println("And Prime: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					parent = this.getParentsNonPrime(pt.getParent());
					output.add("and "+regs.getNextReg()+", "+regs.getAssignment(parent)+", "+regs.getAssignment(pt.getChild(1).getText()));
					regs.setAssignment(parent+pt.getChild(0).getText()+pt.getChild(1).getText());
					break;
			case 6: if(debug) System.out.println("Comparison Expresion: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 7: if(debug) System.out.println("Comparison Expresion Prime: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					parent = this.getParentsNonPrime(pt.getParent());
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
			case 9: if(debug) System.out.println("Add or Sub: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 10:if(debug) System.out.println("Add or Sub Prime: "+pt.getText());
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
			case 11:if(debug) System.out.println("Multiply or divide: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 12:if(debug) System.out.println("Multiply or divide Prime: "+pt.getText());
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
			case 13:if(debug) System.out.println("Not expression: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(1)));
					Register exp = regs.getAssignment(pt.getChild(1).getText());
					if(pt.getChild(0).getText().equals("!")){
						output.add("xori "+ exp +", "+exp+", 1");
					}else{
						output.add("sub "+exp+", $zero"+", "+exp);
					}
					exp.setTree(pt.getText());
					break;
			case 14:if(debug) System.out.println("Function call: "+pt.getText());
					output.addAll(this.walkTree(pt.getChild(0)));
					output.addAll(this.walkTree(pt.getChild(1)));
					break;
			case 15:if(debug) System.out.println("Function call prime: "+pt.getText());
					String parrent = this.getParentsNonPrime(pt.getParent());
					Register pointer = regs.getAssignment(parrent);
					System.out.println(pointer+" "+pointer.represents);
					
					//TODO
					output.add("lw "+regs.getNextReg() + " 0("+pointer+")");
					output.add("addi "+regs.getNextReg()+", "+regs.getNextReg()  + ", "+String.valueOf(this.getMethod(pt.getChild(1).getText())));
					output.add("#preCall");
					output.add("jalr "+regs.getNextReg());
					output.add("#postCall");
					output.add("move "+regs.getNextReg()+", $v0");
					regs.setAssignment(parrent+pt.getText());
					break;
			case 16:if(debug) System.out.println("HPE: "+pt.getText());
					if(pt.getChildCount()==3){// ( pt )
						output.addAll(this.walkTree(pt.getChild(1)));
						regs.replaceLast(pt.getText());
					}else if(pt.getChildCount()==4){
						// new id()
						String genClass = pt.getChild(1).getText();
						output.add("#allocate a "+genClass);
						output.add("li $v0, 9");
						output.add("li $a0, "+String.valueOf(this.getSize(genClass)));
						output.add("syscall");
						output.add("lw "+regs.getNextReg()+", "+String.valueOf(this.getMemory(genClass)+"($gp)"));
						output.add("sw "+regs.getNextReg()+", 0($v0)");//$v0 is the pointer
						output.add("move "+regs.getNextReg()+", $v0");
						regs.setAssignment(pt.getText());
					}else{
						System.out.println("shouldn't get called says alvin...");
					}
					break;
			case 17:if(debug) System.out.println("Token: "+pt.getText());
					if(((Token) pt.getPayload()).getType() == MiniJavaLexer.INTEGER){
						this.regs.setAssignment(pt.getText());
						output.add("li "+this.regs.getAssignment(pt.getText())+", "+pt.getText());
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.ID){
						//Pass, variable should be in register already
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.FALSE){
						this.regs.setAssignment("false");
						output.add("li "+this.regs.getAssignment(pt.getText())+", 0");
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.TRUE){
						this.regs.setAssignment("true");
						output.add("li "+this.regs.getAssignment(pt.getText())+", 1");
					}else{
						//TODO
					}
					break;
			case 18:if(debug) System.out.println("Method: "+pt.getText());
					//TODO might be all thats needed
					//TODO arguments need to be handled somewhere
					int index =0;
					for(;!(pt.getChild(index)instanceof MiniJavaParser.StmtListContext);index++);
					output.addAll(this.walkTree(pt.getChild(index)));
					output.addAll(this.walkTree(pt.getChild(index+2)));
					output.add("move $v0 ,"+regs.getAssignment(pt.getChild(index+2).getText()));
					output.add("jr $ra");
					break;
			default:if(debug) System.out.println("unidentifed case: "+pt.getText());
					if(debug) System.out.println("case number: "+String.valueOf(BasicCodeGenerator.getCaseNumber(pt)));
					break;
		}
		return output;
	}

	private int getMethod(String text) {
		// TODO 
		System.out.println(text);
		return 0;
	}

	private int getSize(String genClass) {
		// TODO get the size of the class and field variables
		// TODO maybe include garbage collection
		return 1*4;
	}

	private int getMemory(String genClass) {
		return genClassMap.get(genClass).classNumber*4;
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
		output.addAll(this.initClasses());
		output.add("j m"+String.valueOf(this.genClassMap.get(main).classNumber));
		for(String key : this.parsedClassMap.keySet()){
			GeneratedClass genClass= this.genClassMap.get(key);
			for(String method : genClass.methodMap.keySet()){
				output.add("m"+String.valueOf(genClass.methodMap.get(method).methodNumber)+": nop" + "    #"+key+"."+method);
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
	 * 17 token, 18 methodContext
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
		}else if(pt instanceof MiniJavaParser.MethodDeclContext){
			return 18;
		}
		return -1;
	}
}
