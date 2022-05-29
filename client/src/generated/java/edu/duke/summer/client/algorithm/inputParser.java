// Generated from edu/duke/summer/client/algorithm/input.g4 by ANTLR 4.5
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
		T__0=1, ADD=2, SUB=3, MUL=4, DIV=5, COLON=6, COMMA=7, LPAREN=8, RPAREN=9, 
		LBRACE=10, RBRACE=11, SEMICOLON=12, ROLL=13, SINGLEROLL=14, INT=15, ROLLKEY=16, 
		DEFTYPEKEY=17, DEFFUNKEY=18, ID=19, WS=20;
	public static final int
		RULE_prog = 0, RULE_exp = 1, RULE_defTypeBody = 2, RULE_defType = 3, RULE_fields = 4, 
		RULE_defFun = 5;
	public static final String[] ruleNames = {
		"prog", "exp", "defTypeBody", "defType", "fields", "defFun"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'+'", "'-'", "'*'", "'/'", "':'", "','", "'('", "')'", "'{'", 
		"'}'", "';'", null, null, null, null, "'deftype'", "'deffun'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ADD", "SUB", "MUL", "DIV", "COLON", "COMMA", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "SEMICOLON", "ROLL", "SINGLEROLL", "INT", "ROLLKEY", 
		"DEFTYPEKEY", "DEFFUNKEY", "ID", "WS"
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
			setState(12);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new RollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(15);
				match(ROLL);
				}
				break;
			case 2:
				{
				_localctx = new SingleRollExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(SINGLEROLL);
				}
				break;
			case 3:
				{
				_localctx = new ParensExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(LPAREN);
				setState(18);
				exp(0);
				setState(19);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ValueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				((ValueExpContext)_localctx).value = match(INT);
				}
				break;
			case 6:
				{
				_localctx = new TypeDefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				defType();
				}
				break;
			case 7:
				{
				_localctx = new FunDefExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				defFun();
				}
				break;
			case 8:
				{
				_localctx = new NilExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(40);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(28);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(29);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(30);
						((ArithmeticExpContext)_localctx).rightExp = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpContext(new ExpContext(_parentctx, _parentState));
						((ArithmeticExpContext)_localctx).leftExp = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(31);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(32);
						((ArithmeticExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ArithmeticExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(33);
						((ArithmeticExpContext)_localctx).rightExp = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new ConditionalExpContext(new ExpContext(_parentctx, _parentState));
						((ConditionalExpContext)_localctx).cond = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(34);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(35);
						match(T__0);
						setState(36);
						((ConditionalExpContext)_localctx).opt1 = exp(0);
						setState(37);
						match(COLON);
						setState(38);
						((ConditionalExpContext)_localctx).opt2 = exp(7);
						}
						break;
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class DefTypeBodyContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(inputParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(inputParser.COLON, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(inputParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(inputParser.COMMA, i);
		}
		public DefTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDefTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDefTypeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDefTypeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefTypeBodyContext defTypeBody() throws RecognitionException {
		DefTypeBodyContext _localctx = new DefTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(45);
				match(ID);
				setState(46);
				match(COLON);
				setState(47);
				match(ID);
				setState(48);
				match(COMMA);
				}
				}
				setState(53);
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

	public static class DefTypeContext extends ParserRuleContext {
		public TerminalNode DEFTYPEKEY() { return getToken(inputParser.DEFTYPEKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public DefTypeBodyContext defTypeBody() {
			return getRuleContext(DefTypeBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(inputParser.RBRACE, 0); }
		public DefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).enterDefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof inputListener ) ((inputListener)listener).exitDefType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof inputVisitor ) return ((inputVisitor<? extends T>)visitor).visitDefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefTypeContext defType() throws RecognitionException {
		DefTypeContext _localctx = new DefTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(DEFTYPEKEY);
			setState(55);
			match(ID);
			setState(56);
			match(LBRACE);
			setState(57);
			defTypeBody();
			setState(58);
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

	public static class FieldsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(inputParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(inputParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(inputParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(inputParser.COLON, i);
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
		enterRule(_localctx, 8, RULE_fields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(ID);
			setState(61);
			match(COLON);
			setState(62);
			match(ID);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(63);
				match(COMMA);
				setState(64);
				match(ID);
				setState(65);
				match(COLON);
				setState(66);
				match(ID);
				}
				}
				setState(71);
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

	public static class DefFunContext extends ParserRuleContext {
		public TerminalNode DEFFUNKEY() { return getToken(inputParser.DEFFUNKEY, 0); }
		public TerminalNode ID() { return getToken(inputParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(inputParser.LPAREN, 0); }
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(inputParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(inputParser.LBRACE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
		enterRule(_localctx, 10, RULE_defFun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(DEFFUNKEY);
			setState(73);
			match(ID);
			setState(74);
			match(LPAREN);
			setState(75);
			fields();
			setState(76);
			match(RPAREN);
			setState(77);
			match(LBRACE);
			setState(78);
			exp(0);
			setState(79);
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
		case 1:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26T\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\4\3\4\3\4\3\4\7\4\64\n\4\f\4\16\4"+
		"\67\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6F\n\6"+
		"\f\6\16\6I\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\2\3\4\b\2\4\6"+
		"\b\n\f\2\4\3\2\6\7\3\2\4\5Y\2\16\3\2\2\2\4\34\3\2\2\2\6\65\3\2\2\2\b8"+
		"\3\2\2\2\n>\3\2\2\2\fJ\3\2\2\2\16\17\5\4\3\2\17\3\3\2\2\2\20\21\b\3\1"+
		"\2\21\35\7\17\2\2\22\35\7\20\2\2\23\24\7\n\2\2\24\25\5\4\3\2\25\26\7\13"+
		"\2\2\26\35\3\2\2\2\27\35\7\25\2\2\30\35\7\21\2\2\31\35\5\b\5\2\32\35\5"+
		"\f\7\2\33\35\3\2\2\2\34\20\3\2\2\2\34\22\3\2\2\2\34\23\3\2\2\2\34\27\3"+
		"\2\2\2\34\30\3\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35,\3\2"+
		"\2\2\36\37\f\13\2\2\37 \t\2\2\2 +\5\4\3\f!\"\f\n\2\2\"#\t\3\2\2#+\5\4"+
		"\3\13$%\f\b\2\2%&\7\3\2\2&\'\5\4\3\2\'(\7\b\2\2()\5\4\3\t)+\3\2\2\2*\36"+
		"\3\2\2\2*!\3\2\2\2*$\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2"+
		".,\3\2\2\2/\60\7\25\2\2\60\61\7\b\2\2\61\62\7\25\2\2\62\64\7\t\2\2\63"+
		"/\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\7\3\2\2\2\67\65"+
		"\3\2\2\289\7\23\2\29:\7\25\2\2:;\7\f\2\2;<\5\6\4\2<=\7\r\2\2=\t\3\2\2"+
		"\2>?\7\25\2\2?@\7\b\2\2@G\7\25\2\2AB\7\t\2\2BC\7\25\2\2CD\7\b\2\2DF\7"+
		"\25\2\2EA\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\13\3\2\2\2IG\3\2\2\2"+
		"JK\7\24\2\2KL\7\25\2\2LM\7\n\2\2MN\5\n\6\2NO\7\13\2\2OP\7\f\2\2PQ\5\4"+
		"\3\2QR\7\r\2\2R\r\3\2\2\2\7\34*,\65G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}