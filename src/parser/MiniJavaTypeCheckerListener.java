package parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaParser.AOEContext;
import antlr4.MiniJavaParser.ASEContext;
import antlr4.MiniJavaParser.CEContext;
import antlr4.MiniJavaParser.DEContext;
import antlr4.MiniJavaParser.EQEContext;
import antlr4.MiniJavaParser.MDEContext;
import antlr4.MiniJavaParser.NEContext;
import antlr4.MiniJavaParser.StmtListContext;

public class MiniJavaTypeCheckerListener extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaTypeCheckerListener() {
		this.output = new ArrayList<String>();
	}
	
	
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
