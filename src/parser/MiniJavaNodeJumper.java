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
import antlr4.MiniJavaParser.StmtContext;
import antlr4.MiniJavaParser.StmtListContext;

public class MiniJavaNodeJumper extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaNodeJumper() {
		this.output = new ArrayList<String>();
	}
	
	@Override
	public void enterEveryRule(@NotNull ParserRuleContext ctx) {
		if(ctx.children == null) {
			return;
		}
		for(int i = 0 ; i < ctx.children.size(); ++i) {
			ParseTree node = ctx.children.get(i);
			if(node instanceof StmtListContext || node instanceof EQEContext || node instanceof CEContext || node instanceof AOEContext || node instanceof ASEContext || node instanceof MDEContext || node instanceof NEContext || node instanceof DEContext) {
				ctx.children.remove(i);
				while(node.getChildCount() == 1) {
					node = node.getChild(0);
				}
				ctx.children.add(i, node);
			}
			if(node instanceof StmtListContext) {
				StmtListContext origNode = (StmtListContext)node;
				
				while(origNode.getChild(origNode.getChildCount()-1) instanceof StmtListContext) {
					StmtListContext rightChild = (StmtListContext)origNode.getChild(origNode.getChildCount() - 1);
					origNode.children.remove(rightChild);
					if(rightChild.children != null) {
						origNode.children.addAll(rightChild.children);
					}
				}
			}
		}
	}
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
