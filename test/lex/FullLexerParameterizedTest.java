package lex;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FullLexerParameterizedTest {
	
	@Parameters
	public static Collection<Object[]> getFiles() {
		Collection<Object[]> params = new HashSet<Object[]>();
		for(File f : new File("./input_output/LexerFullTests").listFiles()) {
			if(f.getName().contains(".java")) {
				Object[] arr = new Object[] { f.getName().substring(0, f.getName().indexOf('.')) };
				params.add(arr);
			}
		}
		return params;
	}
	
	private String filePrefix;
	
	public FullLexerParameterizedTest(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	@Test
	public void fullLexerParameterizedTest() {
		File fileIn = new File("./input_output/LexerFullTests/" + this.filePrefix + ".java");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		ILexer lexer = new FullLexer();
		List<String> result = lexer.lex(inString);
		fileIn = new File("./input_output/LexerFullTests/" + this.filePrefix + ".out");
		List<String> expected = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(fileIn));
			while(true) {
				String nextLine = br.readLine();
				if(nextLine == null) {
					break;
				}
				expected.add(nextLine);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertTrue(this.filePrefix, result.size() == expected.size());
		for(int i = 0 ; i < result.size(); ++i) {
			assertTrue(this.filePrefix, result.get(i).equals(expected.get(i)));
		}
	}

}
