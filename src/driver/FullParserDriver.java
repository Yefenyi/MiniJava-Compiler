package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.MiniJavaLexer;
import antlr4.MiniJavaParser;
import antlr4.MiniJavaParser.ProgramContext;
import parser.MiniJavaListener;

public class FullParserDriver {
	
	public static void main(String[] args) {
		String fileName = "testcase00_01";
		File fileIn = new File("input_output/ParserFullTests/" + fileName + ".java");
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
		
		MiniJavaLexer lexer = new MiniJavaLexer(new ANTLRInputStream(inString));
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		MiniJavaParser parser = new MiniJavaParser(tokens);
		ProgramContext programContext = parser.program();
		
		ParseTreeWalker walker = new ParseTreeWalker();
		MiniJavaListener listener = new MiniJavaListener();
		walker.walk(listener, programContext);
		
	}

}
