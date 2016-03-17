// Generated from MiniJava.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull MiniJavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull MiniJavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(@NotNull MiniJavaParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(@NotNull MiniJavaParser.TokenContext ctx);
}