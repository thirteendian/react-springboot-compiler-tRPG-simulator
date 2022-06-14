// Generated from edu\duke\summer\client\algorithm\input.g4 by ANTLR 4.5
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
	 * Visit a parse tree produced by {@link inputParser#exps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExps(inputParser.ExpsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nilExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNilExp(inputParser.NilExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExp(inputParser.ArrayExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunExp(inputParser.FunExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExp(inputParser.CompareExpContext ctx);
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
	 * Visit a parse tree produced by the {@code expList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList(inputParser.ExpListContext ctx);
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
	 * Visit a parse tree produced by the {@code varDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefExp(inputParser.VarDefExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExp(inputParser.StructExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExp(inputParser.LogicExpContext ctx);
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
	 * Visit a parse tree produced by {@link inputParser#fields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFields(inputParser.FieldsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regularTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularTypeDefExp(inputParser.RegularTypeDefExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#typeID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeID(inputParser.TypeIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFun(inputParser.DefFunContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#funcallExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncallExp(inputParser.FuncallExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(inputParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#initArrayExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitArrayExp(inputParser.InitArrayExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#initStructExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitStructExp(inputParser.InitStructExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVar(inputParser.DefVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(inputParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(inputParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(inputParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(inputParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(inputParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(inputParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#stmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtList(inputParser.StmtListContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#stmtField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtField(inputParser.StmtFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(inputParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(inputParser.OptionContext ctx);
}