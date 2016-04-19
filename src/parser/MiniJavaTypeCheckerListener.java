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
import antlr4.MiniJavaParser.AOEContext;
import antlr4.MiniJavaParser.AOEPContext;
import antlr4.MiniJavaParser.ASEContext;
import antlr4.MiniJavaParser.ASEPContext;
import antlr4.MiniJavaParser.CEContext;
import antlr4.MiniJavaParser.CEPContext;
import antlr4.MiniJavaParser.ClassDeclContext;
import antlr4.MiniJavaParser.ClassVarDeclContext;
import antlr4.MiniJavaParser.DEContext;
import antlr4.MiniJavaParser.EQEContext;
import antlr4.MiniJavaParser.FormalContext;
import antlr4.MiniJavaParser.HPEContext;
import antlr4.MiniJavaParser.MDEContext;
import antlr4.MiniJavaParser.MDEPContext;
import antlr4.MiniJavaParser.MainClassDeclContext;
import antlr4.MiniJavaParser.MethodDeclContext;
import antlr4.MiniJavaParser.NEContext;

public class MiniJavaTypeCheckerListener extends MiniJavaBaseListener {
	private int errorCount;
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
		System.err.println(errorDescription);
		++this.errorCount;
	}
	
	@Override
	public void enterProgram(@NotNull MiniJavaParser.ProgramContext ctx) {
		//Program should always have a main class
		String className = ctx.children.get(0).getChild(1).getText();
		mainClass = new ParsedMainClass(className, (MainClassDeclContext) ctx.children.get(0));
		//Now look at all classes
		for(int i = 1 ; i < ctx.children.size() - 1 ; ++i) {
			className = ctx.children.get(i).getChild(1).getText();
			ClassDeclContext classDec = (ClassDeclContext) ctx.children.get(i);
			ParsedClass parsedClass = new ParsedClass(className);
			ParsedClass parrentClass = null;
			if(classDec.getChild(2).getText().toLowerCase().equals("extends")){
				String parentName = classDec.getChild(3).getText();
				parrentClass = classMap.get(parentName);
				parsedClass.setExtendsClass(parentName);
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
						parsedClass.addField(pIdent);
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
		for(ParsedIdentifier pIdent : pMethod.getIdentifierList()) {
			newLevel.put(pIdent.getName(), pIdent);
		}
		env.addLevel(newLevel);
	}
	
	@Override
	public void exitMethodDecl(@NotNull MiniJavaParser.MethodDeclContext ctx) {
		String methodName = ctx.getChild(2).getText();
		ParsedClass pClass = classMap.get(activeClass);
		ParsedMethod parsedMethod = pClass.getNameToMethod().get(methodName);
		String expectedReturnType = parsedMethod.getReturnType();
		List<String> actualReturnType = this.getReturnType(ctx.getChild(ctx.getChildCount() - 3));
		
		if(!actualReturnType.contains(expectedReturnType)) {
			this.addError("Return type " + actualReturnType+ " does not match expected return type " + expectedReturnType.toString());
		}
		env.removeLevel();
	}
	
	@Override
	public void enterEQE(@NotNull MiniJavaParser.EQEContext ctx) {
		if(ctx.children.size() == 3) {
			if(!expressionType(ctx.getChild(0)).equals(expressionType(ctx.getChild(2)))) {
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
	public void enterAOE(@NotNull MiniJavaParser.AOEContext ctx) {
		if(!expressionType(ctx.getChild(0)).equals("boolean")) {
			this.addError("Expected boolean value: " + ctx.getText());
		}
	}
	
	@Override
	public void enterAOEP(@NotNull MiniJavaParser.AOEPContext ctx) {
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
			if(!expressionType(ctx.getChild(1)).equals("int")) {
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

	//TODO: Need many more statements
	@Override
	public void enterStmt(@NotNull MiniJavaParser.StmtContext ctx) {
		if(ctx.getChildCount() == 4) {
			String expectedType = env.getIdentifierType(ctx.getChild(0).getText());
			String actualType = expressionType(ctx.getChild(2));
			List<String> possibleTypes = getPossibleTypes(actualType);
			if(!possibleTypes.contains(expectedType)) {
				this.addError("Assignment type mismatch: Expected type " + possibleTypes.toString() + " does not match type " + expectedType);
			}
		} else if(ctx.getChildCount() == 5) {
			if(ctx.getChild(2).getPayload().equals(MiniJavaLexer.ASSIGN)) {
				String expectedType = ctx.getChild(0).getText();
				String actualType = this.expressionType(ctx.getChild(3));
				List<String> possibleTypes = getPossibleTypes(actualType);
				if(!possibleTypes.contains(expectedType)) {
					this.addError("Assignment type mismatch: Expected type " + possibleTypes.toString() + " does not match type " + expectedType);
				} else {
					ParsedIdentifier pIdent = new ParsedIdentifier(ctx.getChild(1).getText(), expectedType);
					env.addIdentifier(pIdent);
				}
			}
		}
	}
	
	@Override
	public void enterStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		env.addLevel(new HashMap<String,ParsedIdentifier>());
	}
	
	@Override
	public void exitStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		env.removeLevel();
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
					singleType = this.env.getIdentifierType(t.getText()); //TODO matt make sure this is right way to get a var type
				}
			}
		}else{
			singleType = this.expressionType(pt);
		}
		return this.getPossibleTypes(singleType);
	}
	
	private List<String> getPossibleTypes(String singleType) {
		List<String> output = new ArrayList<String>();
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
		return output;
	}

	private String expressionType(ParseTree pt){
		if(pt instanceof DEContext){
			String HPE = ((DEContext) pt).children.get(0).getText(); //Class variable or this
			ParseTree DEP = pt.getChild(1); //method being called
			ParseTree nextCall =  DEP.getChild(DEP.getChildCount()-1);
			ParsedClass pc;
			if(HPE.equals("this")){
				pc = this.classMap.get(this.activeClass);
			}else{
				pc = this.classMap.get(this.env.getIdentifierType(HPE));
			}
			if(pc==null){
				this.addError("Variable "+HPE+" is not defined");
				return "null";
			}
			String returnType = pc.getNameToMethod().get(DEP.getChild(1).getText()).getReturnType();
			while(nextCall.getChildCount()!=0){
				returnType = pc.getNameToMethod().get(DEP.getChild(1).getText()).getReturnType();
				pc = this.classMap.get(returnType);
				DEP = nextCall;
				nextCall = nextCall.getChild(nextCall.getChildCount()-1);
			}
			return returnType;
		}else if(pt instanceof HPEContext){
			if(pt.getChildCount()==1){
				if(pt.getChild(0).getPayload().equals(MiniJavaLexer.INT)){
					return "int";
				}else if(pt.getChild(0).getPayload().equals(MiniJavaLexer.FALSE)){
					return "boolean";
				}else if(pt.getChild(0).getPayload().equals(MiniJavaLexer.TRUE)){
					return "boolean";
				}else if(pt.getChild(0).getPayload().equals(MiniJavaLexer.NULL)){
					return null;
				}else if(pt.getChild(0).getPayload().equals(MiniJavaLexer.ID)){
					return this.env.getIdentifierType(pt.getText()); //TODO might be wrong
				}else if(pt.getChild(0).getPayload().equals(MiniJavaLexer.THIS)){
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
		}else if(pt instanceof AOEContext){
			return "boolean";
		}else if(pt instanceof AOEPContext){
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
			if(pt.getPayload().equals(MiniJavaLexer.INTEGER)) {
				return "int";
			} else if(pt.getPayload().equals(MiniJavaLexer.ID)) {
				String type = env.getIdentifierType(pt.getText());
				if(type == null) {
					this.addError("Variable " + pt.getText() + " has not been declared");
				} else {
					return type;
				}
			}
		}
		//System.out.println(pt.getText());
		System.out.println(pt.getText() + ", Token" + pt.getPayload().toString());
		return "null";
	}
}
