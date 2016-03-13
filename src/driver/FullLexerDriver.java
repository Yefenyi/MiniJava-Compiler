package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import lex.FullLexer;
import lex.ILexer;

public class FullLexerDriver {
	public static void main(String[] args) {
		File fileIn = new File("input_output/LexerFullTests/testcase00_15.java");
		BufferedReader br;
		String inString = "";
		try {
			br = new BufferedReader(new FileReader(fileIn));
			while(true) {
				String nextLine = br.readLine();
				if(nextLine == null) {
					break;
				}
				inString += nextLine + "\n";
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		ILexer lexer = new FullLexer();
		List<String> result = lexer.lex(inString);
		for(String s : result) {
			System.out.println(s);
		}
	}
}
