package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaParser;
import antlr4.MiniJavaParser.ClassDeclContext;
import antlr4.MiniJavaParser.ClassVarDeclContext;
import antlr4.MiniJavaParser.FormalContext;
import antlr4.MiniJavaParser.MainClassDeclContext;
import antlr4.MiniJavaParser.MethodDeclContext;

public class MiniJavaTypeCheckerListener extends MiniJavaBaseListener {
	// TODO go back to check method argument list types for valid types
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
		// TODO: Return type check!
		env.removeLevel();
	}
	
	@Override
	public void enterStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		env.addLevel(new HashMap<String,ParsedIdentifier>());
	}
	
	@Override
	public void exitStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		env.removeLevel();
	}
}
