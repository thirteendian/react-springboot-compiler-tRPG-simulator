// Generated from edu/duke/summer/client/algorithm/input.g4 by ANTLR 4.5
package edu.duke.summer.client.algorithm;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link inputParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface inputVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link inputParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(inputParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExp(inputParser.ParensExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExp(inputParser.VarExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefExp(inputParser.TypeDefExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nilExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilExp(inputParser.NilExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithmeticExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExp(inputParser.ArithmeticExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRollExp(inputParser.RollExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleRollExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleRollExp(inputParser.SingleRollExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDefExp(inputParser.FunDefExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExp(inputParser.ConditionalExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExp(inputParser.ValueExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defTypeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefTypeBody(inputParser.DefTypeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefType(inputParser.DefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(inputParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFun(inputParser.DefFunContext ctx);
}