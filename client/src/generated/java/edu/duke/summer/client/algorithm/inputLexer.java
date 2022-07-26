// Generated from edu/duke/summer/client/algorithm/input.g4 by ANTLR 4.5
package edu.duke.summer.client.algorithm;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class inputLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, QUO=3, EQ=4, NE=5, PLUS=6, MINUS=7, MUL=8, DIV=9, LT=10, 
		LE=11, GT=12, GE=13, MOD=14, AND=15, OR=16, ASSIGN=17, COLON=18, COMMA=19, 
		LPAREN=20, RPAREN=21, LBRACK=22, RBRACK=23, LBRACE=24, RBRACE=25, SEMICOLON=26, 
		DOT=27, NEW=28, ROLL=29, SINGLEROLL=30, ROLLKEY=31, IF=32, THEN=33, ELSE=34, 
		WHILE=35, RETURN=36, BREAK=37, ARRAY=38, OPTION=39, LENGTH=40, TRUE=41, 
		FALSE=42, PRINT=43, DO=44, FOR=45, OF=46, TO=47, DEFTYPEKEY=48, DEFFUNKEY=49, 
		DEFVARKEY=50, DEFSTRUCTKEY=51, INT=52, ID=53, STRING=54, WS=55;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "QUO", "EQ", "NE", "PLUS", "MINUS", "MUL", "DIV", "LT", 
		"LE", "GT", "GE", "MOD", "AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", 
		"NEW", "ROLL", "SINGLEROLL", "ROLLKEY", "IF", "THEN", "ELSE", "WHILE", 
		"RETURN", "BREAK", "ARRAY", "OPTION", "LENGTH", "TRUE", "FALSE", "PRINT", 
		"DO", "FOR", "OF", "TO", "DEFTYPEKEY", "DEFFUNKEY", "DEFVARKEY", "DEFSTRUCTKEY", 
		"INT", "ID", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'!'", "'\"'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", 
		"'<'", "'<='", "'>'", "'>='", "'%'", "'&&'", "'||'", "'='", "':'", "','", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", "';'", "'.'", "'new'", null, 
		null, null, "'if'", "'then'", "'else'", "'while'", "'return'", "'break'", 
		"'array'", "'option'", "'length'", "'true'", "'false'", "'print'", "'do'", 
		"'for'", "'of'", "'to'", "'type'", "'fun'", "'var'", "'struct'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "QUO", "EQ", "NE", "PLUS", "MINUS", "MUL", "DIV", "LT", 
		"LE", "GT", "GE", "MOD", "AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", 
		"NEW", "ROLL", "SINGLEROLL", "ROLLKEY", "IF", "THEN", "ELSE", "WHILE", 
		"RETURN", "BREAK", "ARRAY", "OPTION", "LENGTH", "TRUE", "FALSE", "PRINT", 
		"DO", "FOR", "OF", "TO", "DEFTYPEKEY", "DEFFUNKEY", "DEFVARKEY", "DEFSTRUCTKEY", 
		"INT", "ID", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public inputLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\29\u0138\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u0122\n\65\r\65\16"+
		"\65\u0123\3\66\3\66\7\66\u0128\n\66\f\66\16\66\u012b\13\66\3\67\6\67\u012e"+
		"\n\67\r\67\16\67\u012f\38\68\u0133\n8\r8\168\u0134\38\38\2\29\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9\3\2\7\5"+
		"\2FFff~~\3\2\62;\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u013b\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\3q\3\2\2\2\5s\3\2\2\2\7u\3\2\2\2\tw\3\2\2\2\13z\3\2\2\2\r}\3"+
		"\2\2\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2"+
		"\2\27\u0087\3\2\2\2\31\u008a\3\2\2\2\33\u008c\3\2\2\2\35\u008f\3\2\2\2"+
		"\37\u0091\3\2\2\2!\u0094\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b"+
		"\3\2\2\2)\u009d\3\2\2\2+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00a3\3\2\2\2\61"+
		"\u00a5\3\2\2\2\63\u00a7\3\2\2\2\65\u00a9\3\2\2\2\67\u00ab\3\2\2\29\u00ad"+
		"\3\2\2\2;\u00b1\3\2\2\2=\u00b5\3\2\2\2?\u00b8\3\2\2\2A\u00ba\3\2\2\2C"+
		"\u00bd\3\2\2\2E\u00c2\3\2\2\2G\u00c7\3\2\2\2I\u00cd\3\2\2\2K\u00d4\3\2"+
		"\2\2M\u00da\3\2\2\2O\u00e0\3\2\2\2Q\u00e7\3\2\2\2S\u00ee\3\2\2\2U\u00f3"+
		"\3\2\2\2W\u00f9\3\2\2\2Y\u00ff\3\2\2\2[\u0102\3\2\2\2]\u0106\3\2\2\2_"+
		"\u0109\3\2\2\2a\u010c\3\2\2\2c\u0111\3\2\2\2e\u0115\3\2\2\2g\u0119\3\2"+
		"\2\2i\u0121\3\2\2\2k\u0125\3\2\2\2m\u012d\3\2\2\2o\u0132\3\2\2\2qr\7A"+
		"\2\2r\4\3\2\2\2st\7#\2\2t\6\3\2\2\2uv\7$\2\2v\b\3\2\2\2wx\7?\2\2xy\7?"+
		"\2\2y\n\3\2\2\2z{\7#\2\2{|\7?\2\2|\f\3\2\2\2}~\7-\2\2~\16\3\2\2\2\177"+
		"\u0080\7/\2\2\u0080\20\3\2\2\2\u0081\u0082\7,\2\2\u0082\22\3\2\2\2\u0083"+
		"\u0084\7\61\2\2\u0084\24\3\2\2\2\u0085\u0086\7>\2\2\u0086\26\3\2\2\2\u0087"+
		"\u0088\7>\2\2\u0088\u0089\7?\2\2\u0089\30\3\2\2\2\u008a\u008b\7@\2\2\u008b"+
		"\32\3\2\2\2\u008c\u008d\7@\2\2\u008d\u008e\7?\2\2\u008e\34\3\2\2\2\u008f"+
		"\u0090\7\'\2\2\u0090\36\3\2\2\2\u0091\u0092\7(\2\2\u0092\u0093\7(\2\2"+
		"\u0093 \3\2\2\2\u0094\u0095\7~\2\2\u0095\u0096\7~\2\2\u0096\"\3\2\2\2"+
		"\u0097\u0098\7?\2\2\u0098$\3\2\2\2\u0099\u009a\7<\2\2\u009a&\3\2\2\2\u009b"+
		"\u009c\7.\2\2\u009c(\3\2\2\2\u009d\u009e\7*\2\2\u009e*\3\2\2\2\u009f\u00a0"+
		"\7+\2\2\u00a0,\3\2\2\2\u00a1\u00a2\7]\2\2\u00a2.\3\2\2\2\u00a3\u00a4\7"+
		"_\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7}\2\2\u00a6\62\3\2\2\2\u00a7\u00a8"+
		"\7\177\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\7=\2\2\u00aa\66\3\2\2\2\u00ab"+
		"\u00ac\7\60\2\2\u00ac8\3\2\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7y\2\2\u00b0:\3\2\2\2\u00b1\u00b2\5i\65\2\u00b2\u00b3\5? \2\u00b3"+
		"\u00b4\5i\65\2\u00b4<\3\2\2\2\u00b5\u00b6\5? \2\u00b6\u00b7\5i\65\2\u00b7"+
		">\3\2\2\2\u00b8\u00b9\t\2\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7k\2\2\u00bb"+
		"\u00bc\7h\2\2\u00bcB\3\2\2\2\u00bd\u00be\7v\2\2\u00be\u00bf\7j\2\2\u00bf"+
		"\u00c0\7g\2\2\u00c0\u00c1\7p\2\2\u00c1D\3\2\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7n\2\2\u00c4\u00c5\7u\2\2\u00c5\u00c6\7g\2\2\u00c6F\3\2\2\2\u00c7"+
		"\u00c8\7y\2\2\u00c8\u00c9\7j\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7n\2\2"+
		"\u00cb\u00cc\7g\2\2\u00ccH\3\2\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7g\2"+
		"\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\7t\2\2\u00d2\u00d3"+
		"\7p\2\2\u00d3J\3\2\2\2\u00d4\u00d5\7d\2\2\u00d5\u00d6\7t\2\2\u00d6\u00d7"+
		"\7g\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7m\2\2\u00d9L\3\2\2\2\u00da\u00db"+
		"\7c\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7c\2\2\u00de"+
		"\u00df\7{\2\2\u00dfN\3\2\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7r\2\2\u00e2"+
		"\u00e3\7v\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7p\2\2"+
		"\u00e6P\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7p\2"+
		"\2\u00ea\u00eb\7i\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7j\2\2\u00edR\3\2"+
		"\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2"+
		"\7g\2\2\u00f2T\3\2\2\2\u00f3\u00f4\7h\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6"+
		"\7n\2\2\u00f6\u00f7\7u\2\2\u00f7\u00f8\7g\2\2\u00f8V\3\2\2\2\u00f9\u00fa"+
		"\7r\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7p\2\2\u00fd"+
		"\u00fe\7v\2\2\u00feX\3\2\2\2\u00ff\u0100\7f\2\2\u0100\u0101\7q\2\2\u0101"+
		"Z\3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104\7q\2\2\u0104\u0105\7t\2\2\u0105"+
		"\\\3\2\2\2\u0106\u0107\7q\2\2\u0107\u0108\7h\2\2\u0108^\3\2\2\2\u0109"+
		"\u010a\7v\2\2\u010a\u010b\7q\2\2\u010b`\3\2\2\2\u010c\u010d\7v\2\2\u010d"+
		"\u010e\7{\2\2\u010e\u010f\7r\2\2\u010f\u0110\7g\2\2\u0110b\3\2\2\2\u0111"+
		"\u0112\7h\2\2\u0112\u0113\7w\2\2\u0113\u0114\7p\2\2\u0114d\3\2\2\2\u0115"+
		"\u0116\7x\2\2\u0116\u0117\7c\2\2\u0117\u0118\7t\2\2\u0118f\3\2\2\2\u0119"+
		"\u011a\7u\2\2\u011a\u011b\7v\2\2\u011b\u011c\7t\2\2\u011c\u011d\7w\2\2"+
		"\u011d\u011e\7e\2\2\u011e\u011f\7v\2\2\u011fh\3\2\2\2\u0120\u0122\t\3"+
		"\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124j\3\2\2\2\u0125\u0129\t\4\2\2\u0126\u0128\t\5\2\2"+
		"\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012al\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\t\5\2\2\u012d"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130n\3\2\2\2\u0131\u0133\t\6\2\2\u0132\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0137\b8\2\2\u0137p\3\2\2\2\7\2\u0123\u0129\u012f\u0134\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}