// Generated from MiniJava.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RESERVEDWORD=1, INTEGER=2, OPERATOR=3, DELIMITER=4, ID=5, WS=6, COMMENT=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'"
	};
	public static final String[] ruleNames = {
		"RESERVEDWORD", "INTEGER", "OPERATOR", "DELIMITER", "ID", "LETTER", "DIGIT", 
		"NONZERODIGIT", "WS", "COMMENT"
	};


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return RESERVEDWORD_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean RESERVEDWORD_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return !('A' <= _input.LA(1) && _input.LA(1) <= 'z' || '0' <= _input.LA(1) && _input.LA(1) <= '9');
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\5\2\u0081\n\2\3\3\3\3\7\3\u0085\n\3\f\3\16\3\u0088\13\3\3\3\5\3"+
		"\u008b\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u009c\n\4\3\5\3\5\3\6\3\6\3\6\7\6\u00a3\n\6\f\6\16\6\u00a6\13\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\u00af\n\n\r\n\16\n\u00b0\3\n\5\n\u00b4"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00bc\n\13\f\13\16\13\u00bf\13\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00c7\n\13\f\13\16\13\u00ca\13\13"+
		"\3\13\7\13\u00cd\n\13\f\13\16\13\u00d0\13\13\5\13\u00d2\n\13\3\13\3\13"+
		"\4\u00bd\u00c8\2\f\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\b\25\t\3\2\t"+
		"\6\2,-//\61\61>>\13\2*+..\60\60==??]]__}}\177\177\4\2C\\c|\3\2\62;\3\2"+
		"\63;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u00f5\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\u0080"+
		"\3\2\2\2\5\u008a\3\2\2\2\7\u009b\3\2\2\2\t\u009d\3\2\2\2\13\u009f\3\2"+
		"\2\2\r\u00a7\3\2\2\2\17\u00a9\3\2\2\2\21\u00ab\3\2\2\2\23\u00b3\3\2\2"+
		"\2\25\u00d1\3\2\2\2\27\30\7e\2\2\30\31\7n\2\2\31\32\7c\2\2\32\33\7u\2"+
		"\2\33\u0081\7u\2\2\34\35\7r\2\2\35\36\7w\2\2\36\37\7d\2\2\37 \7n\2\2 "+
		"!\7k\2\2!\u0081\7e\2\2\"#\7u\2\2#$\7v\2\2$%\7c\2\2%&\7v\2\2&\'\7k\2\2"+
		"\'\u0081\7e\2\2()\7g\2\2)*\7z\2\2*+\7v\2\2+,\7g\2\2,-\7p\2\2-.\7f\2\2"+
		".\u0081\7u\2\2/\60\7x\2\2\60\61\7q\2\2\61\62\7k\2\2\62\u0081\7f\2\2\63"+
		"\64\7k\2\2\64\65\7p\2\2\65\u0081\7v\2\2\66\67\7d\2\2\678\7q\2\289\7q\2"+
		"\29:\7n\2\2:;\7g\2\2;<\7c\2\2<\u0081\7p\2\2=>\7k\2\2>\u0081\7h\2\2?@\7"+
		"g\2\2@A\7n\2\2AB\7u\2\2B\u0081\7g\2\2CD\7y\2\2DE\7j\2\2EF\7k\2\2FG\7n"+
		"\2\2G\u0081\7g\2\2HI\7t\2\2IJ\7g\2\2JK\7v\2\2KL\7w\2\2LM\7t\2\2M\u0081"+
		"\7p\2\2NO\7p\2\2OP\7w\2\2PQ\7n\2\2Q\u0081\7n\2\2RS\7v\2\2ST\7t\2\2TU\7"+
		"w\2\2U\u0081\7g\2\2VW\7h\2\2WX\7c\2\2XY\7n\2\2YZ\7u\2\2Z\u0081\7g\2\2"+
		"[\\\7v\2\2\\]\7j\2\2]^\7k\2\2^\u0081\7u\2\2_`\7p\2\2`a\7g\2\2a\u0081\7"+
		"y\2\2bc\7U\2\2cd\7v\2\2de\7t\2\2ef\7k\2\2fg\7p\2\2g\u0081\7i\2\2hi\7o"+
		"\2\2ij\7c\2\2jk\7k\2\2k\u0081\7p\2\2lm\7U\2\2mn\7{\2\2no\7u\2\2op\7v\2"+
		"\2pq\7g\2\2qr\7o\2\2rs\7\60\2\2st\7q\2\2tu\7w\2\2uv\7v\2\2vw\7\60\2\2"+
		"wx\7r\2\2xy\7t\2\2yz\7k\2\2z{\7p\2\2{|\7v\2\2|}\7n\2\2}~\7p\2\2~\177\3"+
		"\2\2\2\177\u0081\6\2\2\2\u0080\27\3\2\2\2\u0080\34\3\2\2\2\u0080\"\3\2"+
		"\2\2\u0080(\3\2\2\2\u0080/\3\2\2\2\u0080\63\3\2\2\2\u0080\66\3\2\2\2\u0080"+
		"=\3\2\2\2\u0080?\3\2\2\2\u0080C\3\2\2\2\u0080H\3\2\2\2\u0080N\3\2\2\2"+
		"\u0080R\3\2\2\2\u0080V\3\2\2\2\u0080[\3\2\2\2\u0080_\3\2\2\2\u0080b\3"+
		"\2\2\2\u0080h\3\2\2\2\u0080l\3\2\2\2\u0081\4\3\2\2\2\u0082\u0086\5\21"+
		"\t\2\u0083\u0085\5\17\b\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008b\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0089\u008b\7\62\2\2\u008a\u0082\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\6\3\2\2\2\u008c\u009c\t\2\2\2\u008d\u008e\7>\2\2\u008e\u009c\7?\2\2\u008f"+
		"\u0090\7@\2\2\u0090\u009c\7?\2\2\u0091\u009c\7@\2\2\u0092\u0093\7?\2\2"+
		"\u0093\u009c\7?\2\2\u0094\u0095\7#\2\2\u0095\u009c\7?\2\2\u0096\u0097"+
		"\7(\2\2\u0097\u009c\7(\2\2\u0098\u0099\7~\2\2\u0099\u009c\7~\2\2\u009a"+
		"\u009c\7#\2\2\u009b\u008c\3\2\2\2\u009b\u008d\3\2\2\2\u009b\u008f\3\2"+
		"\2\2\u009b\u0091\3\2\2\2\u009b\u0092\3\2\2\2\u009b\u0094\3\2\2\2\u009b"+
		"\u0096\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u009a\3\2\2\2\u009c\b\3\2\2\2"+
		"\u009d\u009e\t\3\2\2\u009e\n\3\2\2\2\u009f\u00a4\5\r\7\2\u00a0\u00a3\5"+
		"\r\7\2\u00a1\u00a3\5\17\b\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\f\3\2\2\2"+
		"\u00a6\u00a4\3\2\2\2\u00a7\u00a8\t\4\2\2\u00a8\16\3\2\2\2\u00a9\u00aa"+
		"\t\5\2\2\u00aa\20\3\2\2\2\u00ab\u00ac\t\6\2\2\u00ac\22\3\2\2\2\u00ad\u00af"+
		"\t\7\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b4\5\25\13\2\u00b3\u00ae\3"+
		"\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\n\2\2\u00b6"+
		"\24\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9\7,\2\2\u00b9\u00bd\3\2\2"+
		"\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c1\7,\2\2\u00c1\u00d2\7\61\2\2\u00c2\u00c3\7\61\2\2\u00c3"+
		"\u00c4\7\61\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c7\13\2\2\2\u00c6\u00c5\3"+
		"\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00ce\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\n\b\2\2\u00cc\u00cb\3\2"+
		"\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00b7\3\2\2\2\u00d1\u00c2\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\13\2\2\u00d4\26\3\2\2\2\17\2\u0080"+
		"\u0086\u008a\u009b\u00a2\u00a4\u00b0\u00b3\u00bd\u00c8\u00ce\u00d1\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}