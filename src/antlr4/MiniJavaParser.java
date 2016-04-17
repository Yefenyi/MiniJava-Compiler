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
		public CEPContext cEP() {
			return getRuleContext(CEPContext.class,0);
		}
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
			setState(59);
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
				setState(56); cEP();
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
			setState(61); aSE();
			setState(62); aOEP();
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
			setState(69);
			switch (_input.LA(1)) {
			case AND:
			case OR:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(65); aSE();
				setState(66); aOEP();
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
			setState(71); mDE();
			setState(72); aSEP();
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
			setState(79);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(75); mDE();
				setState(76); aSEP();
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
			setState(81); nE();
			setState(82); mDEP();
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
			setState(89);
			switch (_input.LA(1)) {
			case DIVIDE:
			case MULTPY:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				_la = _input.LA(1);
				if ( !(_la==DIVIDE || _la==MULTPY) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(85); nE();
				setState(86); mDEP();
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
			setState(94);
			switch (_input.LA(1)) {
			case SUB:
			case BANG:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==BANG) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(92); nE();
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
				setState(93); dE();
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
			setState(96); hPE();
			setState(97); dEP();
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
			setState(116);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(99); match(DOT);
				setState(100); match(ID);
				setState(101); match(LPREN);
				setState(111);
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
					setState(103); eQE();
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(104); match(COMMA);
						setState(105); eQE();
						}
						}
						setState(110);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(113); match(RPREN);
				setState(114); dEP();
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
			setState(132);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(118); match(NEW);
				setState(119); match(ID);
				setState(120); match(LPREN);
				setState(121); match(RPREN);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(122); match(ID);
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 3);
				{
				setState(123); match(THIS);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(124); match(INTEGER);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(125); match(NULL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 6);
				{
				setState(126); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 7);
				{
				setState(127); match(FALSE);
				}
				break;
			case LPREN:
				enterOuterAlt(_localctx, 8);
				{
				setState(128); match(LPREN);
				setState(129); eQE();
				setState(130); match(RPREN);
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
			setState(134); mainClassDecl();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(135); classDecl();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141); match(EOF);
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
			setState(143); match(CLASS);
			setState(144); match(ID);
			setState(145); match(LCURL);
			setState(146); match(PUBLIC);
			setState(147); match(STATIC);
			setState(148); match(VOID);
			setState(149); match(MAIN);
			setState(150); match(LPREN);
			setState(151); match(STRING);
			setState(152); match(LBRACKET);
			setState(153); match(RBRACKET);
			setState(154); match(ID);
			setState(155); match(RPREN);
			setState(156); match(LCURL);
			setState(157); stmtList();
			setState(158); match(RCURL);
			setState(159); match(RCURL);
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
			setState(161); match(CLASS);
			setState(162); match(ID);
			setState(166);
			switch (_input.LA(1)) {
			case LCURL:
				{
				}
				break;
			case EXTENDS:
				{
				{
				setState(164); match(EXTENDS);
				setState(165); match(ID);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(168); match(LCURL);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << ID))) != 0)) {
				{
				{
				setState(169); classVarDecl();
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(175); methodDecl();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181); match(RCURL);
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
			setState(183); type();
			setState(184); match(ID);
			setState(185); match(SEMI);
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
			setState(187); match(PUBLIC);
			setState(188); type();
			setState(189); match(ID);
			setState(190); match(LPREN);
			setState(200);
			switch (_input.LA(1)) {
			case RPREN:
				{
				}
				break;
			case INT:
			case BOOLEAN:
			case ID:
				{
				setState(192); formal();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(193); match(COMMA);
					setState(194); formal();
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(202); match(RPREN);
			setState(203); match(LCURL);
			setState(204); stmtList();
			setState(205); match(RETURN);
			setState(206); eQE();
			setState(207); match(SEMI);
			setState(208); match(RCURL);
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
			setState(210);
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
			setState(212); type();
			setState(213); match(ID);
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
			setState(250);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); type();
				setState(216); match(ID);
				setState(217); match(ASSIGN);
				setState(218); eQE();
				setState(219); match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221); match(LCURL);
				setState(222); stmtList();
				setState(223); match(RCURL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225); match(IF);
				setState(226); match(LPREN);
				setState(227); eQE();
				setState(228); match(RPREN);
				setState(229); stmt();
				setState(230); match(ELSE);
				setState(231); stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233); match(WHILE);
				setState(234); match(LPREN);
				setState(235); eQE();
				setState(236); match(RPREN);
				setState(237); stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239); match(SYSTEMPRINT);
				setState(240); match(LPREN);
				setState(241); eQE();
				setState(242); match(RPREN);
				setState(243); match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(245); match(ID);
				setState(246); match(ASSIGN);
				setState(247); eQE();
				setState(248); match(SEMI);
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
			setState(256);
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
				setState(252); stmt();
				setState(253); stmtList();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0105\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\64\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4>\n\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\5\6H\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\\\n\n\3\13\3\13\3\13\5\13a\n\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\rm\n\r\f\r\16\rp\13\r\5\rr\n\r\3\r"+
		"\3\r\3\r\5\rw\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0087\n\16\3\17\3\17\7\17\u008b\n\17\f\17\16\17"+
		"\u008e\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u00a9\n\21\3\21\3\21\7\21\u00ad\n\21\f\21\16\21\u00b0\13\21\3\21\7"+
		"\21\u00b3\n\21\f\21\16\21\u00b6\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c6\n\23\f\23\16\23\u00c9"+
		"\13\23\5\23\u00cb\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00fd\n\26"+
		"\3\27\3\27\3\27\3\27\5\27\u0103\n\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\t\3\2\3\4\3\2\5\b\3\2\t\n\3\2\13\f\3\2\r"+
		"\16\4\2\f\f\17\17\4\2\'(\60\60\u010a\2\63\3\2\2\2\4\65\3\2\2\2\6=\3\2"+
		"\2\2\b?\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2\16Q\3\2\2\2\20S\3\2\2\2\22[\3\2"+
		"\2\2\24`\3\2\2\2\26b\3\2\2\2\30v\3\2\2\2\32\u0086\3\2\2\2\34\u0088\3\2"+
		"\2\2\36\u0091\3\2\2\2 \u00a3\3\2\2\2\"\u00b9\3\2\2\2$\u00bd\3\2\2\2&\u00d4"+
		"\3\2\2\2(\u00d6\3\2\2\2*\u00fc\3\2\2\2,\u0102\3\2\2\2./\5\4\3\2/\60\t"+
		"\2\2\2\60\61\5\4\3\2\61\64\3\2\2\2\62\64\5\4\3\2\63.\3\2\2\2\63\62\3\2"+
		"\2\2\64\3\3\2\2\2\65\66\5\b\5\2\66\67\5\6\4\2\67\5\3\2\2\289\t\3\2\29"+
		":\5\b\5\2:;\5\6\4\2;>\3\2\2\2<>\3\2\2\2=8\3\2\2\2=<\3\2\2\2>\7\3\2\2\2"+
		"?@\5\f\7\2@A\5\n\6\2A\t\3\2\2\2BC\t\4\2\2CD\5\f\7\2DE\5\n\6\2EH\3\2\2"+
		"\2FH\3\2\2\2GB\3\2\2\2GF\3\2\2\2H\13\3\2\2\2IJ\5\20\t\2JK\5\16\b\2K\r"+
		"\3\2\2\2LM\t\5\2\2MN\5\20\t\2NO\5\16\b\2OR\3\2\2\2PR\3\2\2\2QL\3\2\2\2"+
		"QP\3\2\2\2R\17\3\2\2\2ST\5\24\13\2TU\5\22\n\2U\21\3\2\2\2VW\t\6\2\2WX"+
		"\5\24\13\2XY\5\22\n\2Y\\\3\2\2\2Z\\\3\2\2\2[V\3\2\2\2[Z\3\2\2\2\\\23\3"+
		"\2\2\2]^\t\7\2\2^a\5\24\13\2_a\5\26\f\2`]\3\2\2\2`_\3\2\2\2a\25\3\2\2"+
		"\2bc\5\32\16\2cd\5\30\r\2d\27\3\2\2\2ef\7\21\2\2fg\7\60\2\2gq\7\22\2\2"+
		"hr\3\2\2\2in\5\2\2\2jk\7\24\2\2km\5\2\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2"+
		"\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qh\3\2\2\2qi\3\2\2\2rs\3\2\2\2st\7\23"+
		"\2\2tw\5\30\r\2uw\3\2\2\2ve\3\2\2\2vu\3\2\2\2w\31\3\2\2\2xy\7\32\2\2y"+
		"z\7\60\2\2z{\7\22\2\2{\u0087\7\23\2\2|\u0087\7\60\2\2}\u0087\7\33\2\2"+
		"~\u0087\7-\2\2\177\u0087\7\34\2\2\u0080\u0087\7\35\2\2\u0081\u0087\7\36"+
		"\2\2\u0082\u0083\7\22\2\2\u0083\u0084\5\2\2\2\u0084\u0085\7\23\2\2\u0085"+
		"\u0087\3\2\2\2\u0086x\3\2\2\2\u0086|\3\2\2\2\u0086}\3\2\2\2\u0086~\3\2"+
		"\2\2\u0086\177\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0081\3\2\2\2\u0086\u0082"+
		"\3\2\2\2\u0087\33\3\2\2\2\u0088\u008c\5\36\20\2\u0089\u008b\5 \21\2\u008a"+
		"\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\2\2\3\u0090"+
		"\35\3\2\2\2\u0091\u0092\7\37\2\2\u0092\u0093\7\60\2\2\u0093\u0094\7\25"+
		"\2\2\u0094\u0095\7!\2\2\u0095\u0096\7\"\2\2\u0096\u0097\7#\2\2\u0097\u0098"+
		"\7$\2\2\u0098\u0099\7\22\2\2\u0099\u009a\7%\2\2\u009a\u009b\7\27\2\2\u009b"+
		"\u009c\7\30\2\2\u009c\u009d\7\60\2\2\u009d\u009e\7\23\2\2\u009e\u009f"+
		"\7\25\2\2\u009f\u00a0\5,\27\2\u00a0\u00a1\7\26\2\2\u00a1\u00a2\7\26\2"+
		"\2\u00a2\37\3\2\2\2\u00a3\u00a4\7\37\2\2\u00a4\u00a8\7\60\2\2\u00a5\u00a9"+
		"\3\2\2\2\u00a6\u00a7\7 \2\2\u00a7\u00a9\7\60\2\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ae\7\25\2\2\u00ab\u00ad\5"+
		"\"\22\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00b4\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\5$"+
		"\23\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\26"+
		"\2\2\u00b8!\3\2\2\2\u00b9\u00ba\5&\24\2\u00ba\u00bb\7\60\2\2\u00bb\u00bc"+
		"\7\31\2\2\u00bc#\3\2\2\2\u00bd\u00be\7!\2\2\u00be\u00bf\5&\24\2\u00bf"+
		"\u00c0\7\60\2\2\u00c0\u00ca\7\22\2\2\u00c1\u00cb\3\2\2\2\u00c2\u00c7\5"+
		"(\25\2\u00c3\u00c4\7\24\2\2\u00c4\u00c6\5(\25\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00c1\3\2\2\2\u00ca\u00c2\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\7\23\2\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\5"+
		",\27\2\u00cf\u00d0\7&\2\2\u00d0\u00d1\5\2\2\2\u00d1\u00d2\7\31\2\2\u00d2"+
		"\u00d3\7\26\2\2\u00d3%\3\2\2\2\u00d4\u00d5\t\b\2\2\u00d5\'\3\2\2\2\u00d6"+
		"\u00d7\5&\24\2\u00d7\u00d8\7\60\2\2\u00d8)\3\2\2\2\u00d9\u00da\5&\24\2"+
		"\u00da\u00db\7\60\2\2\u00db\u00dc\7\20\2\2\u00dc\u00dd\5\2\2\2\u00dd\u00de"+
		"\7\31\2\2\u00de\u00fd\3\2\2\2\u00df\u00e0\7\25\2\2\u00e0\u00e1\5,\27\2"+
		"\u00e1\u00e2\7\26\2\2\u00e2\u00fd\3\2\2\2\u00e3\u00e4\7)\2\2\u00e4\u00e5"+
		"\7\22\2\2\u00e5\u00e6\5\2\2\2\u00e6\u00e7\7\23\2\2\u00e7\u00e8\5*\26\2"+
		"\u00e8\u00e9\7*\2\2\u00e9\u00ea\5*\26\2\u00ea\u00fd\3\2\2\2\u00eb\u00ec"+
		"\7+\2\2\u00ec\u00ed\7\22\2\2\u00ed\u00ee\5\2\2\2\u00ee\u00ef\7\23\2\2"+
		"\u00ef\u00f0\5*\26\2\u00f0\u00fd\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2\u00f3"+
		"\7\22\2\2\u00f3\u00f4\5\2\2\2\u00f4\u00f5\7\23\2\2\u00f5\u00f6\7\31\2"+
		"\2\u00f6\u00fd\3\2\2\2\u00f7\u00f8\7\60\2\2\u00f8\u00f9\7\20\2\2\u00f9"+
		"\u00fa\5\2\2\2\u00fa\u00fb\7\31\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00d9\3"+
		"\2\2\2\u00fc\u00df\3\2\2\2\u00fc\u00e3\3\2\2\2\u00fc\u00eb\3\2\2\2\u00fc"+
		"\u00f1\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fd+\3\2\2\2\u00fe\u00ff\5*\26\2"+
		"\u00ff\u0100\5,\27\2\u0100\u0103\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u00fe"+
		"\3\2\2\2\u0102\u0101\3\2\2\2\u0103-\3\2\2\2\24\63=GQ[`nqv\u0086\u008c"+
		"\u00a8\u00ae\u00b4\u00c7\u00ca\u00fc\u0102";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}