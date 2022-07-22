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
	 * Visit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExp(inputParser.AssignExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lenExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenExp(inputParser.LenExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueExp(inputParser.LvalueExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExp(inputParser.CallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExp(inputParser.ParensExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uminusExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUminusExp(inputParser.UminusExpContext ctx);
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
	 * Visit a parse tree produced by the {@code nonExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonExp(inputParser.NonExpContext ctx);
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
	 * Visit a parse tree produced by the {@code trueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExp(inputParser.TrueExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructExp(inputParser.StructExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleVarExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleVarExp(inputParser.SimpleVarExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExp(inputParser.FalseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExp(inputParser.ConditionalExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExp(inputParser.StringExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quoStrExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoStrExp(inputParser.QuoStrExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExp(inputParser.IntExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecList(inputParser.DecListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldFunCallExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldFunCallExp(inputParser.FieldFunCallExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#strExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExp(inputParser.StrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(inputParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#decs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecs(inputParser.DecsContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#typefield}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypefield(inputParser.TypefieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#typefields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypefields(inputParser.TypefieldsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code regularFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularFields(inputParser.RegularFieldsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyFields(inputParser.EmptyFieldsContext ctx);
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
	 * Visit a parse tree produced by {@link inputParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(inputParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#paramRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamRest(inputParser.ParamRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefVar(inputParser.DefVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParam(inputParser.SingleParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulParam(inputParser.MulParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#funcallExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncallExp(inputParser.FuncallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleFieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFieldVar(inputParser.SimpleFieldVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptVar(inputParser.SubscriptVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleSubscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleSubscriptVar(inputParser.SimpleSubscriptVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldVar(inputParser.FieldVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#initArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitArray(inputParser.InitArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleAssign(inputParser.SimpleAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lvalueAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalueAssign(inputParser.LvalueAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code initArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitArrayAssign(inputParser.InitArrayAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleInitArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleInitArrayAssign(inputParser.SimpleInitArrayAssignContext ctx);
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
	 * Visit a parse tree produced by {@link inputParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(inputParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(inputParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#expStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpStmt(inputParser.ExpStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#decStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecStmt(inputParser.DecStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(inputParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFun(inputParser.DefFunContext ctx);
}