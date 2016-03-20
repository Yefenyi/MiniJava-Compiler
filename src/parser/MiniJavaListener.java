package parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class MiniJavaListener extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaListener() {
		this.output = new ArrayList<String>();
	}
	
	@Override
	public void enterEveryRule(@NotNull ParserRuleContext ctx) {
		System.out.println(MiniJavaParser.ruleNames[ctx.getRuleIndex()]);
	}
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
