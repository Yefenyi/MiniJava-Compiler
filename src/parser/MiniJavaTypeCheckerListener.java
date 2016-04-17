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
import antlr4.MiniJavaParser.MethodDeclContext;

public class MiniJavaTypeCheckerListener extends MiniJavaBaseListener {
	// TODO go back to check method argument list types for valid types
	private int errorCount;
	private Map<String,ParsedClass> classMap;
	private String activeClass;
	
	public MiniJavaTypeCheckerListener() {
		this.classMap = new HashMap<String,ParsedClass>();
		this.errorCount = 0;
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
		//Program should allways have a main class
		String className = ctx.children.get(0).getChild(1).getText();
		classMap.put(className, new ParsedMainClass(className));
		//Now look at all classes
		for(int i = 1 ; i < ctx.children.size() - 1 ; ++i) {
			className = ctx.children.get(i).getChild(1).getText();
			ClassDeclContext classDec = (ClassDeclContext) ctx.children.get(i);
			ParsedClass parsedClass = new ParsedClass(className);
			if(classDec.getChild(2).getText().toLowerCase().equals("extends")){
				String parentName = classDec.getChild(3).getText();
				ParsedClass parrentClass = classMap.get(parentName);
				parsedClass.setExtendsClass(parentName);
				//parsedClass.setNameToField();
				//parsedClass.setNameToMethod();
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
							identList.add(new ParsedIdentifier(identName, identType));
						}
					}
					ParsedMethod pMethod = new ParsedMethod(name, returnType, identList, method);
					if(parsedClass.hasMethod(name)) {
						this.addError("Method has already been defined: " + name);
					} else {
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

}
