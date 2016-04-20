package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;
import antlr4.MiniJavaParser.AEContext;
import antlr4.MiniJavaParser.AEPContext;
import antlr4.MiniJavaParser.ASEContext;
import antlr4.MiniJavaParser.ASEPContext;
import antlr4.MiniJavaParser.CEContext;
import antlr4.MiniJavaParser.CEPContext;
import antlr4.MiniJavaParser.ClassDeclContext;
import antlr4.MiniJavaParser.ClassVarDeclContext;
import antlr4.MiniJavaParser.DEContext;
import antlr4.MiniJavaParser.DEPContext;
import antlr4.MiniJavaParser.EQEContext;
import antlr4.MiniJavaParser.FormalContext;
import antlr4.MiniJavaParser.HPEContext;
import antlr4.MiniJavaParser.MDEContext;
import antlr4.MiniJavaParser.MDEPContext;
import antlr4.MiniJavaParser.MainClassDeclContext;
import antlr4.MiniJavaParser.MethodDeclContext;
import antlr4.MiniJavaParser.NEContext;
import antlr4.MiniJavaParser.OEContext;
import antlr4.MiniJavaParser.OEPContext;

public class MiniJavaTypeCheckerListener extends MiniJavaBaseListener {
	public int errorCount;
	public List<String> errors = new ArrayList<String>();
	private Map<String,ParsedClass> classMap;
	private String activeClass;
	private EnvironmentTracker env;
	private ParsedMainClass mainClass;
	
	public MiniJavaTypeCheckerListener() {
		this.classMap = new HashMap<String,ParsedClass>();
		this.errorCount = 0;
		this.env = new EnvironmentTracker();
	}
	
	public int getErrorCount() {
		return this.errorCount;
	}
	
	private void addError(String errorDescription) {
		//System.out.println(errorDescription);
		++this.errorCount;
		this.errors.add(errorDescription);
	}
	
	@Override
	public void enterProgram(@NotNull MiniJavaParser.ProgramContext ctx) {
		//Program should always have a main class
		String className = ctx.children.get(0).getChild(1).getText();
		mainClass = new ParsedMainClass(className, (MainClassDeclContext) ctx.children.get(0));
		this.classMap.put(className,mainClass);
		//Now look at all classes
		for(int i = 1 ; i < ctx.children.size() - 1 ; ++i) {
			className = ctx.children.get(i).getChild(1).getText();
			ClassDeclContext classDec = (ClassDeclContext) ctx.children.get(i);
			ParsedClass parsedClass = new ParsedClass(className);
			ParsedClass parrentClass = null;
			if(classDec.getChild(2).getText().toLowerCase().equals("extends")){
				
				String parentName = classDec.getChild(3).getText();
				if(this.classMap.containsKey(parentName)){
					parrentClass = classMap.get(parentName);
					parsedClass.setExtendsClass(parentName);
				}else {
					this.addError("Cannot extend class becuase class: "+parentName+" is not defined");
				}
			}
			for(ParseTree pt : classDec.children) {
				if(pt instanceof MethodDeclContext) {
					MethodDeclContext method = (MethodDeclContext) pt;
					String returnType = pt.getChild(1).getChild(0).getText();
					String name = pt.getChild(2).getText();
					List<ParsedIdentifier> identList = new ArrayList<ParsedIdentifier>();
					for(ParseTree ptsub : method.children) {
						if(ptsub instanceof FormalContext) { // TODO: Could check for duplicate name here
							String identType = ptsub.getChild(0).getChild(0).getText();
							String identName = ptsub.getChild(1).getText();
							boolean dupFound = false;
							for(ParsedIdentifier pIdent : identList) {
								if(identName.equals(pIdent.getName()))
									dupFound = true;
							}
							if(dupFound) {
								this.addError("Duplicate argument identifier in method: " + name);
							} else {
								if(parsedClass.hasField(identName)) {
									this.addError("Variable names cannot be shadowed. Argument " + identName + " is already defined as a field");
									identList.add(new ParsedIdentifier(identName, identType));
								} else {
									identList.add(new ParsedIdentifier(identName, identType));
								}
							}
						}
					}
					ParsedMethod pMethod = new ParsedMethod(name, returnType, identList, method);
					if(parsedClass.hasMethod(name)) {
						this.addError("Method has already been defined: " + name);
					} else if (parrentClass!=null && !pMethod.validOverride(parrentClass.getNameToMethod().get(name))){
						this.addError("Cannot overload methods: " + name);
					}else {
						parsedClass.addMethod(pMethod);
					}
				} else if(pt instanceof ClassVarDeclContext) {
					ClassVarDeclContext var = (ClassVarDeclContext) pt;
					String type = var.getChild(0).getChild(0).getText();
					String name = var.getChild(1).getText();
					ParsedIdentifier pIdent = new ParsedIdentifier(name, type);
					if(parsedClass.hasField(name)) {
						this.addError("Field has already been defined: " + name);
					} else {
						ParsedClass parrent = this.classMap.get(parsedClass.extendsClass);
						boolean flag = true;
						while(parrent!=null){
							if(parrent.getNameToField().containsKey(name)){
								this.addError("Cannot overide field "+ name);
								flag = false;
							}
							parrent = this.classMap.get(parrent.extendsClass);
						}
						if(flag){
							parsedClass.addField(pIdent);	
						}
					}
				}
			}
			className = ctx.children.get(i).getChild(1).getText();
			if(classMap.containsKey(className)) {
				this.addError("Class has already been declared: " + className);
			} else {
				classMap.put(className, parsedClass);
			}
		}
	}

