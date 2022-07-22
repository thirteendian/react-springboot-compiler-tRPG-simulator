// Generated from edu\duke\summer\client\algorithm\input.g4 by ANTLR 4.5
package edu.duke.summer.client.algorithm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class inputParser extends Parser {
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
	public static final int
		RULE_prog = 0, RULE_exps = 1, RULE_exp = 2, RULE_strExp = 3, RULE_dec = 4, 
		RULE_decs = 5, RULE_typefield = 6, RULE_typefields = 7, RULE_finalFields = 8, 
		RULE_defType = 9, RULE_typeID = 10, RULE_paramList = 11, RULE_paramRest = 12, 
		RULE_defVar = 13, RULE_params = 14, RULE_funcallExp = 15, RULE_lvalue = 16, 
		RULE_initArray = 17, RULE_assign = 18, RULE_ifStmt = 19, RULE_whileStmt = 20, 
		RULE_forStmt = 21, RULE_printStmt = 22, RULE_returnStmt = 23, RULE_expStmt = 24, 
		RULE_decStmt = 25, RULE_stmts = 26, RULE_defFun = 27;
	public static final String[] ruleNames = {
		"prog", "exps", "exp", "strExp", "dec", "decs", "typefield", "typefields", 
		"finalFields", "defType", "typeID", "paramList", "paramRest", "defVar", 
		"params", "funcallExp", "lvalue", "initArray", "assign", "ifStmt", "whileStmt", 
		"forStmt", "printStmt", "returnStmt", "expStmt", "decStmt", "stmts", "defFun"
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

	@Override
	public String getGrammarFileName() { return "input.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public inputParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			exp(0);
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

	public static class ExpsContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public ExpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterExps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitExps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitExps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpsContext exps() throws RecognitionException {
		ExpsContext _localctx = new ExpsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exps);
		try {
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				exp(0);
				setState(60);
				match(SEMICOLON);
				setState(61);
				exps();
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NilExpContext extends ExpContext {
		public NilExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterNilExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitNilExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitNilExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExpContext extends ExpContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public AssignExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterAssignExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitAssignExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitAssignExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LenExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(inputParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(inputParser.LENGTH, 0); }
		public LenExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterLenExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitLenExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitLenExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LvalueExpContext extends ExpContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LvalueExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterLvalueExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitLvalueExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitLvalueExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExpContext extends ExpContext {
		public FuncallExpContext funcallExp() {
			return getRuleContext(FuncallExpContext.class,0);
		}
		public CallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExpContext extends ExpContext {
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public ParensExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterParensExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitParensExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitParensExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UminusExpContext extends ExpContext {
		public TerminalNode MINUS() { return getToken(inputParser.MINUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UminusExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterUminusExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitUminusExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitUminusExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpListContext extends ExpContext {
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public ExpListContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterExpList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitExpList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitExpList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpContext extends ExpContext {
		public ExpContext leftExp;
		public Token op;
		public ExpContext rightExp;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode MUL() { return getToken(inputParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(inputParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(inputParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(inputParser.MINUS, 0); }
		public TerminalNode AND() { return getToken(inputParser.AND, 0); }
		public TerminalNode OR() { return getToken(inputParser.OR, 0); }
		public TerminalNode EQ() { return getToken(inputParser.EQ, 0); }
		public TerminalNode NE() { return getToken(inputParser.NE, 0); }
		public TerminalNode LT() { return getToken(inputParser.LT, 0); }
		public TerminalNode LE() { return getToken(inputParser.LE, 0); }
		public TerminalNode GT() { return getToken(inputParser.GT, 0); }
		public TerminalNode GE() { return getToken(inputParser.GE, 0); }
		public ArithmeticExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterArithmeticExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitArithmeticExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitArithmeticExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NonExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterNonExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitNonExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitNonExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RollExpContext extends ExpContext {
		public TerminalNode ROLL() { return getToken(inputParser.ROLL, 0); }
		public RollExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterRollExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitRollExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitRollExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleRollExpContext extends ExpContext {
		public TerminalNode SINGLEROLL() { return getToken(inputParser.SINGLEROLL, 0); }
		public SingleRollExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSingleRollExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSingleRollExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSingleRollExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueExpContext extends ExpContext {
		public TerminalNode TRUE() { return getToken(inputParser.TRUE, 0); }
		public TrueExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterTrueExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitTrueExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitTrueExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructExpContext extends ExpContext {
		public TerminalNode DEFSTRUCTKEY() { return getToken(inputParser.DEFSTRUCTKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public FinalFieldsContext finalFields() {
			return getRuleContext(FinalFieldsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public StructExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStructExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStructExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStructExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleVarExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public SimpleVarExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSimpleVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSimpleVarExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSimpleVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseExpContext extends ExpContext {
		public TerminalNode FALSE() { return getToken(inputParser.FALSE, 0); }
		public FalseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFalseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFalseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFalseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalExpContext extends ExpContext {
		public ExpContext cond;
		public ExpContext opt1;
		public ExpContext opt2;
		public TerminalNode COLON() { return getToken(inputParser.COLON, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ConditionalExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterConditionalExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitConditionalExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitConditionalExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(inputParser.STRING, 0); }
		public StringExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStringExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStringExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStringExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuoStrExpContext extends ExpContext {
		public StrExpContext strExp() {
			return getRuleContext(StrExpContext.class,0);
		}
		public QuoStrExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterQuoStrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitQuoStrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitQuoStrExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExpContext extends ExpContext {
		public Token value;
		public TerminalNode INT() { return getToken(inputParser.INT, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterIntExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitIntExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitIntExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecListContext extends ExpContext {
		public DecsContext decs() {
			return getRuleContext(DecsContext.class,0);
		}
		public DecListContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDecList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDecList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDecList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldFunCallExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DOT() { return getToken(inputParser.DOT, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public ExpsContext exps() {
			return getRuleContext(ExpsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public FieldFunCallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFieldFunCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFieldFunCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFieldFunCallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new NonExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(66);
				match(T__1);
				setState(67);
				exp(9);
				}
				break;
			case 2:
				{
				_localctx = new UminusExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(MINUS);
				setState(69);
				exp(8);
				}
				break;
			case 3:
				{
				_localctx = new RollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(ROLL);
				}
				break;
			case 4:
				{
				_localctx = new SingleRollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(SINGLEROLL);
				}
				break;
			case 5:
				{
				_localctx = new ParensExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(LPAREN);
				setState(73);
				exp(0);
				setState(74);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new SimpleVarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				((IntExpContext)_localctx).value = match(INT);
				}
				break;
			case 8:
				{
				_localctx = new StringExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(STRING);
				}
				break;
			case 9:
				{
				_localctx = new QuoStrExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				strExp();
				}
				break;
			case 10:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(TRUE);
				}
				break;
			case 11:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(FALSE);
				}
				break;
			case 12:
				{
				_localctx = new DecListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				decs();
				}
				break;
			case 13:
				{
				_localctx = new NilExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			case 14:
				{
				_localctx = new ExpListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(LBRACE);
				setState(85);
				exps();
				setState(86);
				match(RBRACE);
				}
				break;
			case 15:
				{
				_localctx = new CallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				funcallExp();
				}
				break;
			case 16:
				{
				_localctx = new StructExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(DEFSTRUCTKEY);
				setState(90);
				match(ID);
				setState(91);
				match(LBRACE);
				setState(92);
				finalFields();
				setState(93);
				match(RBRACE);
				}
				break;
			case 17:
				{
				_localctx = new LvalueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				lvalue(0);
				}
				break;
			case 18:
				{
				_localctx = new AssignExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				assign();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(127);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionalExpContext(new ExpContext(_parentctx, _parentState));
						((ConditionalExpContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(99);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(100);
						match(T__0);
						setState(101);
						((ConditionalExpContext)_localctx).opt1 = exp(0);
						setState(102);
						match(COLON);
						setState(103);
						((ConditionalExpContext)_localctx).opt2 = exp(24);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(105);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(106);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(107);
						((ArithmeticExpContext)_localctx).rightExp = exp(23);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(108);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(109);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(110);
						((ArithmeticExpContext)_localctx).rightExp = exp(22);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(111);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(112);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(113);
						((ArithmeticExpContext)_localctx).rightExp = exp(21);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(114);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(115);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NE) | (1L << LT) | (1L << LE) | (1L << GT) | (1L << GE))) != 0)) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(116);
						((ArithmeticExpContext)_localctx).rightExp = exp(20);
						}
						break;
					case 6:
						{
						_localctx = new LenExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(117);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(118);
						match(DOT);
						setState(119);
						match(LENGTH);
						}
						break;
					case 7:
						{
						_localctx = new FieldFunCallExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(120);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(121);
						match(DOT);
						setState(122);
						match(ID);
						setState(123);
						match(LPAREN);
						setState(124);
						exps();
						setState(125);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StrExpContext extends ParserRuleContext {
		public List<TerminalNode> QUO() { return getTokens(inputParser.QUO); }
		public TerminalNode QUO(int i) {
			return getToken(inputParser.QUO, i);
		}
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode STRING() { return getToken(inputParser.STRING, 0); }
		public TerminalNode INT() { return getToken(inputParser.INT, 0); }
		public StrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStrExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrExpContext strExp() throws RecognitionException {
		StrExpContext _localctx = new StrExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_strExp);
		try {
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(QUO);
				setState(133);
				match(ID);
				setState(134);
				match(QUO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(QUO);
				setState(136);
				match(STRING);
				setState(137);
				match(QUO);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				match(QUO);
				setState(139);
				match(INT);
				setState(140);
				match(QUO);
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

	public static class DecContext extends ParserRuleContext {
		public DefTypeContext defType() {
			return getRuleContext(DefTypeContext.class,0);
		}
		public DefFunContext defFun() {
			return getRuleContext(DefFunContext.class,0);
		}
		public DefVarContext defVar() {
			return getRuleContext(DefVarContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dec);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case DEFTYPEKEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				defType();
				}
				break;
			case DEFFUNKEY:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				defFun();
				}
				break;
			case DEFVARKEY:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				defVar();
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

	public static class DecsContext extends ParserRuleContext {
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public DecsContext decs() {
			return getRuleContext(DecsContext.class,0);
		}
		public DecsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDecs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDecs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDecs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecsContext decs() throws RecognitionException {
		DecsContext _localctx = new DecsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decs);
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				dec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				dec();
				setState(150);
				decs();
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

	public static class TypefieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode COLON() { return getToken(inputParser.COLON, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TypefieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typefield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterTypefield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitTypefield(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitTypefield(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypefieldContext typefield() throws RecognitionException {
		TypefieldContext _localctx = new TypefieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_typefield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			setState(155);
			match(COLON);
			setState(156);
			typeID(0);
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

	public static class TypefieldsContext extends ParserRuleContext {
		public TypefieldContext typefield() {
			return getRuleContext(TypefieldContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(inputParser.COMMA, 0); }
		public TypefieldsContext typefields() {
			return getRuleContext(TypefieldsContext.class,0);
		}
		public TypefieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typefields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterTypefields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitTypefields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitTypefields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypefieldsContext typefields() throws RecognitionException {
		TypefieldsContext _localctx = new TypefieldsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typefields);
		try {
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				typefield();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				typefield();
				setState(160);
				match(COMMA);
				setState(161);
				typefields();
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

	public static class FinalFieldsContext extends ParserRuleContext {
		public FinalFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalFields; }
	 
		public FinalFieldsContext() { }
		public void copyFrom(FinalFieldsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RegularFieldsContext extends FinalFieldsContext {
		public TypefieldsContext typefields() {
			return getRuleContext(TypefieldsContext.class,0);
		}
		public RegularFieldsContext(FinalFieldsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterRegularFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitRegularFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitRegularFields(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyFieldsContext extends FinalFieldsContext {
		public EmptyFieldsContext(FinalFieldsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterEmptyFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitEmptyFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitEmptyFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalFieldsContext finalFields() throws RecognitionException {
		FinalFieldsContext _localctx = new FinalFieldsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_finalFields);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new RegularFieldsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				typefields();
				}
				break;
			case RBRACE:
				_localctx = new EmptyFieldsContext(_localctx);
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

	public static class DefTypeContext extends ParserRuleContext {
		public DefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defType; }
	 
		public DefTypeContext() { }
		public void copyFrom(DefTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignTypeDefExpContext extends DefTypeContext {
		public TypeIDContext refer;
		public TerminalNode DEFTYPEKEY() { return getToken(inputParser.DEFTYPEKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public AssignTypeDefExpContext(DefTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterAssignTypeDefExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitAssignTypeDefExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitAssignTypeDefExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RegularTypeDefExpContext extends DefTypeContext {
		public TerminalNode DEFTYPEKEY() { return getToken(inputParser.DEFTYPEKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public FinalFieldsContext finalFields() {
			return getRuleContext(FinalFieldsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public RegularTypeDefExpContext(DefTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterRegularTypeDefExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitRegularTypeDefExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitRegularTypeDefExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefTypeContext defType() throws RecognitionException {
		DefTypeContext _localctx = new DefTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defType);
		try {
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new RegularTypeDefExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(DEFTYPEKEY);
				setState(170);
				match(ID);
				setState(171);
				match(LBRACE);
				setState(172);
				finalFields();
				setState(173);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new AssignTypeDefExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(DEFTYPEKEY);
				setState(176);
				match(ID);
				setState(177);
				match(ASSIGN);
				setState(178);
				((AssignTypeDefExpContext)_localctx).refer = typeID(0);
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

	public static class TypeIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TerminalNode OPTION() { return getToken(inputParser.OPTION, 0); }
		public TerminalNode LBRACK() { return getToken(inputParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(inputParser.RBRACK, 0); }
		public TerminalNode INT() { return getToken(inputParser.INT, 0); }
		public TypeIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterTypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitTypeID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitTypeID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIDContext typeID() throws RecognitionException {
		return typeID(0);
	}

	private TypeIDContext typeID(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeIDContext _localctx = new TypeIDContext(_ctx, _parentState);
		TypeIDContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_typeID, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(182);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new TypeIDContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeID);
						setState(184);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(185);
						match(OPTION);
						}
						break;
					case 2:
						{
						_localctx = new TypeIDContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeID);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						match(LBRACK);
						setState(188);
						match(RBRACK);
						}
						break;
					case 3:
						{
						_localctx = new TypeIDContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_typeID);
						setState(189);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(190);
						match(LBRACK);
						setState(191);
						match(INT);
						setState(192);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public List<ParamRestContext> paramRest() {
			return getRuleContexts(ParamRestContext.class);
		}
		public ParamRestContext paramRest(int i) {
			return getRuleContext(ParamRestContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_paramList);
		int _la;
		try {
			setState(207);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				typeID(0);
				setState(199);
				match(ID);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(200);
					paramRest();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
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

	public static class ParamRestContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(inputParser.COMMA, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public ParamRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterParamRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitParamRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitParamRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamRestContext paramRest() throws RecognitionException {
		ParamRestContext _localctx = new ParamRestContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_paramRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(COMMA);
			setState(210);
			typeID(0);
			setState(211);
			match(ID);
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

	public static class DefVarContext extends ParserRuleContext {
		public TerminalNode DEFVARKEY() { return getToken(inputParser.DEFVARKEY, 0); }
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COLON() { return getToken(inputParser.COLON, 0); }
		public DefVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDefVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDefVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDefVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefVarContext defVar() throws RecognitionException {
		DefVarContext _localctx = new DefVarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defVar);
		try {
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(DEFVARKEY);
				setState(214);
				match(ID);
				setState(215);
				match(ASSIGN);
				setState(216);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				match(DEFVARKEY);
				setState(218);
				match(ID);
				setState(219);
				match(COLON);
				setState(220);
				match(ID);
				setState(221);
				match(ASSIGN);
				setState(222);
				exp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				match(DEFVARKEY);
				setState(224);
				match(ID);
				setState(225);
				match(COLON);
				setState(226);
				match(ID);
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

	public static class ParamsContext extends ParserRuleContext {
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	 
		public ParamsContext() { }
		public void copyFrom(ParamsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulParamContext extends ParamsContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(inputParser.COMMA, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MulParamContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterMulParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitMulParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitMulParam(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleParamContext extends ParamsContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SingleParamContext(ParamsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSingleParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSingleParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSingleParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_params);
		try {
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new SingleParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				exp(0);
				}
				break;
			case 2:
				_localctx = new MulParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				exp(0);
				setState(231);
				match(COMMA);
				setState(232);
				params();
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

	public static class FuncallExpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcallExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFuncallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFuncallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFuncallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncallExpContext funcallExp() throws RecognitionException {
		FuncallExpContext _localctx = new FuncallExpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_funcallExp);
		try {
			setState(244);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(ID);
				setState(237);
				match(LPAREN);
				setState(238);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(ID);
				setState(240);
				match(LPAREN);
				setState(241);
				params();
				setState(242);
				match(RPAREN);
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

	public static class LvalueContext extends ParserRuleContext {
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	 
		public LvalueContext() { }
		public void copyFrom(LvalueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleFieldVarContext extends LvalueContext {
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(inputParser.DOT, 0); }
		public SimpleFieldVarContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSimpleFieldVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSimpleFieldVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSimpleFieldVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptVarContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(inputParser.LBRACK, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(inputParser.RBRACK, 0); }
		public SubscriptVarContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSubscriptVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSubscriptVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSubscriptVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleSubscriptVarContext extends LvalueContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(inputParser.LBRACK, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(inputParser.RBRACK, 0); }
		public SimpleSubscriptVarContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSimpleSubscriptVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSimpleSubscriptVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSimpleSubscriptVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldVarContext extends LvalueContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(inputParser.DOT, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public FieldVarContext(LvalueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFieldVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFieldVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFieldVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new SimpleFieldVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(247);
				match(ID);
				setState(248);
				match(DOT);
				setState(249);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new SimpleSubscriptVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(ID);
				setState(251);
				match(LBRACK);
				setState(252);
				exp(0);
				setState(253);
				match(RBRACK);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(265);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new FieldVarContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(257);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(258);
						match(DOT);
						setState(259);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new SubscriptVarContext(new LvalueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(260);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(261);
						match(LBRACK);
						setState(262);
						exp(0);
						setState(263);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitArrayContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(inputParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(inputParser.COMMA, i);
		}
		public InitArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterInitArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitInitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitInitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitArrayContext initArray() throws RecognitionException {
		InitArrayContext _localctx = new InitArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_initArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			exp(0);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(271);
				match(COMMA);
				setState(272);
				exp(0);
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class AssignContext extends ParserRuleContext {
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LvalueAssignContext extends AssignContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalueAssignContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterLvalueAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitLvalueAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitLvalueAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InitArrayAssignContext extends AssignContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public InitArrayContext initArray() {
			return getRuleContext(InitArrayContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public InitArrayAssignContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterInitArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitInitArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitInitArrayAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleInitArrayAssignContext extends AssignContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public InitArrayContext initArray() {
			return getRuleContext(InitArrayContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public SimpleInitArrayAssignContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSimpleInitArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSimpleInitArrayAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSimpleInitArrayAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleAssignContext extends AssignContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SimpleAssignContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterSimpleAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitSimpleAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitSimpleAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign);
		try {
			setState(297);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new SimpleAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(ID);
				setState(279);
				match(ASSIGN);
				setState(280);
				exp(0);
				}
				break;
			case 2:
				_localctx = new LvalueAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				lvalue(0);
				setState(282);
				match(ASSIGN);
				setState(283);
				exp(0);
				}
				break;
			case 3:
				_localctx = new InitArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				lvalue(0);
				setState(286);
				match(ASSIGN);
				setState(287);
				match(LBRACE);
				setState(288);
				initArray();
				setState(289);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new SimpleInitArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				match(ID);
				setState(292);
				match(ASSIGN);
				setState(293);
				match(LBRACE);
				setState(294);
				initArray();
				setState(295);
				match(RBRACE);
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExpContext condExp;
		public StmtsContext op1;
		public StmtsContext op2;
		public TerminalNode IF() { return getToken(inputParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode THEN() { return getToken(inputParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(inputParser.ELSE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ifStmt);
		try {
			setState(315);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(IF);
				setState(300);
				match(LPAREN);
				setState(301);
				((IfStmtContext)_localctx).condExp = exp(0);
				setState(302);
				match(RPAREN);
				setState(303);
				match(THEN);
				setState(304);
				((IfStmtContext)_localctx).op1 = stmts();
				setState(305);
				match(ELSE);
				setState(306);
				((IfStmtContext)_localctx).op2 = stmts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				match(IF);
				setState(309);
				match(LPAREN);
				setState(310);
				((IfStmtContext)_localctx).condExp = exp(0);
				setState(311);
				match(RPAREN);
				setState(312);
				match(THEN);
				setState(313);
				((IfStmtContext)_localctx).op1 = stmts();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(inputParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(inputParser.DO, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(WHILE);
			setState(318);
			match(LPAREN);
			setState(319);
			exp(0);
			setState(320);
			match(RPAREN);
			setState(321);
			match(DO);
			setState(322);
			stmts();
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(inputParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode COLON() { return getToken(inputParser.COLON, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(FOR);
			setState(325);
			match(LPAREN);
			setState(326);
			match(ID);
			setState(327);
			match(COLON);
			setState(328);
			exp(0);
			setState(329);
			match(RPAREN);
			setState(330);
			stmts();
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

	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(inputParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterPrintStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitPrintStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(PRINT);
			setState(333);
			match(LPAREN);
			setState(334);
			exp(0);
			setState(335);
			match(RPAREN);
			setState(336);
			match(SEMICOLON);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(inputParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(RETURN);
			setState(339);
			exp(0);
			setState(340);
			match(SEMICOLON);
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

	public static class ExpStmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public ExpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterExpStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitExpStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitExpStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpStmtContext expStmt() throws RecognitionException {
		ExpStmtContext _localctx = new ExpStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			exp(0);
			setState(343);
			match(SEMICOLON);
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

	public static class DecStmtContext extends ParserRuleContext {
		public DefVarContext defVar() {
			return getRuleContext(DefVarContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public DecStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDecStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDecStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDecStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecStmtContext decStmt() throws RecognitionException {
		DecStmtContext _localctx = new DecStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_decStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			defVar();
			setState(346);
			match(SEMICOLON);
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

	public static class StmtsContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public DecStmtContext decStmt() {
			return getRuleContext(DecStmtContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(inputParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public ExpStmtContext expStmt() {
			return getRuleContext(ExpStmtContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stmts);
		try {
			int _alt;
			setState(365);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(LBRACE);
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(349);
						stmts();
						}
						} 
					}
					setState(354);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(355);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(359);
				printStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(360);
				returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(361);
				decStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(362);
				match(BREAK);
				setState(363);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(364);
				expStmt();
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

	public static class DefFunContext extends ParserRuleContext {
		public TerminalNode DEFFUNKEY() { return getToken(inputParser.DEFFUNKEY, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public List<DecStmtContext> decStmt() {
			return getRuleContexts(DecStmtContext.class);
		}
		public DecStmtContext decStmt(int i) {
			return getRuleContext(DecStmtContext.class,i);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public DefFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDefFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDefFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDefFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefFunContext defFun() throws RecognitionException {
		DefFunContext _localctx = new DefFunContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_defFun);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(DEFFUNKEY);
			setState(368);
			typeID(0);
			setState(369);
			match(ID);
			setState(370);
			match(LPAREN);
			setState(371);
			paramList();
			setState(372);
			match(RPAREN);
			setState(373);
			match(LBRACE);
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(374);
					decStmt();
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(380);
					stmts();
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(386);
			returnStmt();
			setState(387);
			match(RBRACE);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 10:
			return typeID_sempred((TypeIDContext)_localctx, predIndex);
		case 16:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 23);
		case 1:
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 15);
		}
		return true;
	}
	private boolean typeID_sempred(TypeIDContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0188\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5"+
		"\3B\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"d\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0082\n\4\f\4\16"+
		"\4\u0085\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0090\n\5\3\6\3"+
		"\6\3\6\5\6\u0095\n\6\3\7\3\7\3\7\3\7\5\7\u009b\n\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u00a6\n\t\3\n\3\n\5\n\u00aa\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b6\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c4\n\f\f\f\16\f\u00c7\13\f\3\r\3\r"+
		"\3\r\7\r\u00cc\n\r\f\r\16\r\u00cf\13\r\3\r\5\r\u00d2\n\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00e6\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u00ed\n\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f7\n\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0102\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u010c\n\22\f\22\16\22\u010f\13\22\3\23\3\23\3\23\7\23"+
		"\u0114\n\23\f\23\16\23\u0117\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u012c"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u013e\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\7\34\u0161\n\34"+
		"\f\34\16\34\u0164\13\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\5\34\u0170\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u017a"+
		"\n\35\f\35\16\35\u017d\13\35\3\35\7\35\u0180\n\35\f\35\16\35\u0183\13"+
		"\35\3\35\3\35\3\35\3\35\2\5\6\26\"\36\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668\2\6\3\2\n\13\3\2\b\t\3\2\21\22\4\2\6\7\f"+
		"\17\u01a8\2:\3\2\2\2\4A\3\2\2\2\6c\3\2\2\2\b\u008f\3\2\2\2\n\u0094\3\2"+
		"\2\2\f\u009a\3\2\2\2\16\u009c\3\2\2\2\20\u00a5\3\2\2\2\22\u00a9\3\2\2"+
		"\2\24\u00b5\3\2\2\2\26\u00b7\3\2\2\2\30\u00d1\3\2\2\2\32\u00d3\3\2\2\2"+
		"\34\u00e5\3\2\2\2\36\u00ec\3\2\2\2 \u00f6\3\2\2\2\"\u0101\3\2\2\2$\u0110"+
		"\3\2\2\2&\u012b\3\2\2\2(\u013d\3\2\2\2*\u013f\3\2\2\2,\u0146\3\2\2\2."+
		"\u014e\3\2\2\2\60\u0154\3\2\2\2\62\u0158\3\2\2\2\64\u015b\3\2\2\2\66\u016f"+
		"\3\2\2\28\u0171\3\2\2\2:;\5\6\4\2;\3\3\2\2\2<B\5\6\4\2=>\5\6\4\2>?\7\34"+
		"\2\2?@\5\4\3\2@B\3\2\2\2A<\3\2\2\2A=\3\2\2\2B\5\3\2\2\2CD\b\4\1\2DE\7"+
		"\4\2\2Ed\5\6\4\13FG\7\t\2\2Gd\5\6\4\nHd\7\37\2\2Id\7 \2\2JK\7\26\2\2K"+
		"L\5\6\4\2LM\7\27\2\2Md\3\2\2\2Nd\7\67\2\2Od\7\66\2\2Pd\78\2\2Qd\5\b\5"+
		"\2Rd\7+\2\2Sd\7,\2\2Td\5\f\7\2Ud\3\2\2\2VW\7\32\2\2WX\5\4\3\2XY\7\33\2"+
		"\2Yd\3\2\2\2Zd\5 \21\2[\\\7\65\2\2\\]\7\67\2\2]^\7\32\2\2^_\5\22\n\2_"+
		"`\7\33\2\2`d\3\2\2\2ad\5\"\22\2bd\5&\24\2cC\3\2\2\2cF\3\2\2\2cH\3\2\2"+
		"\2cI\3\2\2\2cJ\3\2\2\2cN\3\2\2\2cO\3\2\2\2cP\3\2\2\2cQ\3\2\2\2cR\3\2\2"+
		"\2cS\3\2\2\2cT\3\2\2\2cU\3\2\2\2cV\3\2\2\2cZ\3\2\2\2c[\3\2\2\2ca\3\2\2"+
		"\2cb\3\2\2\2d\u0083\3\2\2\2ef\f\31\2\2fg\7\3\2\2gh\5\6\4\2hi\7\24\2\2"+
		"ij\5\6\4\32j\u0082\3\2\2\2kl\f\30\2\2lm\t\2\2\2m\u0082\5\6\4\31no\f\27"+
		"\2\2op\t\3\2\2p\u0082\5\6\4\30qr\f\26\2\2rs\t\4\2\2s\u0082\5\6\4\27tu"+
		"\f\25\2\2uv\t\5\2\2v\u0082\5\6\4\26wx\f\22\2\2xy\7\35\2\2y\u0082\7*\2"+
		"\2z{\f\21\2\2{|\7\35\2\2|}\7\67\2\2}~\7\26\2\2~\177\5\4\3\2\177\u0080"+
		"\7\27\2\2\u0080\u0082\3\2\2\2\u0081e\3\2\2\2\u0081k\3\2\2\2\u0081n\3\2"+
		"\2\2\u0081q\3\2\2\2\u0081t\3\2\2\2\u0081w\3\2\2\2\u0081z\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\7\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0086\u0087\7\5\2\2\u0087\u0088\7\67\2\2\u0088\u0090"+
		"\7\5\2\2\u0089\u008a\7\5\2\2\u008a\u008b\78\2\2\u008b\u0090\7\5\2\2\u008c"+
		"\u008d\7\5\2\2\u008d\u008e\7\66\2\2\u008e\u0090\7\5\2\2\u008f\u0086\3"+
		"\2\2\2\u008f\u0089\3\2\2\2\u008f\u008c\3\2\2\2\u0090\t\3\2\2\2\u0091\u0095"+
		"\5\24\13\2\u0092\u0095\58\35\2\u0093\u0095\5\34\17\2\u0094\u0091\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\13\3\2\2\2\u0096\u009b"+
		"\5\n\6\2\u0097\u0098\5\n\6\2\u0098\u0099\5\f\7\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0096\3\2\2\2\u009a\u0097\3\2\2\2\u009b\r\3\2\2\2\u009c\u009d\7\67\2"+
		"\2\u009d\u009e\7\24\2\2\u009e\u009f\5\26\f\2\u009f\17\3\2\2\2\u00a0\u00a6"+
		"\5\16\b\2\u00a1\u00a2\5\16\b\2\u00a2\u00a3\7\25\2\2\u00a3\u00a4\5\20\t"+
		"\2\u00a4\u00a6\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6\21"+
		"\3\2\2\2\u00a7\u00aa\5\20\t\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\23\3\2\2\2\u00ab\u00ac\7\62\2\2\u00ac\u00ad"+
		"\7\67\2\2\u00ad\u00ae\7\32\2\2\u00ae\u00af\5\22\n\2\u00af\u00b0\7\33\2"+
		"\2\u00b0\u00b6\3\2\2\2\u00b1\u00b2\7\62\2\2\u00b2\u00b3\7\67\2\2\u00b3"+
		"\u00b4\7\23\2\2\u00b4\u00b6\5\26\f\2\u00b5\u00ab\3\2\2\2\u00b5\u00b1\3"+
		"\2\2\2\u00b6\25\3\2\2\2\u00b7\u00b8\b\f\1\2\u00b8\u00b9\7\67\2\2\u00b9"+
		"\u00c5\3\2\2\2\u00ba\u00bb\f\5\2\2\u00bb\u00c4\7)\2\2\u00bc\u00bd\f\4"+
		"\2\2\u00bd\u00be\7\30\2\2\u00be\u00c4\7\31\2\2\u00bf\u00c0\f\3\2\2\u00c0"+
		"\u00c1\7\30\2\2\u00c1\u00c2\7\66\2\2\u00c2\u00c4\7\31\2\2\u00c3\u00ba"+
		"\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\27\3\2\2\2\u00c7\u00c5\3\2\2"+
		"\2\u00c8\u00c9\5\26\f\2\u00c9\u00cd\7\67\2\2\u00ca\u00cc\5\32\16\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00d2\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00c8\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\31\3\2\2\2\u00d3\u00d4\7\25\2"+
		"\2\u00d4\u00d5\5\26\f\2\u00d5\u00d6\7\67\2\2\u00d6\33\3\2\2\2\u00d7\u00d8"+
		"\7\64\2\2\u00d8\u00d9\7\67\2\2\u00d9\u00da\7\23\2\2\u00da\u00e6\5\6\4"+
		"\2\u00db\u00dc\7\64\2\2\u00dc\u00dd\7\67\2\2\u00dd\u00de\7\24\2\2\u00de"+
		"\u00df\7\67\2\2\u00df\u00e0\7\23\2\2\u00e0\u00e6\5\6\4\2\u00e1\u00e2\7"+
		"\64\2\2\u00e2\u00e3\7\67\2\2\u00e3\u00e4\7\24\2\2\u00e4\u00e6\7\67\2\2"+
		"\u00e5\u00d7\3\2\2\2\u00e5\u00db\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e6\35"+
		"\3\2\2\2\u00e7\u00ed\5\6\4\2\u00e8\u00e9\5\6\4\2\u00e9\u00ea\7\25\2\2"+
		"\u00ea\u00eb\5\36\20\2\u00eb\u00ed\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e8"+
		"\3\2\2\2\u00ed\37\3\2\2\2\u00ee\u00ef\7\67\2\2\u00ef\u00f0\7\26\2\2\u00f0"+
		"\u00f7\7\27\2\2\u00f1\u00f2\7\67\2\2\u00f2\u00f3\7\26\2\2\u00f3\u00f4"+
		"\5\36\20\2\u00f4\u00f5\7\27\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00ee\3\2\2"+
		"\2\u00f6\u00f1\3\2\2\2\u00f7!\3\2\2\2\u00f8\u00f9\b\22\1\2\u00f9\u00fa"+
		"\7\67\2\2\u00fa\u00fb\7\35\2\2\u00fb\u0102\7\67\2\2\u00fc\u00fd\7\67\2"+
		"\2\u00fd\u00fe\7\30\2\2\u00fe\u00ff\5\6\4\2\u00ff\u0100\7\31\2\2\u0100"+
		"\u0102\3\2\2\2\u0101\u00f8\3\2\2\2\u0101\u00fc\3\2\2\2\u0102\u010d\3\2"+
		"\2\2\u0103\u0104\f\4\2\2\u0104\u0105\7\35\2\2\u0105\u010c\7\67\2\2\u0106"+
		"\u0107\f\3\2\2\u0107\u0108\7\30\2\2\u0108\u0109\5\6\4\2\u0109\u010a\7"+
		"\31\2\2\u010a\u010c\3\2\2\2\u010b\u0103\3\2\2\2\u010b\u0106\3\2\2\2\u010c"+
		"\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e#\3\2\2\2"+
		"\u010f\u010d\3\2\2\2\u0110\u0115\5\6\4\2\u0111\u0112\7\25\2\2\u0112\u0114"+
		"\5\6\4\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116%\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7\67\2\2"+
		"\u0119\u011a\7\23\2\2\u011a\u012c\5\6\4\2\u011b\u011c\5\"\22\2\u011c\u011d"+
		"\7\23\2\2\u011d\u011e\5\6\4\2\u011e\u012c\3\2\2\2\u011f\u0120\5\"\22\2"+
		"\u0120\u0121\7\23\2\2\u0121\u0122\7\32\2\2\u0122\u0123\5$\23\2\u0123\u0124"+
		"\7\33\2\2\u0124\u012c\3\2\2\2\u0125\u0126\7\67\2\2\u0126\u0127\7\23\2"+
		"\2\u0127\u0128\7\32\2\2\u0128\u0129\5$\23\2\u0129\u012a\7\33\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0118\3\2\2\2\u012b\u011b\3\2\2\2\u012b\u011f\3\2"+
		"\2\2\u012b\u0125\3\2\2\2\u012c\'\3\2\2\2\u012d\u012e\7\"\2\2\u012e\u012f"+
		"\7\26\2\2\u012f\u0130\5\6\4\2\u0130\u0131\7\27\2\2\u0131\u0132\7#\2\2"+
		"\u0132\u0133\5\66\34\2\u0133\u0134\7$\2\2\u0134\u0135\5\66\34\2\u0135"+
		"\u013e\3\2\2\2\u0136\u0137\7\"\2\2\u0137\u0138\7\26\2\2\u0138\u0139\5"+
		"\6\4\2\u0139\u013a\7\27\2\2\u013a\u013b\7#\2\2\u013b\u013c\5\66\34\2\u013c"+
		"\u013e\3\2\2\2\u013d\u012d\3\2\2\2\u013d\u0136\3\2\2\2\u013e)\3\2\2\2"+
		"\u013f\u0140\7%\2\2\u0140\u0141\7\26\2\2\u0141\u0142\5\6\4\2\u0142\u0143"+
		"\7\27\2\2\u0143\u0144\7.\2\2\u0144\u0145\5\66\34\2\u0145+\3\2\2\2\u0146"+
		"\u0147\7/\2\2\u0147\u0148\7\26\2\2\u0148\u0149\7\67\2\2\u0149\u014a\7"+
		"\24\2\2\u014a\u014b\5\6\4\2\u014b\u014c\7\27\2\2\u014c\u014d\5\66\34\2"+
		"\u014d-\3\2\2\2\u014e\u014f\7-\2\2\u014f\u0150\7\26\2\2\u0150\u0151\5"+
		"\6\4\2\u0151\u0152\7\27\2\2\u0152\u0153\7\34\2\2\u0153/\3\2\2\2\u0154"+
		"\u0155\7&\2\2\u0155\u0156\5\6\4\2\u0156\u0157\7\34\2\2\u0157\61\3\2\2"+
		"\2\u0158\u0159\5\6\4\2\u0159\u015a\7\34\2\2\u015a\63\3\2\2\2\u015b\u015c"+
		"\5\34\17\2\u015c\u015d\7\34\2\2\u015d\65\3\2\2\2\u015e\u0162\7\32\2\2"+
		"\u015f\u0161\5\66\34\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160"+
		"\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165"+
		"\u0170\7\33\2\2\u0166\u0170\5(\25\2\u0167\u0170\5*\26\2\u0168\u0170\5"+
		",\27\2\u0169\u0170\5.\30\2\u016a\u0170\5\60\31\2\u016b\u0170\5\64\33\2"+
		"\u016c\u016d\7\'\2\2\u016d\u0170\7\34\2\2\u016e\u0170\5\62\32\2\u016f"+
		"\u015e\3\2\2\2\u016f\u0166\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0168\3\2"+
		"\2\2\u016f\u0169\3\2\2\2\u016f\u016a\3\2\2\2\u016f\u016b\3\2\2\2\u016f"+
		"\u016c\3\2\2\2\u016f\u016e\3\2\2\2\u0170\67\3\2\2\2\u0171\u0172\7\63\2"+
		"\2\u0172\u0173\5\26\f\2\u0173\u0174\7\67\2\2\u0174\u0175\7\26\2\2\u0175"+
		"\u0176\5\30\r\2\u0176\u0177\7\27\2\2\u0177\u017b\7\32\2\2\u0178\u017a"+
		"\5\64\33\2\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2"+
		"\u017b\u017c\3\2\2\2\u017c\u0181\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0180"+
		"\5\66\34\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0184\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0185"+
		"\5\60\31\2\u0185\u0186\7\33\2\2\u01869\3\2\2\2\35Ac\u0081\u0083\u008f"+
		"\u0094\u009a\u00a5\u00a9\u00b5\u00c3\u00c5\u00cd\u00d1\u00e5\u00ec\u00f6"+
		"\u0101\u010b\u010d\u0115\u012b\u013d\u0162\u016f\u017b\u0181";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}