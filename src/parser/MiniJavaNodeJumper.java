package parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr4.MiniJavaBaseListener;
import antlr4.MiniJavaParser.EQEContext;

public class MiniJavaNodeJumper extends MiniJavaBaseListener {
	
	private List<String> output;
	
	public MiniJavaNodeJumper() {
		this.output = new ArrayList<String>();
	}
	
	@Override
	public void enterEveryRule(@NotNull ParserRuleContext ctx) {
		for(int i = 0 ; i < ctx.children.size(); ++i) {
			ParseTree node = ctx.children.get(i);
			if(node instanceof EQEContext) {
				ctx.children.remove(i);
				while(node.getChildCount() == 1) {
					node = node.getChild(0);
				}
				ctx.children.add(i, node);
			}
		}
	}
	
	public List<String> getGeneratedOutput() {
		return this.output;
	}

}
