// Generated from MiniJava.g4 by ANTLR 4.4
package antlr4;
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
		IF=39, ELSE=40, WHILE=41, SYSTEMPRINT=42, INTEGER=43, OPERATOR=44, DELIMITER=45, 
		ID=46, WS=47, COMMENT=48;
	public static final String[] tokenNames = {
		"<INVALID>", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", "'&&'", "'||'", 
		"'+'", "'-'", "'/'", "'*'", "'!'", "'='", "'.'", "'('", "')'", "','", 
		"'{'", "'}'", "'['", "']'", "';'", "'new'", "'this'", "'null'", "'true'", 
		"'false'", "'class'", "'extends'", "'public'", "'static'", "'void'", "'main'", 
		"'String'", "'return'", "'int'", "'boolean'", "'if'", "'else'", "'while'", 
		"SYSTEMPRINT", "INTEGER", "OPERATOR", "DELIMITER", "ID", "WS", "COMMENT"
	};
	public static final int
		RULE_eQE = 0, RULE_cE = 1, RULE_cEP = 2, RULE_aOE = 3, RULE_aOEP = 4, 
		RULE_aSE = 5, RULE_aSEP = 6, RULE_mDE = 7, RULE_mDEP = 8, RULE_nE = 9, 
		RULE_dE = 10, RULE_dEP = 11, RULE_hPE = 12, RULE_program = 13, RULE_mainClassDecl = 14, 
		RULE_classDecl = 15, RULE_classVarDecl = 16, RULE_methodDecl = 17, RULE_type = 18, 
		RULE_formal = 19, RULE_stmt = 20, RULE_stmtList = 21;
	public static final String[] ruleNames = {
		"eQE", "cE", "cEP", "aOE", "aOEP", "aSE", "aSEP", "mDE", "mDEP", "nE", 
		"dE", "dEP", "hPE", "program", "mainClassDecl", "classDecl", "classVarDecl", 
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
	public static class EQEContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MiniJavaParser.EQUALS, 0); }
		public List<CEContext> cE() {
			return getRuleContexts(CEContext.class);
		}
		public TerminalNode NOTEQUALS() { return getToken(MiniJavaParser.NOTEQUALS, 0); }
		public CEContext cE(int i) {
			return getRuleContext(CEContext.class,i);
		}
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
		enterRule(_localctx, 0, RULE_eQE);
		int _la;
		try {
			setState(49);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); cE();
				setState(45);
				_la = _input.LA(1);
				if ( !(_la==EQUALS || _la==NOTEQUALS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(46); cE();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); cE();
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

	public static class CEContext extends ParserRuleContext {
		public CEPContext cEP() {
			return getRuleContext(CEPContext.class,0);
		}
		public AOEContext aOE() {
			return getRuleContext(AOEContext.class,0);
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
		enterRule(_localctx, 2, RULE_cE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); aOE();
			setState(52); cEP();
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
		public AOEContext aOE() {
			return getRuleContext(AOEContext.class,0);
		}
		public TerminalNode GT() { return getToken(MiniJavaParser.GT, 0); }
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
		enterRule(_localctx, 4, RULE_cEP);
		int _la;
		try {
			setState(57);
			switch (_input.LA(1)) {
			case LT:
			case GT:
			case GEQ:
			case LEQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << GEQ) | (1L << LEQ))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(55); aOE();
				}
				break;
			case EQUALS:
			case NOTEQUALS:
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

	public static class AOEContext extends ParserRuleContext {
		public AOEPContext aOEP() {
			return getRuleContext(AOEPContext.class,0);
		}
		public ASEContext aSE() {
			return getRuleContext(ASEContext.class,0);
		}
		public AOEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aOE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAOE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAOE(this);
		}
	}

	public final AOEContext aOE() throws RecognitionException {
		AOEContext _localctx = new AOEContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aOE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); aSE();
			setState(60); aOEP();
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

	public static class AOEPContext extends ParserRuleContext {
		public AOEPContext aOEP() {
			return getRuleContext(AOEPContext.class,0);
		}
		public ASEContext aSE() {
			return getRuleContext(ASEContext.class,0);
		}
		public TerminalNode AND() { return getToken(MiniJavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniJavaParser.OR, 0); }
		public AOEPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aOEP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAOEP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAOEP(this);
		}
	}

	public final AOEPContext aOEP() throws RecognitionException {
		AOEPContext _localctx = new AOEPContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_aOEP);
		int _la;
		try {
			setState(67);
			switch (_input.LA(1)) {
			case AND:
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(63); aSE();
				setState(64); aOEP();
				}
				break;
			case EQUALS:
			case NOTEQUALS:
			case LT:
			case GT:
			case GEQ:
			case LEQ:
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
		enterRule(_localctx, 10, RULE_aSE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); mDE();
			setState(70); aSEP();
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
		enterRule(_localctx, 12, RULE_aSEP);
		int _la;
		try {
			setState(77);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(73); mDE();
				setState(74); aSEP();
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
		enterRule(_localctx, 14, RULE_mDE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); nE();
			setState(80); mDEP();
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
		enterRule(_localctx, 16, RULE_mDEP);
		int _la;
		try {
			setState(87);
			switch (_input.LA(1)) {
			case DIVIDE:
			case MULTPY:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				_la = _input.LA(1);
				if ( !(_la==DIVIDE || _la==MULTPY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(83); nE();
				setState(84); mDEP();
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
		enterRule(_localctx, 18, RULE_nE);
		int _la;
		try {
			setState(92);
			switch (_input.LA(1)) {
			case SUB:
			case BANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==BANG) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(90); nE();
				}
				break;
			case LPREN:
			case NEW:
			case THIS:
			case NULL:
			case TRUE:
			case FALSE:
			case INTEGER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(91); dE();
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
		enterRule(_localctx, 20, RULE_dE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); hPE();
			setState(95); dEP();
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
		public TerminalNode DOT() { return getToken(MiniJavaParser.DOT, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public DEPContext dEP() {
			return getRuleContext(DEPContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public List<EQEContext> eQE() {
			return getRuleContexts(EQEContext.class);
		}
		public EQEContext eQE(int i) {
			return getRuleContext(EQEContext.class,i);
		}
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
		enterRule(_localctx, 22, RULE_dEP);
		int _la;
		try {
			setState(114);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); match(DOT);
				setState(98); match(ID);
				setState(99); match(LPREN);
				setState(109);
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
				case INTEGER:
				case ID:
					{
					setState(101); eQE();
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(102); match(COMMA);
						setState(103); eQE();
						}
						}
						setState(108);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(111); match(RPREN);
				setState(112); dEP();
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
		public TerminalNode FALSE() { return getToken(MiniJavaParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(MiniJavaParser.TRUE, 0); }
		public TerminalNode RPREN() { return getToken(MiniJavaParser.RPREN, 0); }
		public EQEContext eQE() {
			return getRuleContext(EQEContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_hPE);
		try {
			setState(130);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); match(NEW);
				setState(117); match(ID);
				setState(118); match(LPREN);
				setState(119); match(RPREN);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); match(ID);
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); match(THIS);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(122); match(INTEGER);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(123); match(NULL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(124); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(125); match(FALSE);
				}
				break;
			case LPREN:
				enterOuterAlt(_localctx, 8);
				{
				setState(126); match(LPREN);
				setState(127); eQE();
				setState(128); match(RPREN);
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
		enterRule(_localctx, 26, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); mainClassDecl();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(133); classDecl();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139); match(EOF);
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
		enterRule(_localctx, 28, RULE_mainClassDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(CLASS);
			setState(142); match(ID);
			setState(143); match(LCURL);
			setState(144); match(PUBLIC);
			setState(145); match(STATIC);
			setState(146); match(VOID);
			setState(147); match(MAIN);
			setState(148); match(LPREN);
			setState(149); match(STRING);
			setState(150); match(LBRACKET);
			setState(151); match(RBRACKET);
			setState(152); match(ID);
			setState(153); match(RPREN);
			setState(154); match(LCURL);
			setState(155); stmtList();
			setState(156); match(RCURL);
			setState(157); match(RCURL);
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
		enterRule(_localctx, 30, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(CLASS);
			setState(160); match(ID);
			setState(164);
			switch (_input.LA(1)) {
			case LCURL:
				{
				}
				break;
			case EXTENDS:
				{
				{
				setState(162); match(EXTENDS);
				setState(163); match(ID);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(166); match(LCURL);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << ID))) != 0)) {
				{
				{
				setState(167); classVarDecl();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(173); methodDecl();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179); match(RCURL);
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
		enterRule(_localctx, 32, RULE_classVarDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); type();
			setState(182); match(ID);
			setState(183); match(SEMI);
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
		public EQEContext eQE() {
			return getRuleContext(EQEContext.class,0);
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
		enterRule(_localctx, 34, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(PUBLIC);
			setState(186); type();
			setState(187); match(ID);
			setState(188); match(LPREN);
			setState(198);
			switch (_input.LA(1)) {
			case RPREN:
				{
				}
				break;
			case INT:
			case BOOLEAN:
			case ID:
				{
				setState(190); formal();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(191); match(COMMA);
					setState(192); formal();
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(200); match(RPREN);
			setState(201); match(LCURL);
			setState(202); stmtList();
			setState(203); match(RETURN);
			setState(204); eQE();
			setState(205); match(SEMI);
			setState(206); match(RCURL);
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
		enterRule(_localctx, 36, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
		enterRule(_localctx, 38, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); type();
			setState(211); match(ID);
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
		public TerminalNode SEMI() { return getToken(MiniJavaParser.SEMI, 0); }
		public TerminalNode SYSTEMPRINT() { return getToken(MiniJavaParser.SYSTEMPRINT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EQEContext eQE() {
			return getRuleContext(EQEContext.class,0);
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
		enterRule(_localctx, 40, RULE_stmt);
		try {
			setState(248);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213); type();
				setState(214); match(ID);
				setState(215); match(ASSIGN);
				setState(216); eQE();
				setState(217); match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219); match(LCURL);
				setState(220); stmtList();
				setState(221); match(RCURL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223); match(IF);
				setState(224); match(LPREN);
				setState(225); eQE();
				setState(226); match(RPREN);
				setState(227); stmt();
				setState(228); match(ELSE);
				setState(229); stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(231); match(WHILE);
				setState(232); match(LPREN);
				setState(233); eQE();
				setState(234); match(RPREN);
				setState(235); stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237); match(SYSTEMPRINT);
				setState(238); match(LPREN);
				setState(239); eQE();
				setState(240); match(RPREN);
				setState(241); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243); match(ID);
				setState(244); match(ASSIGN);
				setState(245); eQE();
				setState(246); match(SEMI);
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
		enterRule(_localctx, 42, RULE_stmtList);
		try {
			setState(254);
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
				setState(250); stmt();
				setState(251); stmtList();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0103\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\64\n\2\3\3\3\3\3\3\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\5\6F\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bP\n\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\5\nZ\n\n\3\13\3\13\3\13\5\13_\n\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\7\rk\n\r\f\r\16\rn\13\r\5\rp\n\r\3\r\3\r\3\r"+
		"\5\ru\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u0085\n\16\3\17\3\17\7\17\u0089\n\17\f\17\16\17\u008c"+
		"\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00a7"+
		"\n\21\3\21\3\21\7\21\u00ab\n\21\f\21\16\21\u00ae\13\21\3\21\7\21\u00b1"+
		"\n\21\f\21\16\21\u00b4\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c4\n\23\f\23\16\23\u00c7\13\23\5"+
		"\23\u00c9\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00fb\n\26\3\27\3\27"+
		"\3\27\3\27\5\27\u0101\n\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,\2\t\3\2\3\4\3\2\5\b\3\2\t\n\3\2\13\f\3\2\r\16\4\2\f\f\17"+
		"\17\4\2\'(\60\60\u0108\2\63\3\2\2\2\4\65\3\2\2\2\6;\3\2\2\2\b=\3\2\2\2"+
		"\nE\3\2\2\2\fG\3\2\2\2\16O\3\2\2\2\20Q\3\2\2\2\22Y\3\2\2\2\24^\3\2\2\2"+
		"\26`\3\2\2\2\30t\3\2\2\2\32\u0084\3\2\2\2\34\u0086\3\2\2\2\36\u008f\3"+
		"\2\2\2 \u00a1\3\2\2\2\"\u00b7\3\2\2\2$\u00bb\3\2\2\2&\u00d2\3\2\2\2(\u00d4"+
		"\3\2\2\2*\u00fa\3\2\2\2,\u0100\3\2\2\2./\5\4\3\2/\60\t\2\2\2\60\61\5\4"+
		"\3\2\61\64\3\2\2\2\62\64\5\4\3\2\63.\3\2\2\2\63\62\3\2\2\2\64\3\3\2\2"+
		"\2\65\66\5\b\5\2\66\67\5\6\4\2\67\5\3\2\2\289\t\3\2\29<\5\b\5\2:<\3\2"+
		"\2\2;8\3\2\2\2;:\3\2\2\2<\7\3\2\2\2=>\5\f\7\2>?\5\n\6\2?\t\3\2\2\2@A\t"+
		"\4\2\2AB\5\f\7\2BC\5\n\6\2CF\3\2\2\2DF\3\2\2\2E@\3\2\2\2ED\3\2\2\2F\13"+
		"\3\2\2\2GH\5\20\t\2HI\5\16\b\2I\r\3\2\2\2JK\t\5\2\2KL\5\20\t\2LM\5\16"+
		"\b\2MP\3\2\2\2NP\3\2\2\2OJ\3\2\2\2ON\3\2\2\2P\17\3\2\2\2QR\5\24\13\2R"+
		"S\5\22\n\2S\21\3\2\2\2TU\t\6\2\2UV\5\24\13\2VW\5\22\n\2WZ\3\2\2\2XZ\3"+
		"\2\2\2YT\3\2\2\2YX\3\2\2\2Z\23\3\2\2\2[\\\t\7\2\2\\_\5\24\13\2]_\5\26"+
		"\f\2^[\3\2\2\2^]\3\2\2\2_\25\3\2\2\2`a\5\32\16\2ab\5\30\r\2b\27\3\2\2"+
		"\2cd\7\21\2\2de\7\60\2\2eo\7\22\2\2fp\3\2\2\2gl\5\2\2\2hi\7\24\2\2ik\5"+
		"\2\2\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2of\3"+
		"\2\2\2og\3\2\2\2pq\3\2\2\2qr\7\23\2\2ru\5\30\r\2su\3\2\2\2tc\3\2\2\2t"+
		"s\3\2\2\2u\31\3\2\2\2vw\7\32\2\2wx\7\60\2\2xy\7\22\2\2y\u0085\7\23\2\2"+
		"z\u0085\7\60\2\2{\u0085\7\33\2\2|\u0085\7-\2\2}\u0085\7\34\2\2~\u0085"+
		"\7\35\2\2\177\u0085\7\36\2\2\u0080\u0081\7\22\2\2\u0081\u0082\5\2\2\2"+
		"\u0082\u0083\7\23\2\2\u0083\u0085\3\2\2\2\u0084v\3\2\2\2\u0084z\3\2\2"+
		"\2\u0084{\3\2\2\2\u0084|\3\2\2\2\u0084}\3\2\2\2\u0084~\3\2\2\2\u0084\177"+
		"\3\2\2\2\u0084\u0080\3\2\2\2\u0085\33\3\2\2\2\u0086\u008a\5\36\20\2\u0087"+
		"\u0089\5 \21\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008e\7\2\2\3\u008e\35\3\2\2\2\u008f\u0090\7\37\2\2\u0090\u0091\7\60"+
		"\2\2\u0091\u0092\7\25\2\2\u0092\u0093\7!\2\2\u0093\u0094\7\"\2\2\u0094"+
		"\u0095\7#\2\2\u0095\u0096\7$\2\2\u0096\u0097\7\22\2\2\u0097\u0098\7%\2"+
		"\2\u0098\u0099\7\27\2\2\u0099\u009a\7\30\2\2\u009a\u009b\7\60\2\2\u009b"+
		"\u009c\7\23\2\2\u009c\u009d\7\25\2\2\u009d\u009e\5,\27\2\u009e\u009f\7"+
		"\26\2\2\u009f\u00a0\7\26\2\2\u00a0\37\3\2\2\2\u00a1\u00a2\7\37\2\2\u00a2"+
		"\u00a6\7\60\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a5\7 \2\2\u00a5\u00a7\7\60"+
		"\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00ac\7\25\2\2\u00a9\u00ab\5\"\22\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b2\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b1\5$\23\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2"+
		"\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00b6\7\26\2\2\u00b6!\3\2\2\2\u00b7\u00b8\5&\24\2"+
		"\u00b8\u00b9\7\60\2\2\u00b9\u00ba\7\31\2\2\u00ba#\3\2\2\2\u00bb\u00bc"+
		"\7!\2\2\u00bc\u00bd\5&\24\2\u00bd\u00be\7\60\2\2\u00be\u00c8\7\22\2\2"+
		"\u00bf\u00c9\3\2\2\2\u00c0\u00c5\5(\25\2\u00c1\u00c2\7\24\2\2\u00c2\u00c4"+
		"\5(\25\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00bf\3\2"+
		"\2\2\u00c8\u00c0\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\23\2\2\u00cb"+
		"\u00cc\7\25\2\2\u00cc\u00cd\5,\27\2\u00cd\u00ce\7&\2\2\u00ce\u00cf\5\2"+
		"\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d1\7\26\2\2\u00d1%\3\2\2\2\u00d2\u00d3"+
		"\t\b\2\2\u00d3\'\3\2\2\2\u00d4\u00d5\5&\24\2\u00d5\u00d6\7\60\2\2\u00d6"+
		")\3\2\2\2\u00d7\u00d8\5&\24\2\u00d8\u00d9\7\60\2\2\u00d9\u00da\7\20\2"+
		"\2\u00da\u00db\5\2\2\2\u00db\u00dc\7\31\2\2\u00dc\u00fb\3\2\2\2\u00dd"+
		"\u00de\7\25\2\2\u00de\u00df\5,\27\2\u00df\u00e0\7\26\2\2\u00e0\u00fb\3"+
		"\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\7\22\2\2\u00e3\u00e4\5\2\2\2\u00e4"+
		"\u00e5\7\23\2\2\u00e5\u00e6\5*\26\2\u00e6\u00e7\7*\2\2\u00e7\u00e8\5*"+
		"\26\2\u00e8\u00fb\3\2\2\2\u00e9\u00ea\7+\2\2\u00ea\u00eb\7\22\2\2\u00eb"+
		"\u00ec\5\2\2\2\u00ec\u00ed\7\23\2\2\u00ed\u00ee\5*\26\2\u00ee\u00fb\3"+
		"\2\2\2\u00ef\u00f0\7,\2\2\u00f0\u00f1\7\22\2\2\u00f1\u00f2\5\2\2\2\u00f2"+
		"\u00f3\7\23\2\2\u00f3\u00f4\7\31\2\2\u00f4\u00fb\3\2\2\2\u00f5\u00f6\7"+
		"\60\2\2\u00f6\u00f7\7\20\2\2\u00f7\u00f8\5\2\2\2\u00f8\u00f9\7\31\2\2"+
		"\u00f9\u00fb\3\2\2\2\u00fa\u00d7\3\2\2\2\u00fa\u00dd\3\2\2\2\u00fa\u00e1"+
		"\3\2\2\2\u00fa\u00e9\3\2\2\2\u00fa\u00ef\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fb"+
		"+\3\2\2\2\u00fc\u00fd\5*\26\2\u00fd\u00fe\5,\27\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u0101\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00ff\3\2\2\2\u0101-\3"+
		"\2\2\2\24\63;EOY^lot\u0084\u008a\u00a6\u00ac\u00b2\u00c5\u00c8\u00fa\u0100";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}