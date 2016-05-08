package CodeGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.ParsedClass;
import parser.ParsedIdentifier;
import parser.ParsedMainClass;
import parser.ParsedMethod;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class BasicCodeGenerator {
	private Map<String,ParsedClass> parsedClassMap;
	public Map<String,GeneratedClass> genClassMap = new HashMap<String,GeneratedClass>();
	private Map<String,Integer> methodToNumber = new HashMap<String, Integer>();
	private Map<String, ParsedIdentifier> currentClassVariables;
	private RegisterHandler regs;
	private String main;
	private int labelNumber =0;
	private int methodNumber = 0;
	private int callNumber = 0;
	boolean debug = false;
	
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
			for(String k: parsedClass.getNameToMethod().keySet()){
				if(!this.methodToNumber.containsKey(k)){
					this.methodToNumber.put(k,methodNumber++);
				}
			}
			GeneratedClass c =this.createGenClass(parsedClass,start);
			start = c.classNumber +c.methodMap.size()*2+2;
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
			regs.reset();
			regs.setArguements(parsedClass.getNameToMethod().get(key).getIdentifierList());
			GeneratedMethod  method  = this.createGenMethod(parsedClass.getNameToMethod().get(key).getIdentifierList(),parsedClass.getNameToMethod().get(key),parsedClass.getNameToField());
			method.methodNumber = start++;
			methodMap.put(key,method);
		}
		genClass.setMethodMap(methodMap);
		this.genClassMap.put(genClass.name,genClass);
		return genClass;
	}
	
	private List<String> initClasses(){
		//Store each class in the $gp with parent address and then (method number, method location)*
		List<String> output = new ArrayList<String>();
		List<String> postJump = new ArrayList<String>();
		output.add("jal setup");
		output.add("setup: move $t0, $ra");
		output.add("j endClass");
		for(String key : this.parsedClassMap.keySet()){
			GeneratedClass c = this.genClassMap.get(key);
			if(parsedClassMap.get(key).getExtendsClass()!=null){
				postJump.add("addi $t3, $gp, "+String.valueOf(genClassMap.get(parsedClassMap.get(key).getExtendsClass()).classNumber*4));
				postJump.add("sw $t3, "+String.valueOf(c.classNumber*4)+"($gp)");
			} else{
				postJump.add("sw $zero, "+String.valueOf(c.classNumber*4)+"($gp)");
			}
			postJump.add("li $t3, "+String.valueOf((c.methodMap.size()*2+2)*4));
			postJump.add("sw $t3, "+String.valueOf(c.classNumber*4+4)+"($gp)");
			int count =2;
			for(String method : c.methodMap.keySet()){
				output.add("j m"+String.valueOf(c.methodMap.get(method).methodNumber));
				postJump.add("li $t1, "+String.valueOf(this.methodToNumber.get(method)));
				postJump.add("sw $t1, "+String.valueOf((c.classNumber+count)*4)+"($gp)");
				count++;
				postJump.add("sw $t0, "+String.valueOf((c.classNumber+count)*4)+"($gp)");
				count++;
				postJump.add("addi $t0, $t0, "+String.valueOf(4));
			}
		}
		output.add("endClass: addi $t0, $t0, 8");
		output.addAll(postJump);
		return output;
	}
	
	private GeneratedMethod createGenMethod(List<ParsedIdentifier> list, ParsedMethod parsedMethod, Map<String, ParsedIdentifier> map) {
		ParseTree pt = parsedMethod.getTree();
		List<String> code = new ArrayList<String>();
		currentClassVariables = map;
		for(int i=3;list!=null &&(i<list.size());i++){
			code.add("lw "+regs.getNextReg()+", "+String.valueOf(4*(i-3))+"($sp)");
			regs.setAssignment(list.get(i).name);
		}
		code.addAll(this.walkTree(pt));
		currentClassVariables = null;
		return new GeneratedMethod(parsedMethod.getName(),code);
	}

	private List<String> walkTree(ParseTree pt){
		List<String> output = new ArrayList<String>();
		switch(BasicCodeGenerator.getCaseNumber(pt)){
			case 0: if(debug) System.out.println("stmtList: "+ pt.getText());
					output.add("#enter environment");
					if(pt.getChildCount()!=0){
						for(ParseTree child: ((MiniJavaParser.StmtListContext) pt).children){
							output.addAll(this.walkTree(child));
						}
					}
					output.add("#exit environment");
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
						command = "sne ";
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
					//TODO 
					//Most Likely spot for something to go wrong
					//this is the first arg
					for(int i=3;i<pt.getChildCount()-2;i+=2){
						output.addAll(this.walkTree(pt.getChild(i)));
					}
					output.add("#preCall");
					
					output.add("move $a0, "+pointer);
					int j =1;
					for(int i=3;i<pt.getChildCount()-2;i+=2){
						//move pt values to arguments
						if(i<9){
							output.add("move $a"+String.valueOf(1+(i-3)/2)+", "+regs.getAssignment(pt.getChild(i).getText()));
						}else{
							output.add("sw "+regs.getAssignment(pt.getChild(i).getText())+", "+String.valueOf(-4*j)+"($sp)");
							j++;
						}
					}
					if(j>1){
						output.add("addi $sp, $sp, "+String.valueOf(-4*(j-1)));
					}
					output.addAll(this.findMethod(pointer,pt.getChild(1).getText()));
					output.add("sw $ra -4($sp)");
					output.add("addi $sp, $sp, -4");
					output.add("jalr $s0");
					if(j>1){
						output.add("addi $sp, $sp, "+String.valueOf(4*(j-1)));
					}
					output.add("#postCall");
					output.add("lw $ra 0($sp)");
					output.add("addi $sp, $sp, 4");
					output.add("move "+regs.getNextReg()+", $v0");
					regs.setAssignment(parrent+pt.getText());
					break;
			case 16:if(debug) System.out.println("HPE: "+pt.getText());
					if(pt.getChildCount()==3){// ( pt ) or system.in.readInt
						if(pt.getChild(0).equals("(")){
							output.addAll(this.walkTree(pt.getChild(1)));
							regs.replaceLast(pt.getText());
						} else {
							output.add("li $v0, 5");
							output.add("syscall");
							regs.setAssignment(pt.getText());
							output.add("move "+regs.getAssignment(pt.getText())+", $v0");
						}
					}else if(pt.getChildCount()==4){
						// new id()
						String genClass = pt.getChild(1).getText();
						output.add("#allocate a "+genClass);
						output.add("li $v0, 9");
						output.add("li $a0, "+String.valueOf(this.getSize(genClass)));
						output.add("syscall");
						output.add("addi "+regs.getNextReg()+", $gp, "+String.valueOf(this.genClassMap.get(genClass).classNumber*4));
						output.add("sw "+regs.getNextReg()+", 0($v0)");//$v0 is the pointer
						output.add("sw $a0, 4($v0)");
						output.add("move "+regs.getNextReg()+", $v0");
						regs.setAssignment(pt.getText());
					}else{
						//Just a variable that should already have been created
					}
					break;
			case 17:if(debug) System.out.println("Token: "+pt.getText());
					if(((Token) pt.getPayload()).getType() == MiniJavaLexer.INTEGER){
						this.regs.setAssignment(pt.getText());
						output.add("li "+this.regs.getAssignment(pt.getText())+", "+pt.getText());
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.ID){
						//Pass, variable should be in register already unless class variable
						if(this.currentClassVariables.containsKey(pt.getText())){
							this.regs.setAssignment(pt.getText());
							output.add("lw "+regs.getAssignment(pt.getText())+", "+
							String.valueOf(this.getIndex(pt.getText(),this.currentClassVariables)*4+8)+"($a0)");
						}
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.FALSE){
						this.regs.setAssignment("false");
						output.add("li "+this.regs.getAssignment(pt.getText())+", 0");
					}else if(((Token) pt.getPayload()).getType()==MiniJavaLexer.TRUE){
						this.regs.setAssignment("true");
						output.add("li "+this.regs.getAssignment(pt.getText())+", 1");
					}else{
						if(this.debug)System.out.println("I apprently don't care about "+pt.getText());
					}
					break;
			case 18:if(debug) System.out.println("Method: "+pt.getText());
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
	
	private List<String> findMethod(Register pointer, String method) {
		// Jump address placed in $s0
		List<String> output = new ArrayList<String>();
		output.add("#search");
		output.add("lw $s0, 0("+pointer+")");
		output.add("lw $s1, 4($s0)");//Size of class 
		output.add("li $s2, 8");// t2 current size
		output.add("addi $s3, $s0, 8");
		output.add("CS"+String.valueOf(this.callNumber)+":    nop");
		output.add("beq $s2, $s1, CP"+String.valueOf(this.callNumber));
		output.add("lw $s4, 0($s3)");
		output.add("addi $s3, $s3, 8");
		output.add("beq $s4, "+String.valueOf(this.methodToNumber.get(method))+" CE"+String.valueOf(this.callNumber));
		output.add("addi $s2, $s2 8");
		output.add("j CS"+String.valueOf(this.callNumber));
		output.add("CP"+String.valueOf(this.callNumber)+":    nop");
		output.add("lw $s0, 0($s0)");
		output.add("lw $s1, 4($s0)");//Size of class 
		output.add("li $s2, 8");// t2 current size
		output.add("addi $s3, $s0, 8");
		output.add("j CS"+String.valueOf(this.callNumber));
		output.add("CE"+String.valueOf(this.callNumber)+":    nop");
		output.add("add $s0, $s0, $s2");
		output.add("lw $s0, 4($s0)");//should be jump address
		this.callNumber++;
		output.add("#searchEnds");
		return output;
	}

	private int getSize(String genClass) {
		return (2+this.genClassMap.get(genClass).fieldMap.size())*4;
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
			output.add("#variable assignment");
			output.addAll(this.walkTree(pt.getChild(2)));
			output.add("add "+regs.getAssignment(pt.getChild(0).getText())+", " + regs.getAssignment(pt.getChild(2).getText())+", $zero");
			if(this.currentClassVariables!=null&&this.currentClassVariables.containsKey(pt.getChild(0).getText())){
				//Memory needs to be updated
				output.add("sw "+regs.getAssignment(pt.getChild(0).getText())+", "+String.valueOf(8+4*this.getIndex(pt.getChild(0).getText(),this.currentClassVariables)+"($a0)"));
			}
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

	private int getIndex(String text,	Map<String, ParsedIdentifier> map) {
		int index = 0;
		for(String child:map.keySet()){
			if(child.equals(text)){
				return index;
			}
			index++;
		}
		return index;
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

	/**
	 *Return a list of instructions for the program
	 * @return List<String>
	 */
	public List<String> getProgram() {
		List<String> output = new ArrayList<String>();
		this.fixReturns();
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
	private void fixReturns() {
		for(String key: this.genClassMap.keySet()){
			GeneratedClass c = this.genClassMap.get(key);
			for(String m:c.methodMap.keySet()){
				GeneratedMethod method= c.methodMap.get(m);
				int index =0;
				for(int i=0;i<method.code.size();i++){
					if(method.code.get(i).equals("#exit environment")){
						index = i;
					}
				}
				method.code.remove(index);
				method.code.add("#exit environment");
			}
		}
		
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
