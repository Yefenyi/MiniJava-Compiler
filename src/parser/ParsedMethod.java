package parser;

import java.util.List;

import antlr4.MiniJavaParser.MethodDeclContext;

public class ParsedMethod {
	
	String name;
	String returnType;
	List<ParsedIdentifier> identifierList;
	MethodDeclContext tree;
	
	public ParsedMethod(String name, String returnType, List<ParsedIdentifier> identifierList, MethodDeclContext tree) {
		this.name  = name;
		this.returnType = returnType;
		this.identifierList = identifierList;
		this.tree = tree;
	}

	public String getName() {
		return this.name;
	}

	public String getReturnType() {
		return returnType;
	}

	public List<ParsedIdentifier> getIdentifierList() {
		return identifierList;
	}

	public MethodDeclContext getTree() {
		return tree;
	}

}
