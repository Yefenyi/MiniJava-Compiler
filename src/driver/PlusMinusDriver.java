package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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
		ILexer lexer = new PlusMinusLexer();
		List<String> result = lexer.lex(inString);
		for(String s : result) {
			System.out.println(s);
		}
	}

}
