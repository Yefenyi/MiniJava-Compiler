package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;

import lex.ILexer;
import lex.PlusMinusLexer;

public class PlusMinusDriver {
	
	public static void main(String[] args) {
		File fileIn = new File("input_output/plusMinusLexerInput.txt");
		BufferedReader br;
		String inString;
		try {
			br = new BufferedReader(new FileReader(fileIn));
			inString = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		ANTLRInputStream input = new ANTLRInputStream(inString);
		antlr4.PlusMinusLexer lex = new antlr4.PlusMinusLexer(input);
		List<? extends Token> tokens = lex.getAllTokens();
		System.out.println("Antlr:");
		for(Token t : tokens) {
			if(t.getType() == 1) {
				System.out.println("plus");
			} else if(t.getType() == 2) {
				System.out.println("minus");
			} else {
				System.out.println(t.getText());
			}
		}
		System.out.println("Manual:");
		ILexer lexer = new PlusMinusLexer();
		List<String> result = lexer.lex(inString);
		for(String s : result) {
			System.out.println(s);
		}
	}

}
