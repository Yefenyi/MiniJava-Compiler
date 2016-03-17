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
public class MiniJava extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, OPERATOR=2, DELIMITER=3, ID=4, RESERVEDWORD=5, WS=6, COMMENT=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'"
	};
	public static final String[] ruleNames = {
		"ID", "INTEGER", "OPERATOR", "DELIMITER", "RESERVEDWORD", "LETTER", "DIGIT", 
		"NONZERODIGIT", "WS", "COMMENT"
	};


	public MiniJava(CharStream input) {
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\3\3\3\7\3\"\n\3\f\3\16"+
		"\3%\13\3\3\3\5\3(\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\49\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6\u00a4\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\n\u00ad"+
		"\n\n\r\n\16\n\u00ae\3\n\5\n\u00b2\n\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13"+
		"\u00ba\n\13\f\13\16\13\u00bd\13\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00c5\n\13\f\13\16\13\u00c8\13\13\3\13\7\13\u00cb\n\13\f\13\16\13\u00ce"+
		"\13\13\5\13\u00d0\n\13\3\13\3\13\4\u00bb\u00c6\2\f\3\6\5\3\7\4\t\5\13"+
		"\7\r\2\17\2\21\2\23\b\25\t\3\2\t\6\2,-//\61\61>>\13\2*+..\60\60==??]]"+
		"__}}\177\177\4\2C\\c|\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\u00f3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\'\3\2\2\2\78\3\2\2\2\t:\3\2\2"+
		"\2\13\u00a3\3\2\2\2\r\u00a5\3\2\2\2\17\u00a7\3\2\2\2\21\u00a9\3\2\2\2"+
		"\23\u00b1\3\2\2\2\25\u00cf\3\2\2\2\27\34\5\r\7\2\30\33\5\r\7\2\31\33\5"+
		"\17\b\2\32\30\3\2\2\2\32\31\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35"+
		"\3\2\2\2\35\4\3\2\2\2\36\34\3\2\2\2\37#\5\21\t\2 \"\5\17\b\2! \3\2\2\2"+
		"\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$(\3\2\2\2%#\3\2\2\2&(\7\62\2\2\'\37\3"+
		"\2\2\2\'&\3\2\2\2(\6\3\2\2\2)9\t\2\2\2*+\7>\2\2+9\7?\2\2,-\7@\2\2-9\7"+
		"?\2\2.9\7@\2\2/\60\7?\2\2\609\7?\2\2\61\62\7#\2\2\629\7?\2\2\63\64\7("+
		"\2\2\649\7(\2\2\65\66\7~\2\2\669\7~\2\2\679\7#\2\28)\3\2\2\28*\3\2\2\2"+
		"8,\3\2\2\28.\3\2\2\28/\3\2\2\28\61\3\2\2\28\63\3\2\2\28\65\3\2\2\28\67"+
		"\3\2\2\29\b\3\2\2\2:;\t\3\2\2;\n\3\2\2\2<=\7e\2\2=>\7n\2\2>?\7c\2\2?@"+
		"\7u\2\2@\u00a4\7u\2\2AB\7r\2\2BC\7w\2\2CD\7d\2\2DE\7n\2\2EF\7k\2\2F\u00a4"+
		"\7e\2\2GH\7u\2\2HI\7v\2\2IJ\7c\2\2JK\7v\2\2KL\7k\2\2L\u00a4\7e\2\2MN\7"+
		"g\2\2NO\7z\2\2OP\7v\2\2PQ\7g\2\2QR\7p\2\2RS\7f\2\2S\u00a4\7u\2\2TU\7x"+
		"\2\2UV\7q\2\2VW\7k\2\2W\u00a4\7f\2\2XY\7k\2\2YZ\7p\2\2Z\u00a4\7v\2\2["+
		"\\\7d\2\2\\]\7q\2\2]^\7q\2\2^_\7n\2\2_`\7g\2\2`a\7c\2\2a\u00a4\7p\2\2"+
		"bc\7k\2\2c\u00a4\7h\2\2de\7g\2\2ef\7n\2\2fg\7u\2\2g\u00a4\7g\2\2hi\7y"+
		"\2\2ij\7j\2\2jk\7k\2\2kl\7n\2\2l\u00a4\7g\2\2mn\7t\2\2no\7g\2\2op\7v\2"+
		"\2pq\7w\2\2qr\7t\2\2r\u00a4\7p\2\2st\7p\2\2tu\7w\2\2uv\7n\2\2v\u00a4\7"+
		"n\2\2wx\7v\2\2xy\7t\2\2yz\7w\2\2z\u00a4\7g\2\2{|\7h\2\2|}\7c\2\2}~\7n"+
		"\2\2~\177\7u\2\2\177\u00a4\7g\2\2\u0080\u0081\7v\2\2\u0081\u0082\7j\2"+
		"\2\u0082\u0083\7k\2\2\u0083\u00a4\7u\2\2\u0084\u0085\7p\2\2\u0085\u0086"+
		"\7g\2\2\u0086\u00a4\7y\2\2\u0087\u0088\7U\2\2\u0088\u0089\7v\2\2\u0089"+
		"\u008a\7t\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u00a4\7i\2\2"+
		"\u008d\u008e\7o\2\2\u008e\u008f\7c\2\2\u008f\u0090\7k\2\2\u0090\u00a4"+
		"\7p\2\2\u0091\u0092\7U\2\2\u0092\u0093\7{\2\2\u0093\u0094\7u\2\2\u0094"+
		"\u0095\7v\2\2\u0095\u0096\7g\2\2\u0096\u0097\7o\2\2\u0097\u0098\7\60\2"+
		"\2\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b\7v\2\2\u009b\u009c"+
		"\7\60\2\2\u009c\u009d\7r\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f"+
		"\u00a0\7p\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a4\7p\2\2"+
		"\u00a3<\3\2\2\2\u00a3A\3\2\2\2\u00a3G\3\2\2\2\u00a3M\3\2\2\2\u00a3T\3"+
		"\2\2\2\u00a3X\3\2\2\2\u00a3[\3\2\2\2\u00a3b\3\2\2\2\u00a3d\3\2\2\2\u00a3"+
		"h\3\2\2\2\u00a3m\3\2\2\2\u00a3s\3\2\2\2\u00a3w\3\2\2\2\u00a3{\3\2\2\2"+
		"\u00a3\u0080\3\2\2\2\u00a3\u0084\3\2\2\2\u00a3\u0087\3\2\2\2\u00a3\u008d"+
		"\3\2\2\2\u00a3\u0091\3\2\2\2\u00a4\f\3\2\2\2\u00a5\u00a6\t\4\2\2\u00a6"+
		"\16\3\2\2\2\u00a7\u00a8\t\5\2\2\u00a8\20\3\2\2\2\u00a9\u00aa\t\6\2\2\u00aa"+
		"\22\3\2\2\2\u00ab\u00ad\t\7\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2"+
		"\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00b2"+
		"\5\25\13\2\u00b1\u00ac\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2"+
		"\u00b3\u00b4\b\n\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7\61\2\2\u00b6\u00b7"+
		"\7,\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00ba\13\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\7,\2\2\u00bf\u00d0\7\61\2\2\u00c0"+
		"\u00c1\7\61\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c5\13"+
		"\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00cc\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\n\b"+
		"\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00b5\3\2"+
		"\2\2\u00cf\u00c0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\13\2\2\u00d2"+
		"\26\3\2\2\2\17\2\32\34#\'8\u00a3\u00ae\u00b1\u00bb\u00c6\u00cc\u00cf\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}