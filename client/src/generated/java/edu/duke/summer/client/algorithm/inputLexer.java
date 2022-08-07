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
		T__0=1, T__1=2, EQ=3, NE=4, PLUS=5, MINUS=6, MUL=7, DIV=8, LT=9, LE=10, 
		GT=11, GE=12, MOD=13, AND=14, OR=15, ASSIGN=16, COLON=17, COMMA=18, LPAREN=19, 
		RPAREN=20, LBRACK=21, RBRACK=22, LBRACE=23, RBRACE=24, SEMICOLON=25, DOT=26, 
		NEW=27, ROLL=28, SINGLEROLL=29, ROLLKEY=30, SOME=31, NONE=32, IF=33, THEN=34, 
		ELSE=35, WHILE=36, RETURN=37, BREAK=38, ARRAY=39, OPTION=40, LENGTH=41, 
		TRUE=42, FALSE=43, PRINT=44, DO=45, FOR=46, OF=47, TO=48, DEFTYPEKEY=49, 
		DEFFUNKEY=50, DEFVARKEY=51, DEFSTRUCTKEY=52, INT=53, ID=54, STRING=55, 
		WS=56, LINE_COMMENT=57, COMMENT=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "EQ", "NE", "PLUS", "MINUS", "MUL", "DIV", "LT", "LE", 
		"GT", "GE", "MOD", "AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", 
		"NEW", "ROLL", "SINGLEROLL", "ROLLKEY", "SOME", "NONE", "IF", "THEN", 
		"ELSE", "WHILE", "RETURN", "BREAK", "ARRAY", "OPTION", "LENGTH", "TRUE", 
		"FALSE", "PRINT", "DO", "FOR", "OF", "TO", "DEFTYPEKEY", "DEFFUNKEY", 
		"DEFVARKEY", "DEFSTRUCTKEY", "INT", "ID", "STRING", "ESC", "WS", "LINE_COMMENT", 
		"COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'!'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'<'", 
		"'<='", "'>'", "'>='", "'%'", "'&&'", "'||'", "'='", "':'", "','", "'('", 
		"')'", "'['", "']'", "'{'", "'}'", "';'", "'.'", "'new'", null, null, 
		null, null, "'NONE'", "'if'", "'then'", "'else'", "'while'", "'return'", 
		"'break'", "'array'", "'option'", "'length'", "'true'", "'false'", "'print'", 
		"'do'", "'for'", "'of'", "'to'", "'type'", "'fun'", "'var'", "'struct'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "EQ", "NE", "PLUS", "MINUS", "MUL", "DIV", "LT", "LE", 
		"GT", "GE", "MOD", "AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", 
		"RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", 
		"NEW", "ROLL", "SINGLEROLL", "ROLLKEY", "SOME", "NONE", "IF", "THEN", 
		"ELSE", "WHILE", "RETURN", "BREAK", "ARRAY", "OPTION", "LENGTH", "TRUE", 
		"FALSE", "PRINT", "DO", "FOR", "OF", "TO", "DEFTYPEKEY", "DEFFUNKEY", 
		"DEFVARKEY", "DEFSTRUCTKEY", "INT", "ID", "STRING", "WS", "LINE_COMMENT", 
		"COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u0176\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 "+
		"\5 \u00c9\n \3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$"+
		"\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3("+
		"\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+"+
		"\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3"+
		"\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\6\66\u0137\n\66"+
		"\r\66\16\66\u0138\3\67\3\67\7\67\u013d\n\67\f\67\16\67\u0140\13\67\38"+
		"\38\38\78\u0145\n8\f8\168\u0148\138\38\38\39\39\39\39\59\u0150\n9\3:\6"+
		":\u0153\n:\r:\16:\u0154\3:\3:\3;\3;\3;\3;\7;\u015d\n;\f;\16;\u0160\13"+
		";\3;\5;\u0163\n;\3;\3;\3;\3;\3<\3<\3<\3<\7<\u016d\n<\f<\16<\u0170\13<"+
		"\3<\3<\3<\3<\3<\5\u0146\u015e\u016e\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q\2s:u;w<\3\2\7\5\2FFff~~\3\2\62"+
		";\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u017e\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2s\3\2\2"+
		"\2\2u\3\2\2\2\2w\3\2\2\2\3y\3\2\2\2\5{\3\2\2\2\7}\3\2\2\2\t\u0080\3\2"+
		"\2\2\13\u0083\3\2\2\2\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21\u0089\3\2\2"+
		"\2\23\u008b\3\2\2\2\25\u008d\3\2\2\2\27\u0090\3\2\2\2\31\u0092\3\2\2\2"+
		"\33\u0095\3\2\2\2\35\u0097\3\2\2\2\37\u009a\3\2\2\2!\u009d\3\2\2\2#\u009f"+
		"\3\2\2\2%\u00a1\3\2\2\2\'\u00a3\3\2\2\2)\u00a5\3\2\2\2+\u00a7\3\2\2\2"+
		"-\u00a9\3\2\2\2/\u00ab\3\2\2\2\61\u00ad\3\2\2\2\63\u00af\3\2\2\2\65\u00b1"+
		"\3\2\2\2\67\u00b3\3\2\2\29\u00b7\3\2\2\2;\u00bb\3\2\2\2=\u00be\3\2\2\2"+
		"?\u00c8\3\2\2\2A\u00ca\3\2\2\2C\u00cf\3\2\2\2E\u00d2\3\2\2\2G\u00d7\3"+
		"\2\2\2I\u00dc\3\2\2\2K\u00e2\3\2\2\2M\u00e9\3\2\2\2O\u00ef\3\2\2\2Q\u00f5"+
		"\3\2\2\2S\u00fc\3\2\2\2U\u0103\3\2\2\2W\u0108\3\2\2\2Y\u010e\3\2\2\2["+
		"\u0114\3\2\2\2]\u0117\3\2\2\2_\u011b\3\2\2\2a\u011e\3\2\2\2c\u0121\3\2"+
		"\2\2e\u0126\3\2\2\2g\u012a\3\2\2\2i\u012e\3\2\2\2k\u0136\3\2\2\2m\u013a"+
		"\3\2\2\2o\u0141\3\2\2\2q\u014f\3\2\2\2s\u0152\3\2\2\2u\u0158\3\2\2\2w"+
		"\u0168\3\2\2\2yz\7A\2\2z\4\3\2\2\2{|\7#\2\2|\6\3\2\2\2}~\7?\2\2~\177\7"+
		"?\2\2\177\b\3\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082\n\3\2"+
		"\2\2\u0083\u0084\7-\2\2\u0084\f\3\2\2\2\u0085\u0086\7/\2\2\u0086\16\3"+
		"\2\2\2\u0087\u0088\7,\2\2\u0088\20\3\2\2\2\u0089\u008a\7\61\2\2\u008a"+
		"\22\3\2\2\2\u008b\u008c\7>\2\2\u008c\24\3\2\2\2\u008d\u008e\7>\2\2\u008e"+
		"\u008f\7?\2\2\u008f\26\3\2\2\2\u0090\u0091\7@\2\2\u0091\30\3\2\2\2\u0092"+
		"\u0093\7@\2\2\u0093\u0094\7?\2\2\u0094\32\3\2\2\2\u0095\u0096\7\'\2\2"+
		"\u0096\34\3\2\2\2\u0097\u0098\7(\2\2\u0098\u0099\7(\2\2\u0099\36\3\2\2"+
		"\2\u009a\u009b\7~\2\2\u009b\u009c\7~\2\2\u009c \3\2\2\2\u009d\u009e\7"+
		"?\2\2\u009e\"\3\2\2\2\u009f\u00a0\7<\2\2\u00a0$\3\2\2\2\u00a1\u00a2\7"+
		".\2\2\u00a2&\3\2\2\2\u00a3\u00a4\7*\2\2\u00a4(\3\2\2\2\u00a5\u00a6\7+"+
		"\2\2\u00a6*\3\2\2\2\u00a7\u00a8\7]\2\2\u00a8,\3\2\2\2\u00a9\u00aa\7_\2"+
		"\2\u00aa.\3\2\2\2\u00ab\u00ac\7}\2\2\u00ac\60\3\2\2\2\u00ad\u00ae\7\177"+
		"\2\2\u00ae\62\3\2\2\2\u00af\u00b0\7=\2\2\u00b0\64\3\2\2\2\u00b1\u00b2"+
		"\7\60\2\2\u00b2\66\3\2\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7g\2\2\u00b5"+
		"\u00b6\7y\2\2\u00b68\3\2\2\2\u00b7\u00b8\5k\66\2\u00b8\u00b9\5=\37\2\u00b9"+
		"\u00ba\5k\66\2\u00ba:\3\2\2\2\u00bb\u00bc\5=\37\2\u00bc\u00bd\5k\66\2"+
		"\u00bd<\3\2\2\2\u00be\u00bf\t\2\2\2\u00bf>\3\2\2\2\u00c0\u00c1\7u\2\2"+
		"\u00c1\u00c2\7q\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c9\7g\2\2\u00c4\u00c5"+
		"\7U\2\2\u00c5\u00c6\7Q\2\2\u00c6\u00c7\7O\2\2\u00c7\u00c9\7G\2\2\u00c8"+
		"\u00c0\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9@\3\2\2\2\u00ca\u00cb\7P\2\2\u00cb"+
		"\u00cc\7Q\2\2\u00cc\u00cd\7P\2\2\u00cd\u00ce\7G\2\2\u00ceB\3\2\2\2\u00cf"+
		"\u00d0\7k\2\2\u00d0\u00d1\7h\2\2\u00d1D\3\2\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\u00d4\7j\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7p\2\2\u00d6F\3\2\2\2\u00d7"+
		"\u00d8\7g\2\2\u00d8\u00d9\7n\2\2\u00d9\u00da\7u\2\2\u00da\u00db\7g\2\2"+
		"\u00dbH\3\2\2\2\u00dc\u00dd\7y\2\2\u00dd\u00de\7j\2\2\u00de\u00df\7k\2"+
		"\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7g\2\2\u00e1J\3\2\2\2\u00e2\u00e3\7"+
		"t\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7v\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7"+
		"\7t\2\2\u00e7\u00e8\7p\2\2\u00e8L\3\2\2\2\u00e9\u00ea\7d\2\2\u00ea\u00eb"+
		"\7t\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7m\2\2\u00ee"+
		"N\3\2\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7t\2\2\u00f1\u00f2\7t\2\2\u00f2"+
		"\u00f3\7c\2\2\u00f3\u00f4\7{\2\2\u00f4P\3\2\2\2\u00f5\u00f6\7q\2\2\u00f6"+
		"\u00f7\7r\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7q\2\2"+
		"\u00fa\u00fb\7p\2\2\u00fbR\3\2\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7g\2"+
		"\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7i\2\2\u0100\u0101\7v\2\2\u0101\u0102"+
		"\7j\2\2\u0102T\3\2\2\2\u0103\u0104\7v\2\2\u0104\u0105\7t\2\2\u0105\u0106"+
		"\7w\2\2\u0106\u0107\7g\2\2\u0107V\3\2\2\2\u0108\u0109\7h\2\2\u0109\u010a"+
		"\7c\2\2\u010a\u010b\7n\2\2\u010b\u010c\7u\2\2\u010c\u010d\7g\2\2\u010d"+
		"X\3\2\2\2\u010e\u010f\7r\2\2\u010f\u0110\7t\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0112\7p\2\2\u0112\u0113\7v\2\2\u0113Z\3\2\2\2\u0114\u0115\7f\2\2\u0115"+
		"\u0116\7q\2\2\u0116\\\3\2\2\2\u0117\u0118\7h\2\2\u0118\u0119\7q\2\2\u0119"+
		"\u011a\7t\2\2\u011a^\3\2\2\2\u011b\u011c\7q\2\2\u011c\u011d\7h\2\2\u011d"+
		"`\3\2\2\2\u011e\u011f\7v\2\2\u011f\u0120\7q\2\2\u0120b\3\2\2\2\u0121\u0122"+
		"\7v\2\2\u0122\u0123\7{\2\2\u0123\u0124\7r\2\2\u0124\u0125\7g\2\2\u0125"+
		"d\3\2\2\2\u0126\u0127\7h\2\2\u0127\u0128\7w\2\2\u0128\u0129\7p\2\2\u0129"+
		"f\3\2\2\2\u012a\u012b\7x\2\2\u012b\u012c\7c\2\2\u012c\u012d\7t\2\2\u012d"+
		"h\3\2\2\2\u012e\u012f\7u\2\2\u012f\u0130\7v\2\2\u0130\u0131\7t\2\2\u0131"+
		"\u0132\7w\2\2\u0132\u0133\7e\2\2\u0133\u0134\7v\2\2\u0134j\3\2\2\2\u0135"+
		"\u0137\t\3\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139l\3\2\2\2\u013a\u013e\t\4\2\2\u013b\u013d"+
		"\t\5\2\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013fn\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0146\7$\2\2\u0142"+
		"\u0145\5q9\2\u0143\u0145\13\2\2\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2"+
		"\2\2\u0145\u0148\3\2\2\2\u0146\u0147\3\2\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\7$\2\2\u014ap\3\2\2\2\u014b"+
		"\u014c\7^\2\2\u014c\u0150\7$\2\2\u014d\u014e\7^\2\2\u014e\u0150\7^\2\2"+
		"\u014f\u014b\3\2\2\2\u014f\u014d\3\2\2\2\u0150r\3\2\2\2\u0151\u0153\t"+
		"\6\2\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154"+
		"\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b:\2\2\u0157t\3\2\2\2\u0158"+
		"\u0159\7\61\2\2\u0159\u015a\7\61\2\2\u015a\u015e\3\2\2\2\u015b\u015d\13"+
		"\2\2\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015f\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0163\7\17"+
		"\2\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0165\7\f\2\2\u0165\u0166\3\2\2\2\u0166\u0167\b;\2\2\u0167v\3\2\2\2\u0168"+
		"\u0169\7\61\2\2\u0169\u016a\7,\2\2\u016a\u016e\3\2\2\2\u016b\u016d\13"+
		"\2\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016f\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7,"+
		"\2\2\u0172\u0173\7\61\2\2\u0173\u0174\3\2\2\2\u0174\u0175\b<\2\2\u0175"+
		"x\3\2\2\2\r\2\u00c8\u0138\u013e\u0144\u0146\u014f\u0154\u015e\u0162\u016e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}