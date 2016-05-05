// Generated from MiniJava.g4 by ANTLR 4.4
package antlr4;
//import MiniJavaListener;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EQUALS=1, NOTEQUALS=2, LT=3, GT=4, GEQ=5, LEQ=6, AND=7, OR=8, ADD=9, SUB=10, 
		DIVIDE=11, MULTPY=12, BANG=13, ASSIGN=14, DOT=15, LPREN=16, RPREN=17, 
		COMMA=18, LCURL=19, RCURL=20, LBRACKET=21, RBRACKET=22, SEMI=23, NEW=24, 
		THIS=25, NULL=26, TRUE=27, FALSE=28, CLASS=29, EXTENDS=30, PUBLIC=31, 
		STATIC=32, VOID=33, MAIN=34, STRING=35, RETURN=36, INT=37, BOOLEAN=38, 
		IF=39, ELSE=40, WHILE=41, SYSTEMPRINT=42, SYSTEMIN=43, INTEGER=44, OPERATOR=45, 
		DELIMITER=46, ID=47, WS=48, COMMENT=49;
	public static final String[] tokenNames = {
		"<INVALID>", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", "'&&'", "'||'", 
		"'+'", "'-'", "'/'", "'*'", "'!'", "'='", "'.'", "'('", "')'", "','", 
		"'{'", "'}'", "'['", "']'", "';'", "'new'", "'this'", "'null'", "'true'", 
		"'false'", "'class'", "'extends'", "'public'", "'static'", "'void'", "'main'", 
		"'String'", "'return'", "'int'", "'boolean'", "'if'", "'else'", "'while'", 
		"SYSTEMPRINT", "SYSTEMIN", "INTEGER", "OPERATOR", "DELIMITER", "ID", "WS", 
		"COMMENT"
	};
	public static final int
		RULE_oE = 0, RULE_oEP = 1, RULE_aE = 2, RULE_aEP = 3, RULE_cE = 4, RULE_cEP = 5, 
		RULE_eQE = 6, RULE_aSE = 7, RULE_aSEP = 8, RULE_mDE = 9, RULE_mDEP = 10, 
		RULE_nE = 11, RULE_dE = 12, RULE_dEP = 13, RULE_hPE = 14, RULE_program = 15, 
		RULE_mainClassDecl = 16, RULE_classDecl = 17, RULE_classVarDecl = 18, 
		RULE_methodDecl = 19, RULE_type = 20, RULE_formal = 21, RULE_stmt = 22, 
		RULE_stmtList = 23;
	public static final String[] ruleNames = {
		"oE", "oEP", "aE", "aEP", "cE", "cEP", "eQE", "aSE", "aSEP", "mDE", "mDEP", 
		"nE", "dE", "dEP", "hPE", "program", "mainClassDecl", "classDecl", "classVarDecl", 
		"methodDecl", "type", "formal", "stmt", "stmtList"
	};

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class OEContext extends ParserRuleContext {
		public OEPContext oEP() {
			return getRuleContext(OEPContext.class,0);
		}
		public AEContext aE() {
			return getRuleContext(AEContext.class,0);
		}
		public OEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterOE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitOE(this);
		}
	}

	public final OEContext oE() throws RecognitionException {
		OEContext _localctx = new OEContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_oE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); aE();
			setState(49); oEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OEPContext extends ParserRuleContext {
		public OEPContext oEP() {
			return getRuleContext(OEPContext.class,0);
		}
		public AEContext aE() {
			return getRuleContext(AEContext.class,0);
		}
		public TerminalNode OR() { return getToken(MiniJavaParser.OR, 0); }
		public OEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterOEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitOEP(this);
		}
	}

	public final OEPContext oEP() throws RecognitionException {
		OEPContext _localctx = new OEPContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_oEP);
		try {
			setState(56);
			switch (_input.LA(1)) {
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); match(OR);
				setState(52); aE();
				setState(53); oEP();
				}
				break;
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AEContext extends ParserRuleContext {
		public CEContext cE() {
			return getRuleContext(CEContext.class,0);
		}
		public AEPContext aEP() {
			return getRuleContext(AEPContext.class,0);
		}
		public AEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAE(this);
		}
	}

	public final AEContext aE() throws RecognitionException {
		AEContext _localctx = new AEContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_aE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); cE();
			setState(59); aEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AEPContext extends ParserRuleContext {
		public CEContext cE() {
			return getRuleContext(CEContext.class,0);
		}
		public AEPContext aEP() {
			return getRuleContext(AEPContext.class,0);
		}
		public TerminalNode AND() { return getToken(MiniJavaParser.AND, 0); }
		public AEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAEP(this);
		}
	}

	public final AEPContext aEP() throws RecognitionException {
		AEPContext _localctx = new AEPContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aEP);
		try {
			setState(66);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); match(AND);
				setState(62); cE();
				setState(63); aEP();
				}
				break;
			case OR:
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CEContext extends ParserRuleContext {
		public CEPContext cEP() {
			return getRuleContext(CEPContext.class,0);
		}
		public EQEContext eQE() {
			return getRuleContext(EQEContext.class,0);
		}
		public CEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCE(this);
		}
	}

	public final CEContext cE() throws RecognitionException {
		CEContext _localctx = new CEContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); eQE();
			setState(69); cEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CEPContext extends ParserRuleContext {
		public TerminalNode GEQ() { return getToken(MiniJavaParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(MiniJavaParser.LEQ, 0); }
		public TerminalNode LT() { return getToken(MiniJavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(MiniJavaParser.GT, 0); }
		public EQEContext eQE() {
			return getRuleContext(EQEContext.class,0);
		}
		public CEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCEP(this);
		}
	}

	public final CEPContext cEP() throws RecognitionException {
		CEPContext _localctx = new CEPContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cEP);
		int _la;
		try {
			setState(74);
			switch (_input.LA(1)) {
			case LT:
			case GT:
			case GEQ:
			case LEQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << GEQ) | (1L << LEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(72); eQE();
				}
				break;
			case AND:
			case OR:
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EQEContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MiniJavaParser.EQUALS, 0); }
		public ASEContext aSE(int i) {
			return getRuleContext(ASEContext.class,i);
		}
		public List<ASEContext> aSE() {
			return getRuleContexts(ASEContext.class);
		}
		public TerminalNode NOTEQUALS() { return getToken(MiniJavaParser.NOTEQUALS, 0); }
		public EQEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eQE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterEQE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitEQE(this);
		}
	}

	public final EQEContext eQE() throws RecognitionException {
		EQEContext _localctx = new EQEContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_eQE);
		int _la;
		try {
			setState(81);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); aSE();
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==EQUALS || _la==NOTEQUALS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(78); aSE();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); aSE();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ASEContext extends ParserRuleContext {
		public MDEContext mDE() {
			return getRuleContext(MDEContext.class,0);
		}
		public ASEPContext aSEP() {
			return getRuleContext(ASEPContext.class,0);
		}
		public ASEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aSE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterASE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitASE(this);
		}
	}

	public final ASEContext aSE() throws RecognitionException {
		ASEContext _localctx = new ASEContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_aSE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); mDE();
			setState(84); aSEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ASEPContext extends ParserRuleContext {
		public MDEContext mDE() {
			return getRuleContext(MDEContext.class,0);
		}
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public ASEPContext aSEP() {
			return getRuleContext(ASEPContext.class,0);
		}
		public TerminalNode ADD() { return getToken(MiniJavaParser.ADD, 0); }
		public ASEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aSEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterASEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitASEP(this);
		}
	}

	public final ASEPContext aSEP() throws RecognitionException {
		ASEPContext _localctx = new ASEPContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aSEP);
		int _la;
		try {
			setState(91);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(87); mDE();
				setState(88); aSEP();
				}
				break;
			case EQUALS:
			case NOTEQUALS:
			case LT:
			case GT:
			case GEQ:
			case LEQ:
			case AND:
			case OR:
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MDEContext extends ParserRuleContext {
		public NEContext nE() {
			return getRuleContext(NEContext.class,0);
		}
		public MDEPContext mDEP() {
			return getRuleContext(MDEPContext.class,0);
		}
		public MDEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mDE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMDE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMDE(this);
		}
	}

	public final MDEContext mDE() throws RecognitionException {
		MDEContext _localctx = new MDEContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mDE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); nE();
			setState(94); mDEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MDEPContext extends ParserRuleContext {
		public NEContext nE() {
			return getRuleContext(NEContext.class,0);
		}
		public MDEPContext mDEP() {
			return getRuleContext(MDEPContext.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(MiniJavaParser.DIVIDE, 0); }
		public TerminalNode MULTPY() { return getToken(MiniJavaParser.MULTPY, 0); }
		public MDEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mDEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMDEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMDEP(this);
		}
	}

	public final MDEPContext mDEP() throws RecognitionException {
		MDEPContext _localctx = new MDEPContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mDEP);
		int _la;
		try {
			setState(101);
			switch (_input.LA(1)) {
			case DIVIDE:
			case MULTPY:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==DIVIDE || _la==MULTPY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(97); nE();
				setState(98); mDEP();
				}
				break;
			case EQUALS:
			case NOTEQUALS:
			case LT:
			case GT:
			case GEQ:
			case LEQ:
			case AND:
			case OR:
			case ADD:
			case SUB:
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NEContext extends ParserRuleContext {
		public DEContext dE() {
			return getRuleContext(DEContext.class,0);
		}
		public NEContext nE() {
			return getRuleContext(NEContext.class,0);
		}
		public TerminalNode SUB() { return getToken(MiniJavaParser.SUB, 0); }
		public TerminalNode BANG() { return getToken(MiniJavaParser.BANG, 0); }
		public NEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNE(this);
		}
	}

	public final NEContext nE() throws RecognitionException {
		NEContext _localctx = new NEContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nE);
		int _la;
		try {
			setState(106);
			switch (_input.LA(1)) {
			case SUB:
			case BANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==BANG) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(104); nE();
				}
				break;
			case LPREN:
			case NEW:
			case THIS:
			case NULL:
			case TRUE:
			case FALSE:
			case SYSTEMIN:
			case INTEGER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); dE();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DEContext extends ParserRuleContext {
		public DEPContext dEP() {
			return getRuleContext(DEPContext.class,0);
		}
		public HPEContext hPE() {
			return getRuleContext(HPEContext.class,0);
		}
		public DEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterDE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitDE(this);
		}
	}

	public final DEContext dE() throws RecognitionException {
		DEContext _localctx = new DEContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); hPE();
			setState(109); dEP();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DEPContext extends ParserRuleContext {
		public TerminalNode LPREN() { return getToken(MiniJavaParser.LPREN, 0); }
		public OEContext oE(int i) {
			return getRuleContext(OEContext.class,i);
		}
		public TerminalNode DOT() { return getToken(MiniJavaParser.DOT, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public List<OEContext> oE() {
			return getRuleContexts(OEContext.class);
		}
		public DEPContext dEP() {
			return getRuleContext(DEPContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public DEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterDEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitDEP(this);
		}
	}

	public final DEPContext dEP() throws RecognitionException {
		DEPContext _localctx = new DEPContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_dEP);
		int _la;
		try {
			setState(128);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); match(DOT);
				setState(112); match(ID);
				setState(113); match(LPREN);
				setState(123);
				switch (_input.LA(1)) {
				case RPREN:
					{
					}
					break;
				case SUB:
				case BANG:
				case LPREN:
				case NEW:
				case THIS:
				case NULL:
				case TRUE:
				case FALSE:
				case SYSTEMIN:
				case INTEGER:
				case ID:
					{
					setState(115); oE();
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(116); match(COMMA);
						setState(117); oE();
						}
						}
						setState(122);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(125); match(RPREN);
				setState(126); dEP();
				}
				break;
			case EQUALS:
			case NOTEQUALS:
			case LT:
			case GT:
			case GEQ:
			case LEQ:
			case AND:
			case OR:
			case ADD:
			case SUB:
			case DIVIDE:
			case MULTPY:
			case RPREN:
			case COMMA:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HPEContext extends ParserRuleContext {
		public TerminalNode LPREN() { return getToken(MiniJavaParser.LPREN, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(MiniJavaParser.INTEGER, 0); }
		public TerminalNode NULL() { return getToken(MiniJavaParser.NULL, 0); }
		public OEContext oE() {
			return getRuleContext(OEContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(MiniJavaParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(MiniJavaParser.TRUE, 0); }
		public TerminalNode SYSTEMIN() { return getToken(MiniJavaParser.SYSTEMIN, 0); }
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public TerminalNode THIS() { return getToken(MiniJavaParser.THIS, 0); }
		public TerminalNode NEW() { return getToken(MiniJavaParser.NEW, 0); }
		public HPEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hPE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterHPE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitHPE(this);
		}
	}

	public final HPEContext hPE() throws RecognitionException {
		HPEContext _localctx = new HPEContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_hPE);
		try {
			setState(147);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(130); match(NEW);
				setState(131); match(ID);
				setState(132); match(LPREN);
				setState(133); match(RPREN);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); match(ID);
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(135); match(THIS);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(136); match(INTEGER);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(137); match(NULL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(138); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(139); match(FALSE);
				}
				break;
			case LPREN:
				enterOuterAlt(_localctx, 8);
				{
				setState(140); match(LPREN);
				setState(141); oE();
				setState(142); match(RPREN);
				}
				break;
			case SYSTEMIN:
				enterOuterAlt(_localctx, 9);
				{
				setState(144); match(SYSTEMIN);
				setState(145); match(LPREN);
				setState(146); match(RPREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainClassDeclContext mainClassDecl() {
			return getRuleContext(MainClassDeclContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MiniJavaParser.EOF, 0); }
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); mainClassDecl();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(150); classDecl();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainClassDeclContext extends ParserRuleContext {
		public TerminalNode LPREN() { return getToken(MiniJavaParser.LPREN, 0); }
		public TerminalNode RBRACKET() { return getToken(MiniJavaParser.RBRACKET, 0); }
		public TerminalNode LCURL(int i) {
			return getToken(MiniJavaParser.LCURL, i);
		}
		public List<TerminalNode> LCURL() { return getTokens(MiniJavaParser.LCURL); }
		public List<TerminalNode> RCURL() { return getTokens(MiniJavaParser.RCURL); }
		public TerminalNode RCURL(int i) {
			return getToken(MiniJavaParser.RCURL, i);
		}
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
		public TerminalNode LBRACKET() { return getToken(MiniJavaParser.LBRACKET, 0); }
		public TerminalNode MAIN() { return getToken(MiniJavaParser.MAIN, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(MiniJavaParser.VOID, 0); }
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(MiniJavaParser.CLASS, 0); }
		public MainClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClassDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMainClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMainClassDecl(this);
		}
	}

	public final MainClassDeclContext mainClassDecl() throws RecognitionException {
		MainClassDeclContext _localctx = new MainClassDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mainClassDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); match(CLASS);
			setState(159); match(ID);
			setState(160); match(LCURL);
			setState(161); match(PUBLIC);
			setState(162); match(STATIC);
			setState(163); match(VOID);
			setState(164); match(MAIN);
			setState(165); match(LPREN);
			setState(166); match(STRING);
			setState(167); match(LBRACKET);
			setState(168); match(RBRACKET);
			setState(169); match(ID);
			setState(170); match(RPREN);
			setState(171); match(LCURL);
			setState(172); stmtList();
			setState(173); match(RCURL);
			setState(174); match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public List<ClassVarDeclContext> classVarDecl() {
			return getRuleContexts(ClassVarDeclContext.class);
		}
		public TerminalNode LCURL() { return getToken(MiniJavaParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(MiniJavaParser.RCURL, 0); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode CLASS() { return getToken(MiniJavaParser.CLASS, 0); }
		public ClassVarDeclContext classVarDecl(int i) {
			return getRuleContext(ClassVarDeclContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(MiniJavaParser.EXTENDS, 0); }
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClassDecl(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(CLASS);
			setState(177); match(ID);
			setState(181);
			switch (_input.LA(1)) {
			case LCURL:
				{
				}
				break;
			case EXTENDS:
				{
				{
				setState(179); match(EXTENDS);
				setState(180); match(ID);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(183); match(LCURL);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << ID))) != 0)) {
				{
				{
				setState(184); classVarDecl();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(190); methodDecl();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196); match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassVarDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ClassVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClassVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClassVarDecl(this);
		}
	}

	public final ClassVarDeclContext classVarDecl() throws RecognitionException {
		ClassVarDeclContext _localctx = new ClassVarDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); type();
			setState(199); match(ID);
			setState(200); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode LPREN() { return getToken(MiniJavaParser.LPREN, 0); }
		public TerminalNode LCURL() { return getToken(MiniJavaParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(MiniJavaParser.RCURL, 0); }
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode RETURN() { return getToken(MiniJavaParser.RETURN, 0); }
		public OEContext oE() {
			return getRuleContext(OEContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodDecl(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(PUBLIC);
			setState(203); type();
			setState(204); match(ID);
			setState(205); match(LPREN);
			setState(215);
			switch (_input.LA(1)) {
			case RPREN:
				{
				}
				break;
			case INT:
			case BOOLEAN:
			case ID:
				{
				setState(207); formal();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(208); match(COMMA);
					setState(209); formal();
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(217); match(RPREN);
			setState(218); match(LCURL);
			setState(219); stmtList();
			setState(220); match(RETURN);
			setState(221); oE();
			setState(222); match(SEMI);
			setState(223); match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFormal(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); type();
			setState(228); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode LPREN() { return getToken(MiniJavaParser.LPREN, 0); }
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public TerminalNode LCURL() { return getToken(MiniJavaParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(MiniJavaParser.RCURL, 0); }
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public OEContext oE() {
			return getRuleContext(OEContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public TerminalNode SYSTEMPRINT() { return getToken(MiniJavaParser.SYSTEMPRINT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_stmt);
		try {
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230); type();
				setState(231); match(ID);
				setState(232); match(ASSIGN);
				setState(233); oE();
				setState(234); match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236); match(LCURL);
				setState(237); stmtList();
				setState(238); match(RCURL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240); match(IF);
				setState(241); match(LPREN);
				setState(242); oE();
				setState(243); match(RPREN);
				setState(244); stmt();
				setState(245); match(ELSE);
				setState(246); stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248); match(WHILE);
				setState(249); match(LPREN);
				setState(250); oE();
				setState(251); match(RPREN);
				setState(252); stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(254); match(SYSTEMPRINT);
				setState(255); match(LPREN);
				setState(256); oE();
				setState(257); match(RPREN);
				setState(258); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(260); match(ID);
				setState(261); match(ASSIGN);
				setState(262); oE();
				setState(263); match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListContext extends ParserRuleContext {
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStmtList(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stmtList);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case LCURL:
			case INT:
			case BOOLEAN:
			case IF:
			case WHILE:
			case SYSTEMPRINT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); stmt();
				setState(268); stmtList();
				}
				break;
			case RCURL:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u0114\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\5\5E\n\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7M\n\7\3\b\3\b\3\b\3\b\3\b\5\b"+
		"T\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n^\n\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\5\fh\n\f\3\r\3\r\3\r\5\rm\n\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17y\n\17\f\17\16\17|\13\17\5\17~\n\17\3\17\3"+
		"\17\3\17\5\17\u0083\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0096\n\20\3\21\3\21\7\21"+
		"\u009a\n\21\f\21\16\21\u009d\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00b8\n\23\3\23\3\23\7\23\u00bc\n\23\f\23\16"+
		"\23\u00bf\13\23\3\23\7\23\u00c2\n\23\f\23\16\23\u00c5\13\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00d5"+
		"\n\25\f\25\16\25\u00d8\13\25\5\25\u00da\n\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u010c\n\30\3\31\3\31\3\31\3\31\5\31\u0112\n\31\3\31\2\2\32"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\b\3\2\5\b\3\2\3"+
		"\4\3\2\13\f\3\2\r\16\4\2\f\f\17\17\4\2\'(\61\61\u0119\2\62\3\2\2\2\4:"+
		"\3\2\2\2\6<\3\2\2\2\bD\3\2\2\2\nF\3\2\2\2\fL\3\2\2\2\16S\3\2\2\2\20U\3"+
		"\2\2\2\22]\3\2\2\2\24_\3\2\2\2\26g\3\2\2\2\30l\3\2\2\2\32n\3\2\2\2\34"+
		"\u0082\3\2\2\2\36\u0095\3\2\2\2 \u0097\3\2\2\2\"\u00a0\3\2\2\2$\u00b2"+
		"\3\2\2\2&\u00c8\3\2\2\2(\u00cc\3\2\2\2*\u00e3\3\2\2\2,\u00e5\3\2\2\2."+
		"\u010b\3\2\2\2\60\u0111\3\2\2\2\62\63\5\6\4\2\63\64\5\4\3\2\64\3\3\2\2"+
		"\2\65\66\7\n\2\2\66\67\5\6\4\2\678\5\4\3\28;\3\2\2\29;\3\2\2\2:\65\3\2"+
		"\2\2:9\3\2\2\2;\5\3\2\2\2<=\5\n\6\2=>\5\b\5\2>\7\3\2\2\2?@\7\t\2\2@A\5"+
		"\n\6\2AB\5\b\5\2BE\3\2\2\2CE\3\2\2\2D?\3\2\2\2DC\3\2\2\2E\t\3\2\2\2FG"+
		"\5\16\b\2GH\5\f\7\2H\13\3\2\2\2IJ\t\2\2\2JM\5\16\b\2KM\3\2\2\2LI\3\2\2"+
		"\2LK\3\2\2\2M\r\3\2\2\2NO\5\20\t\2OP\t\3\2\2PQ\5\20\t\2QT\3\2\2\2RT\5"+
		"\20\t\2SN\3\2\2\2SR\3\2\2\2T\17\3\2\2\2UV\5\24\13\2VW\5\22\n\2W\21\3\2"+
		"\2\2XY\t\4\2\2YZ\5\24\13\2Z[\5\22\n\2[^\3\2\2\2\\^\3\2\2\2]X\3\2\2\2]"+
		"\\\3\2\2\2^\23\3\2\2\2_`\5\30\r\2`a\5\26\f\2a\25\3\2\2\2bc\t\5\2\2cd\5"+
		"\30\r\2de\5\26\f\2eh\3\2\2\2fh\3\2\2\2gb\3\2\2\2gf\3\2\2\2h\27\3\2\2\2"+
		"ij\t\6\2\2jm\5\30\r\2km\5\32\16\2li\3\2\2\2lk\3\2\2\2m\31\3\2\2\2no\5"+
		"\36\20\2op\5\34\17\2p\33\3\2\2\2qr\7\21\2\2rs\7\61\2\2s}\7\22\2\2t~\3"+
		"\2\2\2uz\5\2\2\2vw\7\24\2\2wy\5\2\2\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{"+
		"\3\2\2\2{~\3\2\2\2|z\3\2\2\2}t\3\2\2\2}u\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\7\23\2\2\u0080\u0083\5\34\17\2\u0081\u0083\3\2\2\2\u0082q\3\2\2\2\u0082"+
		"\u0081\3\2\2\2\u0083\35\3\2\2\2\u0084\u0085\7\32\2\2\u0085\u0086\7\61"+
		"\2\2\u0086\u0087\7\22\2\2\u0087\u0096\7\23\2\2\u0088\u0096\7\61\2\2\u0089"+
		"\u0096\7\33\2\2\u008a\u0096\7.\2\2\u008b\u0096\7\34\2\2\u008c\u0096\7"+
		"\35\2\2\u008d\u0096\7\36\2\2\u008e\u008f\7\22\2\2\u008f\u0090\5\2\2\2"+
		"\u0090\u0091\7\23\2\2\u0091\u0096\3\2\2\2\u0092\u0093\7-\2\2\u0093\u0094"+
		"\7\22\2\2\u0094\u0096\7\23\2\2\u0095\u0084\3\2\2\2\u0095\u0088\3\2\2\2"+
		"\u0095\u0089\3\2\2\2\u0095\u008a\3\2\2\2\u0095\u008b\3\2\2\2\u0095\u008c"+
		"\3\2\2\2\u0095\u008d\3\2\2\2\u0095\u008e\3\2\2\2\u0095\u0092\3\2\2\2\u0096"+
		"\37\3\2\2\2\u0097\u009b\5\"\22\2\u0098\u009a\5$\23\2\u0099\u0098\3\2\2"+
		"\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\2\2\3\u009f!\3\2\2\2\u00a0"+
		"\u00a1\7\37\2\2\u00a1\u00a2\7\61\2\2\u00a2\u00a3\7\25\2\2\u00a3\u00a4"+
		"\7!\2\2\u00a4\u00a5\7\"\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\7$\2\2\u00a7"+
		"\u00a8\7\22\2\2\u00a8\u00a9\7%\2\2\u00a9\u00aa\7\27\2\2\u00aa\u00ab\7"+
		"\30\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad\7\23\2\2\u00ad\u00ae\7\25\2\2"+
		"\u00ae\u00af\5\60\31\2\u00af\u00b0\7\26\2\2\u00b0\u00b1\7\26\2\2\u00b1"+
		"#\3\2\2\2\u00b2\u00b3\7\37\2\2\u00b3\u00b7\7\61\2\2\u00b4\u00b8\3\2\2"+
		"\2\u00b5\u00b6\7 \2\2\u00b6\u00b8\7\61\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\7\25\2\2\u00ba\u00bc\5&\24\2"+
		"\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00c3\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2\5(\25\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\26\2\2\u00c7"+
		"%\3\2\2\2\u00c8\u00c9\5*\26\2\u00c9\u00ca\7\61\2\2\u00ca\u00cb\7\31\2"+
		"\2\u00cb\'\3\2\2\2\u00cc\u00cd\7!\2\2\u00cd\u00ce\5*\26\2\u00ce\u00cf"+
		"\7\61\2\2\u00cf\u00d9\7\22\2\2\u00d0\u00da\3\2\2\2\u00d1\u00d6\5,\27\2"+
		"\u00d2\u00d3\7\24\2\2\u00d3\u00d5\5,\27\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00d0\3\2\2\2\u00d9\u00d1\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dc\7\23\2\2\u00dc\u00dd\7\25\2\2\u00dd\u00de\5\60\31\2\u00de"+
		"\u00df\7&\2\2\u00df\u00e0\5\2\2\2\u00e0\u00e1\7\31\2\2\u00e1\u00e2\7\26"+
		"\2\2\u00e2)\3\2\2\2\u00e3\u00e4\t\7\2\2\u00e4+\3\2\2\2\u00e5\u00e6\5*"+
		"\26\2\u00e6\u00e7\7\61\2\2\u00e7-\3\2\2\2\u00e8\u00e9\5*\26\2\u00e9\u00ea"+
		"\7\61\2\2\u00ea\u00eb\7\20\2\2\u00eb\u00ec\5\2\2\2\u00ec\u00ed\7\31\2"+
		"\2\u00ed\u010c\3\2\2\2\u00ee\u00ef\7\25\2\2\u00ef\u00f0\5\60\31\2\u00f0"+
		"\u00f1\7\26\2\2\u00f1\u010c\3\2\2\2\u00f2\u00f3\7)\2\2\u00f3\u00f4\7\22"+
		"\2\2\u00f4\u00f5\5\2\2\2\u00f5\u00f6\7\23\2\2\u00f6\u00f7\5.\30\2\u00f7"+
		"\u00f8\7*\2\2\u00f8\u00f9\5.\30\2\u00f9\u010c\3\2\2\2\u00fa\u00fb\7+\2"+
		"\2\u00fb\u00fc\7\22\2\2\u00fc\u00fd\5\2\2\2\u00fd\u00fe\7\23\2\2\u00fe"+
		"\u00ff\5.\30\2\u00ff\u010c\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0102\7\22"+
		"\2\2\u0102\u0103\5\2\2\2\u0103\u0104\7\23\2\2\u0104\u0105\7\31\2\2\u0105"+
		"\u010c\3\2\2\2\u0106\u0107\7\61\2\2\u0107\u0108\7\20\2\2\u0108\u0109\5"+
		"\2\2\2\u0109\u010a\7\31\2\2\u010a\u010c\3\2\2\2\u010b\u00e8\3\2\2\2\u010b"+
		"\u00ee\3\2\2\2\u010b\u00f2\3\2\2\2\u010b\u00fa\3\2\2\2\u010b\u0100\3\2"+
		"\2\2\u010b\u0106\3\2\2\2\u010c/\3\2\2\2\u010d\u010e\5.\30\2\u010e\u010f"+
		"\5\60\31\2\u010f\u0112\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010d\3\2\2\2"+
		"\u0111\u0110\3\2\2\2\u0112\61\3\2\2\2\25:DLS]glz}\u0082\u0095\u009b\u00b7"+
		"\u00bd\u00c3\u00d6\u00d9\u010b\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}