	@Override 
	public void enterClassDecl(@NotNull MiniJavaParser.ClassDeclContext ctx) {
		activeClass = ctx.children.get(1).getText();
		ParsedClass pClass = classMap.get(activeClass);
		env.addLevel(pClass.getNameToField());
		while(pClass.getExtendsClass() != null) {
			pClass = classMap.get(pClass.getExtendsClass());
			env.addLevel(pClass.getNameToField());
		}
	}
	
	@Override
	public void exitClassDecl(@NotNull MiniJavaParser.ClassDeclContext ctx) {
		ParsedClass pClass = classMap.get(activeClass);
		env.removeLevel();
		while(pClass.getExtendsClass() != null) {
			pClass = classMap.get(pClass.getExtendsClass());
			env.removeLevel();
		}
		activeClass = null;
	}
	
	@Override
	public void enterMainClassDecl(@NotNull MiniJavaParser.MainClassDeclContext ctx) {
		env.addLevel(new HashMap<String,ParsedIdentifier>());
	}
	
	@Override
	public void exitMainClassDecl(@NotNull MiniJavaParser.MainClassDeclContext ctx) {
		env.removeLevel();
	}
	
	@Override
	public void enterType(antlr4.MiniJavaParser.TypeContext ctx) {
		ParseTree type = ctx.getChild(0);
		if(!(type.getText().equals("int") || type.getText().equals("boolean") || classMap.containsKey(type.getText()))) {
			this.addError("Type " + type.getText() + " has not been defined");
		}
	}
	
	@Override
	public void enterMethodDecl(@NotNull MiniJavaParser.MethodDeclContext ctx) {
		ParsedClass pClass = classMap.get(activeClass);
		String methodName = ctx.getChild(2).getText();
		ParsedMethod pMethod = pClass.getNameToMethod().get(methodName);
		Map<String,ParsedIdentifier> newLevel = new HashMap<String,ParsedIdentifier>();
		if(pMethod!=null){
			for(ParsedIdentifier pIdent : pMethod.getIdentifierList()) {
				newLevel.put(pIdent.getName(), pIdent);
			}
		}
		env.addLevel(newLevel);
	}
	
	@Override
	public void exitMethodDecl(@NotNull MiniJavaParser.MethodDeclContext ctx) {
		String methodName = ctx.getChild(2).getText();
		ParsedClass pClass = classMap.get(activeClass);
		ParsedMethod parsedMethod = pClass.getNameToMethod().get(methodName);
		if(parsedMethod!=null){
			String expectedReturnType = parsedMethod.getReturnType();
			List<String> actualReturnType = this.getReturnType(ctx.getChild(ctx.getChildCount() - 3));
			if(!actualReturnType.contains(expectedReturnType)) {
				//System.out.println(ctx.getChild(ctx.getChildCount() - 3).getText());
				this.addError("Return type " + actualReturnType+ " does not match expected return type " + expectedReturnType.toString());
			}
		}
		env.removeLevel();
	}
	
	@Override
	public void enterEQE(@NotNull MiniJavaParser.EQEContext ctx) {
		if(ctx.children.size() == 3) {
			if(!this.isType(ctx.getChild(0),ctx.getChild(2))){
				this.addError("Types in comparison '" + ctx.getText() + "' are mismatched");
			}
		}
	}
	
