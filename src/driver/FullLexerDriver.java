package driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;

import lex.FullLexer;
import lex.ILexer;

public class FullLexerDriver {
	
	@Parameters
	public static Collection<String> getFiles() {
		Collection<String> params = new HashSet<String>();
		for(File f : new File("./input_output/LexerFullTests").listFiles()) {
			if(f.getName().contains(".java")) {
				params.add(f.getName().substring(0, f.getName().indexOf('.')));
			}
		}
		return params;
	}
	
	public static void main(String[] args) {
		for(String fileName : getFiles()) {
			File fileIn = new File("input_output/LexerFullTests/" + fileName + ".java");
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
			File fileOut = new File ("input_output/LexerGeneratedOutput/" + fileName + ".out_gen");
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
				for(String s : result) {
					bw.write(s + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
