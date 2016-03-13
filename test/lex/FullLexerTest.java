package lex;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.junit.Before;
import org.junit.Test;

/**
 * @author koontzaj.
 *         Created Mar 13, 2016.
 */
public class FullLexerTest {
	String inputs[] = new String[4];
	
	@Before
	public void setUp() {
		String files[] ={"input_output/input1.txt","input_output/input2.txt","input_output/input3.txt","input_output/input4.txt"} ;
		for(int i=0;i<4;i++){
			File fileIn = new File(files[i]);
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
			inputs[i] = inString;
		}
	}

	@Test
	public void testInput1() {
		ILexer lexer = new FullLexer();
		List<String> result = lexer.lex(inputs[0]);
		String types[] = {
				"ReservedWord, class","ID, Test1","Delimiter, {",
				"ReservedWord, public",	"ReservedWord, static","ReservedWord, void","ReservedWord, main","Delimiter, (","ReservedWord, String","Delimiter, [","Delimiter, ]","ID, args","Delimiter, )","Delimiter, {",
				"ReservedWord, int","ID, answer","Delimiter, =","Integer, 0","Delimiter, ;",
				"ReservedWord, while","Delimiter, (","ID, answer","Operator, !=","Integer, 42","Delimiter, )","Delimiter, {",
				"ID, answer","Delimiter, =","ID, answer","Operator, +","Integer, 1","Delimiter, ;",
				"Delimiter, }",
				"ReservedWord, System.out.println","Delimiter, (","ID, answer","Delimiter, )","Delimiter, ;",
				"Delimiter, }",
				"Delimiter, }",
		};
		assertEquals(result.size(),types.length);
		for(int i=0;i<result.size();i++){
			String t = result.get(i);
			assertEquals(types[i],t);
		}
	}
	@Test
	public void testInput2() {
		ILexer lexer = new FullLexer();
		List<String> result = lexer.lex(inputs[1]);
		String types[] = {
				"ReservedWord, class","ID, Test2","Delimiter, {",
				"ReservedWord, public",	"ReservedWord, static","ReservedWord, void","ReservedWord, main","Delimiter, (","ReservedWord, String","Delimiter, [","Delimiter, ]","ID, args","Delimiter, )","Delimiter, {",
				"ReservedWord, int","ID, answer","Delimiter, =","Operator, -","Delimiter, =","Operator, -","Delimiter, =","Operator, +","Integer, 0",
				"ReservedWord, while","Delimiter, (","ID, answer","Operator, <","Integer, 100","Delimiter, (","Delimiter, {","Delimiter, }",
				"ID, answer","Delimiter, =","ID, answer","Operator, +","Integer, 1","Delimiter, ;",
				"ReservedWord, System.out.println","Delimiter, (","ID, answer","Operator, ==","Integer, 42","Delimiter, ,","Integer, 123415","Delimiter, )","Delimiter, ;",
				"ID, System","Delimiter, .","ID, out","Delimiter, .","ID, pritln","Delimiter, (","Integer, 1","Delimiter, )","Delimiter, ;",
				"Delimiter, }",
				"Delimiter, }",
		};
		assertEquals(result.size(),types.length);
		for(int i=0;i<types.length;i++){
			String t = result.get(i);
			assertEquals(types[i],t);
		}
	}

}