	@Override
	public void enterCE(@NotNull MiniJavaParser.CEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("int")) {
			this.addError("Expected integer value for comparison: " + ctx.getText());
		}
	}
	
	@Override
	public void enterCEP(@NotNull MiniJavaParser.CEPContext ctx) {
		if(ctx.getChildCount() == 2) {
			if(!expressionType(ctx.getChild(1)).equals("int")) {
				this.addError("Expected integer value for comparison: " + ctx.getParent().getText());
			}
		}
	}
	
	@Override
	public void enterAE(@NotNull MiniJavaParser.AEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("boolean")) {
			this.addError("Expected boolean value: " + ctx.getText());
		}
	}
	
	@Override
	public void enterOE(@NotNull MiniJavaParser.OEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("boolean")) {
			this.addError("Expected boolean value: " + ctx.getText());
		}
	}
	
	@Override
	public void enterAEP(@NotNull MiniJavaParser.AEPContext ctx) {
		if(ctx.getChildCount() == 3) {
			if(!expressionType(ctx.getChild(1)).equals("boolean")) {
				this.addError("Expected boolean value: " + ctx.getParent().getText());
			}
		}
	}
	
	@Override
	public void enterOEP(@NotNull MiniJavaParser.OEPContext ctx) {
		if(ctx.getChildCount() == 3) {
			if(!expressionType(ctx.getChild(1)).equals("boolean")) {
				this.addError("Expected boolean value: " + ctx.getParent().getText());
			}
		}
	}
	
	@Override
	public void enterMDE(@NotNull MiniJavaParser.MDEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("int")) {
			this.addError("Expected integer value for expression: " + ctx.getText());
		}
	}
	
	@Override
	public void enterMDEP(@NotNull MiniJavaParser.MDEPContext ctx) {
		if(ctx.getChildCount() == 3) {
			if(!expressionType(ctx.getChild(1)).equals("int")) {
				this.addError("Expected integer value for expression: " + ctx.getParent().getText());
			}
		}
	}
	
	@Override
	public void enterASE(@NotNull MiniJavaParser.ASEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("int")) {
			this.addError("Expected integer value for expression: " + ctx.getText());
		}
	}
	
	@Override
	public void enterASEP(@NotNull MiniJavaParser.ASEPContext ctx) {
		if(ctx.getChildCount() == 3) {
			if(!this.isType("int",ctx.getChild(1))){
				this.addError("Expected integer value for expression: " + ctx.getParent().getText());
			}
		}
	}
	
	@Override
	public void enterNE(@NotNull MiniJavaParser.NEContext ctx) {
		if(ctx.getChildCount() == 2) {
			if(ctx.getChild(0).getPayload().equals(MiniJavaLexer.BANG)) {
				if(!expressionType(ctx.getChild(1)).equals("boolean")) {
					this.addError("Expected boolean value: " + ctx.getText());
				}
			}
			if(ctx.getChild(0).getPayload().equals(MiniJavaLexer.SUB)) {
				if(!expressionType(ctx.getChild(1)).equals("int")) {
					this.addError("Expected integer value: " + ctx.getText());
				}
			}
		}
	}
	@Override
	public void enterStmt(@NotNull MiniJavaParser.StmtContext ctx) {
		if(ctx.getChildCount() == 4) {//ID = EQE; 

			if(!this.env.identifierExists(ctx.getChild(0).getText())){
				this.addError("ID "+ctx.getChild(0).getText()+" does not exist");
				return;
			}
			String expectedType = env.getIdentifierType(ctx.getChild(0).getText());
			String actualType = expressionType(ctx.getChild(2));
			List<String> possibleTypes = new ArrayList<String>();
			if(actualType.equals("null")){
				for (String key:this.classMap.keySet()){
					possibleTypes.add(key);
				}
				possibleTypes.add("int");
				possibleTypes.add("boolean");
			}else{
				possibleTypes= getPossibleTypes(actualType);
			}
			if(!possibleTypes.contains(expectedType)) {
				//this.addError("Assignment type mismatch: Expected type " + possibleTypes.toString() + " does not match type " + expectedType);
			}
		} else if(ctx.getChildCount() == 5) {
			if(ctx.getChild(2).getText().equals("=")) {//TYPE ID = EQE ;
				String expectedType = ctx.getChild(0).getText();
				String actualType = this.expressionType(ctx.getChild(3));
				List<String> possibleTypes = getPossibleTypes(actualType);
				if(!possibleTypes.contains(expectedType)) {
					this.addError("Assignment type mismatch: Expected type " + possibleTypes.toString() + " does not match type " + expectedType);
				} else if(this.env.getIdentifierType(ctx.getChild(1).getText())!=null){
					this.addError("Variable "+ctx.getChild(1).getText()+"has allready been assigned");
				}else {
					ParsedIdentifier pIdent = new ParsedIdentifier(ctx.getChild(1).getText(), expectedType);
					env.addIdentifier(pIdent);
				}
			}else if(ctx.getChild(0).getText().equals("while")){//while ( eqe ) stmt
				if(!this.expressionType(ctx.getChild(2)).equals("boolean")){
					this.addError("Incorrect expression type expceted boolean: actual "+this.expressionType(ctx.getChild(2)));
				}
			}else if(ctx.getChild(0).getText().equals("System.out.println")){
				if(!this.expressionType(ctx.getChild(2)).equals("int")){
					this.addError("System.out.println can only print ints");
				}
			}
		} else if(ctx.getChildCount() == 7) { //If ( eqe ) stmt else stmt
			if(!this.expressionType(ctx.getChild(2)).equals("boolean")){
				this.addError("Incorect type for if statement");
			}
		}
	}
	
	@Override
	public void enterStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		if(!(ctx.getParent() instanceof MethodDeclContext)){
			env.addLevel(new HashMap<String,ParsedIdentifier>());
		}
	}
	
	@Override
	public void exitStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		if(!(ctx.getParent() instanceof MethodDeclContext)){
			env.removeLevel();
		}
	}
	
	private List<String> getReturnType(ParseTree pt) {
		String singleType = null;
		if(pt.getChildCount() == 0) {
			if(pt.getPayload() instanceof Token) {
				Token t = (Token)pt.getPayload();
				if(t.getType() == MiniJavaLexer.INTEGER) {
					singleType = "int";
				} else if(t.getType() == MiniJavaLexer.FALSE || t.getType() == MiniJavaLexer.TRUE) {
					singleType = "boolean";
				} else if(t.getType() == MiniJavaLexer.ID){
					singleType = this.env.getIdentifierType(t.getText());
					if(singleType==null){
						List<String> output = this.getClassesList();
						output.add("int");
						output.add("boolean");
						return output;
					}
				}else if(t.getType() == MiniJavaLexer.THIS){
					singleType = this.activeClass;
				}else if(t.getType()==MiniJavaLexer.NULL){
					return this.getClassesList();
				}
			}
		}else{
			singleType = this.expressionType(pt);
		}
		return this.getPossibleTypes(singleType);
	}
	
	private List<String> getClassesList() {
		List<String> output = new ArrayList<String>();
		for(String Key:this.classMap.keySet()){
			output.add(Key);
		}
		return output;
	}

	private List<String> getPossibleTypes(String singleType) {
		List<String> output = new ArrayList<String>();
		if(singleType==null){
			return output;
		}
		output.add(singleType);
		ParsedClass child =  this.classMap.get(singleType);
		ParsedClass parent;
		if(child!=null){
			while(child.getExtendsClass()!=null){
				parent = this.classMap.get(child.getExtendsClass());
				output.add(parent.getName());
				child = parent;
			}	
		}
		if(singleType.equals("null")){
			for(String key:this.classMap.keySet()){
				output.add(key);
			}
		}
		return output;
	}

	private String expressionType(ParseTree pt){
		if(pt instanceof DEContext){
			String HPE = this.expressionType(((DEContext) pt).getChild(0)); //Class variable or this
			ParseTree DEP = pt.getChild(1); //method being called
			ParseTree nextCall =  DEP.getChild(DEP.getChildCount()-1);
			ParsedClass pc;
			if(HPE.equals("this")){
				pc = this.classMap.get(this.activeClass);
			}else{
				pc = this.classMap.get(HPE);
			}
			if(pc==null){
				this.addError("Variable "+HPE+" is not defined");
				return "null";
			}
			ParsedMethod currentMethod = this.getMethod(DEP.getChild(1).getText(),pc);
			if(currentMethod==null){
				this.addError("Method "+DEP.getChild(1).getText()+" is never declared");
				return "null";
			}
			int i=0;
			int j=0;
			for(ParseTree child  : ((DEPContext) DEP).children ){
				String c = child.getText();
				if(c.equals(",")||c.equals("(")||c.equals(".")||c.equals(")")){
					//Pass
				}else if(j!=1 && j<DEP.getChildCount()-1){
					if(!this.isType(currentMethod.identifierList.get(i).getType(),child)){
						this.addError("Invalid argument to method "+currentMethod.getName());
					}
					i++;
				}
				j++;
			}
			String returnType = currentMethod.getReturnType();
			while(nextCall.getChildCount()!=0){
				i=0;
				j=0;
				for(ParseTree child  : ((DEPContext) DEP).children ){
					String c = child.getText();
					if(c.equals(",")||c.equals("(")||c.equals(".")||c.equals(")")){
						//Pass
					}else if(j!=1 && j<DEP.getChildCount()-1){
						if(!this.isType(currentMethod.identifierList.get(i).getType(),child)){
							this.addError("Invalid argument to method "+currentMethod.getName());
						}
						i++;
					}
					j++;
				}
				returnType = pc.getNameToMethod().get(DEP.getChild(1).getText()).getReturnType();
				pc = this.classMap.get(returnType);
				DEP = nextCall;
				currentMethod = this.getMethod(DEP.getChild(1).getText(),pc);
				if(currentMethod==null){
					this.addError("Method "+DEP.getChild(1).getText()+" is never declared");
					return "null";
				}
				nextCall = nextCall.getChild(nextCall.getChildCount()-1);
			}
			return returnType;
		}else if(pt instanceof HPEContext){
			if(pt.getChildCount()==1){
				Token t = ((Token) pt.getChild(0).getPayload());
				if(t.getType()==(MiniJavaLexer.INT)){
					return "int";
				}else if(t.getType()==(MiniJavaLexer.FALSE)){
					return "boolean";
				}else if(t.getType()==(MiniJavaLexer.TRUE)){
					return "boolean";
				}else if(t.getType()==(MiniJavaLexer.NULL)){
					return "null";
				}else if(t.getType()==MiniJavaLexer.ID){
					String type = env.getIdentifierType(pt.getText());
					if(type == null) {
						this.addError("Variable " + pt.getText() + " has not been declared");
					} else {
						return type;
					}
				}else if(t.getType()==(MiniJavaLexer.THIS)){
					return this.activeClass;
				}
			}else if(pt.getChildCount()==4){
				return pt.getChild(1).getText();
			}else if(pt.getChildCount()==3){
				return this.expressionType(pt.getChild(1));
			}
		}else if(pt instanceof EQEContext){
			return "boolean";
		}else if(pt instanceof CEContext){
			return "boolean";
		}else if(pt instanceof CEPContext){
			return "boolean";
		}else if(pt instanceof AEContext){
			return "boolean";
		}else if(pt instanceof AEPContext){
			return "boolean";
		}else if(pt instanceof OEContext){
			return "boolean";
		}else if(pt instanceof OEPContext){
			return "boolean";
		}else if(pt instanceof ASEContext){
			return "int";
		}else if(pt instanceof ASEPContext){
			return "int";
		}else if(pt instanceof MDEContext){
			return "int";
		}else if(pt instanceof MDEPContext){
			return "int";
		}else if(pt instanceof NEContext){
			if(pt.getChild(0).getPayload().equals(MiniJavaLexer.SUB)){
				return "int";
			}else{
				return"boolean";
			}
		} else {
			if(pt.getPayload() instanceof Token) {
				Token temp = (Token)pt.getPayload();
				if(temp.getType() == MiniJavaLexer.INTEGER) {
					return "int";
				} else if(temp.getType() == MiniJavaLexer.ID) {
					String type = env.getIdentifierType(pt.getText());
					if(type == null) {
						this.addError("Variable " + pt.getText() + " has not been declared");
					} else {
						return type;
					}
				} else if(temp.getType() == MiniJavaLexer.TRUE || temp.getType() == MiniJavaLexer.FALSE) {
					return "boolean";
				} else if(temp.getType() == MiniJavaLexer.THIS) {
					return this.activeClass;
				} else if(temp.getType() == MiniJavaLexer.NULL) {
					return "null";
				}
			}
		}
		//System.out.println(pt.getText());
		//System.out.println(pt.getText() + ", Token " + pt.getPayload().toString());
		return pt.getText();
	}
	
	private ParsedMethod getMethod(String name, ParsedClass pc){
		if(pc.hasMethod(name)){
			return pc.getNameToMethod().get(name);
		}else if(pc.extendsClass!=null){
			return this.getMethod(name, this.classMap.get(pc.extendsClass));
		}else{
			return null;
		}
	}
	
	private boolean isType(String type, ParseTree pt){
		String baseType = this.expressionType(pt);
		if(baseType==null){
			this.addError("Variable "+pt.getText()+" does not exist");
			return true;
		}
		if(baseType.equals("null")){
			return this.classMap.containsKey(type);
		} else {
			return this.getPossibleTypes(baseType).contains(type);
		}
	}
	private boolean isType(ParseTree oneTypeTree, ParseTree multipleTypeTree){
		String compareType = this.expressionType(oneTypeTree);
		List<String> types = this.getPossibleTypes(this.expressionType(multipleTypeTree));
		if(compareType.equals("null")){
			return true;
		}else{
			return types.contains(compareType);
		}
	}
}
