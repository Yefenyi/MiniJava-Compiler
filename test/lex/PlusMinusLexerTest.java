package lex;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlusMinusLexerTest {
	
	private ILexer lexer;
	
	@Before
	public void setUp() {
		this.lexer = new PlusMinusLexer();
	}
	
	@Test
	public void testTestSetup() {
		assertTrue(lexer != null);
	}
	
	@Test
	public void testProvided() {
		List<String> result = this.lexer.lex("123+321-+12");
		assertTrue(result != null);
		assertTrue(result.size() == 6);
		assertTrue(result.get(0).equals("123"));
		assertTrue(result.get(1).equals("plus"));
		assertTrue(result.get(2).equals("321"));
		assertTrue(result.get(3).equals("minus"));
		assertTrue(result.get(4).equals("plus"));
		assertTrue(result.get(5).equals("12"));
	}

}
