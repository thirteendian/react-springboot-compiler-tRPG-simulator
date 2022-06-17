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
		T__0=1, T__1=2, T__2=3, EQ=4, NEQ=5, ADD=6, SUB=7, MUL=8, DIV=9, MOD=10, 
		AND=11, OR=12, ASSIGN=13, COLON=14, COMMA=15, LPAREN=16, RPAREN=17, LBRACK=18, 
		RBRACK=19, LBRACE=20, RBRACE=21, SEMICOLON=22, DOT=23, NEW=24, ROLL=25, 
		SINGLEROLL=26, INT=27, ROLLKEY=28, IF=29, THEN=30, ELSE=31, WHILE=32, 
		RETURN=33, DO=34, FOR=35, TO=36, DEFTYPEKEY=37, DEFFUNKEY=38, DEFVARKEY=39, 
		ID=40, WS=41, OF=42;
	public static final int
		RULE_prog = 0, RULE_exps = 1, RULE_exp = 2, RULE_fields = 3, RULE_defType = 4, 
		RULE_typeID = 5, RULE_defFun = 6, RULE_funcallExp = 7, RULE_params = 8, 
		RULE_initArrayExp = 9, RULE_initStructExp = 10, RULE_defVar = 11, RULE_lvalue = 12, 
		RULE_ifStmt = 13, RULE_whileStmt = 14, RULE_forStmt = 15, RULE_returnStmt = 16, 
		RULE_stmts = 17, RULE_stmtList = 18, RULE_stmtField = 19, RULE_array = 20, 
		RULE_option = 21;
	public static final String[] ruleNames = {
		"prog", "exps", "exp", "fields", "defType", "typeID", "defFun", "funcallExp", 
		"params", "initArrayExp", "initStructExp", "defVar", "lvalue", "ifStmt", 
		"whileStmt", "forStmt", "returnStmt", "stmts", "stmtList", "stmtField", 
		"array", "option"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'array of'", "'option of'", "'=='", "'!='", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'&&'", "'||'", "'='", "':'", "','", "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "';'", "'.'", "'new'", null, null, null, null, 
		"'if'", "'then'", "'else'", "'while'", "'return'", "'do'", "'for'", "'to'", 
		"'type'", "'fun'", "'var'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "EQ", "NEQ", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"AND", "OR", "ASSIGN", "COLON", "COMMA", "LPAREN", "RPAREN", "LBRACK", 
		"RBRACK", "LBRACE", "RBRACE", "SEMICOLON", "DOT", "NEW", "ROLL", "SINGLEROLL", 
		"INT", "ROLLKEY", "IF", "THEN", "ELSE", "WHILE", "RETURN", "DO", "FOR", 
		"TO", "DEFTYPEKEY", "DEFFUNKEY", "DEFVARKEY", "ID", "WS", "OF"
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
			setState(44);
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
			setState(51);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				exp(0);
				setState(48);
				match(SEMICOLON);
				setState(49);
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
	public static class ArrayExpContext extends ExpContext {
		public InitArrayExpContext initArrayExp() {
			return getRuleContext(InitArrayExpContext.class,0);
		}
		public ArrayExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterArrayExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitArrayExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitArrayExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunExpContext extends ExpContext {
		public FuncallExpContext funcallExp() {
			return getRuleContext(FuncallExpContext.class,0);
		}
		public FunExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFunExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFunExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFunExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareExpContext extends ExpContext {
		public ExpContext leftExp;
		public Token op;
		public ExpContext rightExp;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode EQ() { return getToken(inputParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(inputParser.NEQ, 0); }
		public CompareExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterCompareExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitCompareExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitCompareExp(this);
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
	public static class VarExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public VarExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitVarExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeDefExpContext extends ExpContext {
		public DefTypeContext defType() {
			return getRuleContext(DefTypeContext.class,0);
		}
		public TypeDefExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterTypeDefExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitTypeDefExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitTypeDefExp(this);
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
		public TerminalNode ADD() { return getToken(inputParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(inputParser.SUB, 0); }
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
	public static class FunDefExpContext extends ExpContext {
		public DefFunContext defFun() {
			return getRuleContext(DefFunContext.class,0);
		}
		public FunDefExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFunDefExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFunDefExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFunDefExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDefExpContext extends ExpContext {
		public DefVarContext defVar() {
			return getRuleContext(DefVarContext.class,0);
		}
		public VarDefExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterVarDefExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitVarDefExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitVarDefExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructExpContext extends ExpContext {
		public InitStructExpContext initStructExp() {
			return getRuleContext(InitStructExpContext.class,0);
		}
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
	public static class LogicExpContext extends ExpContext {
		public ExpContext leftExp;
		public Token op;
		public ExpContext rightExp;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode AND() { return getToken(inputParser.AND, 0); }
		public TerminalNode OR() { return getToken(inputParser.OR, 0); }
		public LogicExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterLogicExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitLogicExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitLogicExp(this);
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
	public static class ValueExpContext extends ExpContext {
		public Token value;
		public TerminalNode INT() { return getToken(inputParser.INT, 0); }
		public ValueExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterValueExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitValueExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitValueExp(this);
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
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new RollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				match(ROLL);
				}
				break;
			case 2:
				{
				_localctx = new SingleRollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				match(SINGLEROLL);
				}
				break;
			case 3:
				{
				_localctx = new ParensExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(LPAREN);
				setState(57);
				exp(0);
				setState(58);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ValueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				((ValueExpContext)_localctx).value = match(INT);
				}
				break;
			case 6:
				{
				_localctx = new TypeDefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				defType();
				}
				break;
			case 7:
				{
				_localctx = new FunDefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				defFun();
				}
				break;
			case 8:
				{
				_localctx = new VarDefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				defVar();
				}
				break;
			case 9:
				{
				_localctx = new NilExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			case 10:
				{
				_localctx = new ExpListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(LBRACE);
				setState(67);
				exps();
				setState(68);
				match(RBRACE);
				}
				break;
			case 11:
				{
				_localctx = new ArrayExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				initArrayExp();
				}
				break;
			case 12:
				{
				_localctx = new FunExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				funcallExp();
				}
				break;
			case 13:
				{
				_localctx = new StructExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				initStructExp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionalExpContext(new ExpContext(_parentctx, _parentState));
						((ConditionalExpContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(75);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(76);
						match(T__0);
						setState(77);
						((ConditionalExpContext)_localctx).opt1 = exp(0);
						setState(78);
						match(COLON);
						setState(79);
						((ConditionalExpContext)_localctx).opt2 = exp(17);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(81);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(82);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(83);
						((ArithmeticExpContext)_localctx).rightExp = exp(16);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(84);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(85);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(86);
						((ArithmeticExpContext)_localctx).rightExp = exp(15);
						}
						break;
					case 4:
						{
						_localctx = new LogicExpContext(new ExpContext(_parentctx, _parentState));
						((LogicExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(87);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(88);
						((LogicExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
							((LogicExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(89);
						((LogicExpContext)_localctx).rightExp = exp(14);
						}
						break;
					case 5:
						{
						_localctx = new CompareExpContext(new ExpContext(_parentctx, _parentState));
						((CompareExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(90);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(91);
						((CompareExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((CompareExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(92);
						((CompareExpContext)_localctx).rightExp = exp(13);
						}
						break;
					}
					} 
				}
				setState(97);
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

	public static class FieldsContext extends ParserRuleContext {
		public TypeIDContext idExp;
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(inputParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(inputParser.COLON, i);
		}
		public List<TypeIDContext> typeID() {
			return getRuleContexts(TypeIDContext.class);
		}
		public TypeIDContext typeID(int i) {
			return getRuleContext(TypeIDContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(inputParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(inputParser.COMMA, i);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitFields(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitFields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fields);
		int _la;
		try {
			setState(111);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(ID);
				setState(99);
				match(COLON);
				setState(100);
				((FieldsContext)_localctx).idExp = typeID();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(101);
					match(COMMA);
					setState(102);
					match(ID);
					setState(103);
					match(COLON);
					setState(104);
					((FieldsContext)_localctx).idExp = typeID();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
			case RBRACE:
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
		public TypeIDContext idExp;
		public TypeIDContext refer;
		public TerminalNode DEFTYPEKEY() { return getToken(inputParser.DEFTYPEKEY, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public List<TypeIDContext> typeID() {
			return getRuleContexts(TypeIDContext.class);
		}
		public TypeIDContext typeID(int i) {
			return getRuleContext(TypeIDContext.class,i);
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
		public TypeIDContext idExp;
		public TerminalNode DEFTYPEKEY() { return getToken(inputParser.DEFTYPEKEY, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_defType);
		try {
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RegularTypeDefExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(DEFTYPEKEY);
				setState(114);
				((RegularTypeDefExpContext)_localctx).idExp = typeID();
				setState(115);
				match(LBRACE);
				setState(116);
				fields();
				setState(117);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new AssignTypeDefExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(DEFTYPEKEY);
				setState(120);
				((AssignTypeDefExpContext)_localctx).idExp = typeID();
				setState(121);
				match(ASSIGN);
				setState(122);
				((AssignTypeDefExpContext)_localctx).refer = typeID();
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
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public OptionContext option() {
			return getRuleContext(OptionContext.class,0);
		}
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
		TypeIDContext _localctx = new TypeIDContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeID);
		try {
			setState(129);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ID);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				array();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				option();
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

	public static class DefFunContext extends ParserRuleContext {
		public TerminalNode DEFFUNKEY() { return getToken(inputParser.DEFFUNKEY, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
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
		enterRule(_localctx, 12, RULE_defFun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(DEFFUNKEY);
			setState(132);
			typeID();
			setState(133);
			match(ID);
			setState(134);
			match(LPAREN);
			setState(135);
			fields();
			setState(136);
			match(RPAREN);
			setState(137);
			match(LBRACE);
			setState(138);
			stmtList();
			setState(139);
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
		enterRule(_localctx, 14, RULE_funcallExp);
		try {
			setState(149);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(ID);
				setState(142);
				match(LPAREN);
				setState(143);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(ID);
				setState(145);
				match(LPAREN);
				setState(146);
				params();
				setState(147);
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

	public static class ParamsContext extends ParserRuleContext {
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
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			exp(0);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				exp(0);
				}
				}
				setState(158);
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

	public static class InitArrayExpContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(inputParser.NEW, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(inputParser.LBRACK, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(inputParser.RBRACK, 0); }
		public TerminalNode OF() { return getToken(inputParser.OF, 0); }
		public InitArrayExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initArrayExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterInitArrayExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitInitArrayExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitInitArrayExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitArrayExpContext initArrayExp() throws RecognitionException {
		InitArrayExpContext _localctx = new InitArrayExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_initArrayExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(NEW);
			setState(160);
			match(ID);
			setState(161);
			match(LBRACK);
			setState(162);
			exp(0);
			setState(163);
			match(RBRACK);
			setState(164);
			match(OF);
			setState(165);
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

	public static class InitStructExpContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(inputParser.NEW, 0); }
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(inputParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(inputParser.ASSIGN, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(inputParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(inputParser.COMMA, i);
		}
		public InitStructExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initStructExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterInitStructExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitInitStructExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitInitStructExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitStructExpContext initStructExp() throws RecognitionException {
		InitStructExpContext _localctx = new InitStructExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initStructExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(NEW);
			setState(168);
			match(ID);
			setState(169);
			match(LBRACE);
			setState(170);
			match(ID);
			setState(171);
			match(ASSIGN);
			setState(172);
			exp(0);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173);
				match(COMMA);
				setState(174);
				match(ID);
				setState(175);
				match(ASSIGN);
				setState(176);
				exp(0);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
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

	public static class DefVarContext extends ParserRuleContext {
		public TerminalNode DEFVARKEY() { return getToken(inputParser.DEFVARKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode COLON() { return getToken(inputParser.COLON, 0); }
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_defVar);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(DEFVARKEY);
				setState(185);
				match(ID);
				setState(186);
				match(ASSIGN);
				setState(187);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(DEFVARKEY);
				setState(189);
				match(ID);
				setState(190);
				match(COLON);
				setState(191);
				typeID();
				setState(192);
				match(ASSIGN);
				setState(193);
				exp(0);
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
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode DOT() { return getToken(inputParser.DOT, 0); }
		public TerminalNode LBRACK() { return getToken(inputParser.LBRACK, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(inputParser.RBRACK, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitLvalue(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(198);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(200);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(201);
						match(DOT);
						setState(202);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(203);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(204);
						match(LBRACK);
						setState(205);
						exp(0);
						setState(206);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExpContext condExp;
		public StmtFieldContext op1;
		public StmtFieldContext op2;
		public TerminalNode IF() { return getToken(inputParser.IF, 0); }
		public TerminalNode THEN() { return getToken(inputParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(inputParser.ELSE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmtFieldContext> stmtField() {
			return getRuleContexts(StmtFieldContext.class);
		}
		public StmtFieldContext stmtField(int i) {
			return getRuleContext(StmtFieldContext.class,i);
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
		enterRule(_localctx, 26, RULE_ifStmt);
		try {
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(IF);
				setState(214);
				((IfStmtContext)_localctx).condExp = exp(0);
				setState(215);
				match(THEN);
				setState(216);
				((IfStmtContext)_localctx).op1 = stmtField();
				setState(217);
				match(ELSE);
				setState(218);
				((IfStmtContext)_localctx).op2 = stmtField();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(IF);
				setState(221);
				((IfStmtContext)_localctx).condExp = exp(0);
				setState(222);
				match(THEN);
				setState(223);
				((IfStmtContext)_localctx).op1 = stmtField();
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode DO() { return getToken(inputParser.DO, 0); }
		public StmtFieldContext stmtField() {
			return getRuleContext(StmtFieldContext.class,0);
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
		enterRule(_localctx, 28, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(WHILE);
			setState(228);
			exp(0);
			setState(229);
			match(DO);
			setState(230);
			stmtField();
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
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(inputParser.ASSIGN, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode TO() { return getToken(inputParser.TO, 0); }
		public TerminalNode DO() { return getToken(inputParser.DO, 0); }
		public StmtFieldContext stmtField() {
			return getRuleContext(StmtFieldContext.class,0);
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
		enterRule(_localctx, 30, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(FOR);
			setState(233);
			match(ID);
			setState(234);
			match(ASSIGN);
			setState(235);
			exp(0);
			setState(236);
			match(TO);
			setState(237);
			exp(0);
			setState(238);
			match(DO);
			setState(239);
			stmtField();
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
		enterRule(_localctx, 32, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(RETURN);
			setState(242);
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

	public static class StmtsContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
		enterRule(_localctx, 34, RULE_stmts);
		try {
			setState(249);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				ifStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				forStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				returnStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(248);
				exp(0);
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
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(inputParser.SEMICOLON, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStmtList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStmtList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmtList);
		try {
			setState(256);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				stmts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				stmts();
				setState(253);
				match(SEMICOLON);
				setState(254);
				stmtList();
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

	public static class StmtFieldContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterStmtField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitStmtField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitStmtField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtFieldContext stmtField() throws RecognitionException {
		StmtFieldContext _localctx = new StmtFieldContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stmtField);
		try {
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(LBRACE);
				setState(259);
				stmtList();
				setState(260);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				stmts();
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

	public static class ArrayContext extends ParserRuleContext {
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__1);
			setState(266);
			typeID();
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

	public static class OptionContext extends ParserRuleContext {
		public TypeIDContext typeID() {
			return getRuleContext(TypeIDContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__2);
			setState(269);
			typeID();
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
		case 12:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u0112\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4`\n\4\f\4\16\4c\13\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5l\n\5\f\5\16\5o\13\5\3\5\5\5r\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\7\3\7\3\7\5\7\u0084"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0098\n\t\3\n\3\n\3\n\7\n\u009d\n\n\f\n\16\n\u00a0\13\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\7\f\u00b4\n\f\f\f\16\f\u00b7\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u00d3\n\16\f\16\16\16\u00d6\13\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e4\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u00fc\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0103\n\24\3\25\3\25\3\25\3\25\3\25\5\25\u010a\n\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\2\4\6\32\30\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,\2\6\3\2\n\13\3\2\b\t\3\2\r\16\3\2\6\7\u011f\2.\3\2\2"+
		"\2\4\65\3\2\2\2\6K\3\2\2\2\bq\3\2\2\2\n~\3\2\2\2\f\u0083\3\2\2\2\16\u0085"+
		"\3\2\2\2\20\u0097\3\2\2\2\22\u0099\3\2\2\2\24\u00a1\3\2\2\2\26\u00a9\3"+
		"\2\2\2\30\u00c5\3\2\2\2\32\u00c7\3\2\2\2\34\u00e3\3\2\2\2\36\u00e5\3\2"+
		"\2\2 \u00ea\3\2\2\2\"\u00f3\3\2\2\2$\u00fb\3\2\2\2&\u0102\3\2\2\2(\u0109"+
		"\3\2\2\2*\u010b\3\2\2\2,\u010e\3\2\2\2./\5\6\4\2/\3\3\2\2\2\60\66\5\6"+
		"\4\2\61\62\5\6\4\2\62\63\7\30\2\2\63\64\5\4\3\2\64\66\3\2\2\2\65\60\3"+
		"\2\2\2\65\61\3\2\2\2\66\5\3\2\2\2\678\b\4\1\28L\7\33\2\29L\7\34\2\2:;"+
		"\7\22\2\2;<\5\6\4\2<=\7\23\2\2=L\3\2\2\2>L\7*\2\2?L\7\35\2\2@L\5\n\6\2"+
		"AL\5\16\b\2BL\5\30\r\2CL\3\2\2\2DE\7\26\2\2EF\5\4\3\2FG\7\27\2\2GL\3\2"+
		"\2\2HL\5\24\13\2IL\5\20\t\2JL\5\26\f\2K\67\3\2\2\2K9\3\2\2\2K:\3\2\2\2"+
		"K>\3\2\2\2K?\3\2\2\2K@\3\2\2\2KA\3\2\2\2KB\3\2\2\2KC\3\2\2\2KD\3\2\2\2"+
		"KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2La\3\2\2\2MN\f\22\2\2NO\7\3\2\2OP\5\6\4"+
		"\2PQ\7\20\2\2QR\5\6\4\23R`\3\2\2\2ST\f\21\2\2TU\t\2\2\2U`\5\6\4\22VW\f"+
		"\20\2\2WX\t\3\2\2X`\5\6\4\21YZ\f\17\2\2Z[\t\4\2\2[`\5\6\4\20\\]\f\16\2"+
		"\2]^\t\5\2\2^`\5\6\4\17_M\3\2\2\2_S\3\2\2\2_V\3\2\2\2_Y\3\2\2\2_\\\3\2"+
		"\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\7\3\2\2\2ca\3\2\2\2de\7*\2\2ef\7\20"+
		"\2\2fm\5\f\7\2gh\7\21\2\2hi\7*\2\2ij\7\20\2\2jl\5\f\7\2kg\3\2\2\2lo\3"+
		"\2\2\2mk\3\2\2\2mn\3\2\2\2nr\3\2\2\2om\3\2\2\2pr\3\2\2\2qd\3\2\2\2qp\3"+
		"\2\2\2r\t\3\2\2\2st\7\'\2\2tu\5\f\7\2uv\7\26\2\2vw\5\b\5\2wx\7\27\2\2"+
		"x\177\3\2\2\2yz\7\'\2\2z{\5\f\7\2{|\7\17\2\2|}\5\f\7\2}\177\3\2\2\2~s"+
		"\3\2\2\2~y\3\2\2\2\177\13\3\2\2\2\u0080\u0084\7*\2\2\u0081\u0084\5*\26"+
		"\2\u0082\u0084\5,\27\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082"+
		"\3\2\2\2\u0084\r\3\2\2\2\u0085\u0086\7(\2\2\u0086\u0087\5\f\7\2\u0087"+
		"\u0088\7*\2\2\u0088\u0089\7\22\2\2\u0089\u008a\5\b\5\2\u008a\u008b\7\23"+
		"\2\2\u008b\u008c\7\26\2\2\u008c\u008d\5&\24\2\u008d\u008e\7\27\2\2\u008e"+
		"\17\3\2\2\2\u008f\u0090\7*\2\2\u0090\u0091\7\22\2\2\u0091\u0098\7\23\2"+
		"\2\u0092\u0093\7*\2\2\u0093\u0094\7\22\2\2\u0094\u0095\5\22\n\2\u0095"+
		"\u0096\7\23\2\2\u0096\u0098\3\2\2\2\u0097\u008f\3\2\2\2\u0097\u0092\3"+
		"\2\2\2\u0098\21\3\2\2\2\u0099\u009e\5\6\4\2\u009a\u009b\7\21\2\2\u009b"+
		"\u009d\5\6\4\2\u009c\u009a\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\23\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2"+
		"\7\32\2\2\u00a2\u00a3\7*\2\2\u00a3\u00a4\7\24\2\2\u00a4\u00a5\5\6\4\2"+
		"\u00a5\u00a6\7\25\2\2\u00a6\u00a7\7,\2\2\u00a7\u00a8\5\6\4\2\u00a8\25"+
		"\3\2\2\2\u00a9\u00aa\7\32\2\2\u00aa\u00ab\7*\2\2\u00ab\u00ac\7\26\2\2"+
		"\u00ac\u00ad\7*\2\2\u00ad\u00ae\7\17\2\2\u00ae\u00b5\5\6\4\2\u00af\u00b0"+
		"\7\21\2\2\u00b0\u00b1\7*\2\2\u00b1\u00b2\7\17\2\2\u00b2\u00b4\5\6\4\2"+
		"\u00b3\u00af\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6"+
		"\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\27\2\2"+
		"\u00b9\27\3\2\2\2\u00ba\u00bb\7)\2\2\u00bb\u00bc\7*\2\2\u00bc\u00bd\7"+
		"\17\2\2\u00bd\u00c6\5\6\4\2\u00be\u00bf\7)\2\2\u00bf\u00c0\7*\2\2\u00c0"+
		"\u00c1\7\20\2\2\u00c1\u00c2\5\f\7\2\u00c2\u00c3\7\17\2\2\u00c3\u00c4\5"+
		"\6\4\2\u00c4\u00c6\3\2\2\2\u00c5\u00ba\3\2\2\2\u00c5\u00be\3\2\2\2\u00c6"+
		"\31\3\2\2\2\u00c7\u00c8\b\16\1\2\u00c8\u00c9\7*\2\2\u00c9\u00d4\3\2\2"+
		"\2\u00ca\u00cb\f\4\2\2\u00cb\u00cc\7\31\2\2\u00cc\u00d3\7*\2\2\u00cd\u00ce"+
		"\f\3\2\2\u00ce\u00cf\7\24\2\2\u00cf\u00d0\5\6\4\2\u00d0\u00d1\7\25\2\2"+
		"\u00d1\u00d3\3\2\2\2\u00d2\u00ca\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d3\u00d6"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\33\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00d8\7\37\2\2\u00d8\u00d9\5\6\4\2\u00d9\u00da\7"+
		" \2\2\u00da\u00db\5(\25\2\u00db\u00dc\7!\2\2\u00dc\u00dd\5(\25\2\u00dd"+
		"\u00e4\3\2\2\2\u00de\u00df\7\37\2\2\u00df\u00e0\5\6\4\2\u00e0\u00e1\7"+
		" \2\2\u00e1\u00e2\5(\25\2\u00e2\u00e4\3\2\2\2\u00e3\u00d7\3\2\2\2\u00e3"+
		"\u00de\3\2\2\2\u00e4\35\3\2\2\2\u00e5\u00e6\7\"\2\2\u00e6\u00e7\5\6\4"+
		"\2\u00e7\u00e8\7$\2\2\u00e8\u00e9\5(\25\2\u00e9\37\3\2\2\2\u00ea\u00eb"+
		"\7%\2\2\u00eb\u00ec\7*\2\2\u00ec\u00ed\7\17\2\2\u00ed\u00ee\5\6\4\2\u00ee"+
		"\u00ef\7&\2\2\u00ef\u00f0\5\6\4\2\u00f0\u00f1\7$\2\2\u00f1\u00f2\5(\25"+
		"\2\u00f2!\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4\u00f5\5\6\4\2\u00f5#\3\2\2"+
		"\2\u00f6\u00fc\5\34\17\2\u00f7\u00fc\5\36\20\2\u00f8\u00fc\5 \21\2\u00f9"+
		"\u00fc\5\"\22\2\u00fa\u00fc\5\6\4\2\u00fb\u00f6\3\2\2\2\u00fb\u00f7\3"+
		"\2\2\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"%\3\2\2\2\u00fd\u0103\5$\23\2\u00fe\u00ff\5$\23\2\u00ff\u0100\7\30\2\2"+
		"\u0100\u0101\5&\24\2\u0101\u0103\3\2\2\2\u0102\u00fd\3\2\2\2\u0102\u00fe"+
		"\3\2\2\2\u0103\'\3\2\2\2\u0104\u0105\7\26\2\2\u0105\u0106\5&\24\2\u0106"+
		"\u0107\7\27\2\2\u0107\u010a\3\2\2\2\u0108\u010a\5$\23\2\u0109\u0104\3"+
		"\2\2\2\u0109\u0108\3\2\2\2\u010a)\3\2\2\2\u010b\u010c\7\4\2\2\u010c\u010d"+
		"\5\f\7\2\u010d+\3\2\2\2\u010e\u010f\7\5\2\2\u010f\u0110\5\f\7\2\u0110"+
		"-\3\2\2\2\24\65K_amq~\u0083\u0097\u009e\u00b5\u00c5\u00d2\u00d4\u00e3"+
		"\u00fb\u0102\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}