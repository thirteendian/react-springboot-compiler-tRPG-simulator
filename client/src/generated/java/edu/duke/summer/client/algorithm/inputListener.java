// Generated from edu/duke/summer/client/algorithm/input.g4 by ANTLR 4.5
package edu.duke.summer.client.algorithm;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link inputParser}.
 */
public interface inputListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link inputParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(inputParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(inputParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterParensExp(inputParser.ParensExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitParensExp(inputParser.ParensExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(inputParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(inputParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefExp(inputParser.TypeDefExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefExp(inputParser.TypeDefExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nilExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNilExp(inputParser.NilExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nilExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNilExp(inputParser.NilExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExp(inputParser.ArithmeticExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExp(inputParser.ArithmeticExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRollExp(inputParser.RollExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRollExp(inputParser.RollExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleRollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSingleRollExp(inputParser.SingleRollExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleRollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSingleRollExp(inputParser.SingleRollExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunDefExp(inputParser.FunDefExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunDefExp(inputParser.FunDefExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExp(inputParser.ConditionalExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExp(inputParser.ConditionalExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterValueExp(inputParser.ValueExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitValueExp(inputParser.ValueExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#defTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterDefTypeBody(inputParser.DefTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#defTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitDefTypeBody(inputParser.DefTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void enterDefType(inputParser.DefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void exitDefType(inputParser.DefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#fields}.
	 * @param ctx the parse tree
	 */
	void enterFields(inputParser.FieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#fields}.
	 * @param ctx the parse tree
	 */
	void exitFields(inputParser.FieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 */
	void enterDefFun(inputParser.DefFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 */
	void exitDefFun(inputParser.DefFunContext ctx);
}