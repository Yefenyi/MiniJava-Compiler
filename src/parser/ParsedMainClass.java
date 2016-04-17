package parser;

import antlr4.MiniJavaParser.MainClassDeclContext;

public class ParsedMainClass extends ParsedClass {
	
	MainClassDeclContext tree;

	public ParsedMainClass(String name, MainClassDeclContext tree) {
		super(name);
		this.tree = tree;
	}

}
