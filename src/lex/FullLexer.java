package lex;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

public class FullLexer implements ILexer {
	
	private String getTypeString(int type) {
		switch(type) {
		case 5:
			return "ID";
		case 2:
			return "Integer";
		case 3:
			return "Operator";
		case 4:
			return "Delimiter";
		case 1:
			return "ReservedWord";
		case 6:
			return "WHITESPACE SHOULDN'T BE HERE!!";
		case 7:
			return "COMMENT?!?!?!";
		default:
			return "something went terribly wrong";
		}
	}

	@Override
	public List<String> lex(String toLex) {
		List<String> out = new ArrayList<String>();
		ANTLRInputStream input = new ANTLRInputStream(toLex);
		antlr4.MiniJavaLexer lex = new antlr4.MiniJavaLexer(input);
		List<? extends Token> tokens = lex.getAllTokens();
		for(Token t : tokens) {
			out.add(this.getTypeString(t.getType()) + ", " + t.getText());
		}
		return out;
	}

}
