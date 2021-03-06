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
	
	@Test
	public void testEmptyString() {
		List<String> result = this.lexer.lex("");
		assertTrue(result != null);
		assertTrue(result.size() == 0);
	}
	
	@Test
	public void testOnlyNumber() {
		List<String> result = this.lexer.lex("01234567899876543210");
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue(result.get(0).equals("01234567899876543210"));
	}
	
	@Test
	public void testOnlyPlus() {
		List<String> result = this.lexer.lex("+");
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue(result.get(0).equals("plus"));
	}
	
	@Test
	public void testOnlyMinus() {
		List<String> result = this.lexer.lex("-");
		assertTrue(result != null);
		assertTrue(result.size() == 1);
		assertTrue(result.get(0).equals("minus"));
	}
	
	@Test
	public void testPlusMinusSequence() {
		List<String> result = this.lexer.lex("-+-++-+-");
		assertTrue(result != null);
		assertTrue(result.size() == 8);
		assertTrue(result.get(0).equals("minus"));
		assertTrue(result.get(1).equals("plus"));
		assertTrue(result.get(2).equals("minus"));
		assertTrue(result.get(3).equals("plus"));
		assertTrue(result.get(4).equals("plus"));
		assertTrue(result.get(5).equals("minus"));
		assertTrue(result.get(6).equals("plus"));
		assertTrue(result.get(7).equals("minus"));
	}
	
	@Test
	public void testStartAndEndWithSymbol() {
		List<String> result = this.lexer.lex("-684+498+");
		assertTrue(result != null);
		assertTrue(result.size() == 5);
		assertTrue(result.get(0).equals("minus"));
		assertTrue(result.get(1).equals("684"));
		assertTrue(result.get(2).equals("plus"));
		assertTrue(result.get(3).equals("498"));
		assertTrue(result.get(4).equals("plus"));
	}

}
