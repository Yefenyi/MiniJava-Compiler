package parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import antlr4.MiniJava;
import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;

public class MiniJavaNodePrunerListener extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaNodePrunerListener() {
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
	
	@Override
	public void enterMDE(@NotNull MiniJavaParser.MDEContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	@Override
	public void enterASE(@NotNull MiniJavaParser.ASEContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	@Override
	public void enterAOE(@NotNull MiniJavaParser.AOEContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	@Override
	public void enterCE(@NotNull MiniJavaParser.CEContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	@Override
	public void enterDE(@NotNull MiniJavaParser.DEContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	@Override
	public void enterStmtList(@NotNull MiniJavaParser.StmtListContext ctx) {
		if(ctx.children.size() == 2) {
			if(ctx.children.get(1).getChildCount() == 0) {
				ctx.children.remove(1);
			}
		}
	}
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
