package parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import antlr4.MiniJava;
import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class MiniJavaListener extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaListener() {
		this.output = new ArrayList<String>();
	}
	
	@Override
	public void exitEveryRule(@NotNull ParserRuleContext ctx) {
		if(ctx.getText().isEmpty())
			return;
		//System.out.println(MiniJavaParser.ruleNames[ctx.getRuleIndex()]);
	}
	
	@Override
	public void exitStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		if(ctx.getText().isEmpty()) {
			//System.out.println("StmtList ::=");
		} else {
			//System.out.println("StmtList ::= StmtList Stmt");
		}
	}
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
