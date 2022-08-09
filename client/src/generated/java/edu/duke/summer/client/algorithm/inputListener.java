// Generated from edu\duke\summer\client\algorithm\input.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by {@link inputParser#exps}.
	 * @param ctx the parse tree
	 */
	void enterExps(inputParser.ExpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#exps}.
	 * @param ctx the parse tree
	 */
	void exitExps(inputParser.ExpsContext ctx);
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
	 * Enter a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAssignExp(inputParser.AssignExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAssignExp(inputParser.AssignExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lenExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLenExp(inputParser.LenExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lenExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLenExp(inputParser.LenExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLvalueExp(inputParser.LvalueExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLvalueExp(inputParser.LvalueExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCallExp(inputParser.CallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCallExp(inputParser.CallExpContext ctx);
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
	 * Enter a parse tree produced by the {@code uminusExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterUminusExp(inputParser.UminusExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uminusExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitUminusExp(inputParser.UminusExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpList(inputParser.ExpListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpList(inputParser.ExpListContext ctx);
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
	 * Enter a parse tree produced by the {@code nonExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNonExp(inputParser.NonExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNonExp(inputParser.NonExpContext ctx);
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
	 * Enter a parse tree produced by the {@code trueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterTrueExp(inputParser.TrueExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitTrueExp(inputParser.TrueExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterStructExp(inputParser.StructExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitStructExp(inputParser.StructExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optionExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterOptionExp(inputParser.OptionExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optionExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitOptionExp(inputParser.OptionExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterStrExp(inputParser.StrExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitStrExp(inputParser.StrExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleVarExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSimpleVarExp(inputParser.SimpleVarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleVarExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSimpleVarExp(inputParser.SimpleVarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFalseExp(inputParser.FalseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFalseExp(inputParser.FalseExpContext ctx);
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
	 * Enter a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntExp(inputParser.IntExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntExp(inputParser.IntExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDecList(inputParser.DecListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decList}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDecList(inputParser.DecListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldFunCallExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFieldFunCallExp(inputParser.FieldFunCallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldFunCallExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFieldFunCallExp(inputParser.FieldFunCallExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#optionVal}.
	 * @param ctx the parse tree
	 */
	void enterOptionVal(inputParser.OptionValContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#optionVal}.
	 * @param ctx the parse tree
	 */
	void exitOptionVal(inputParser.OptionValContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(inputParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(inputParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#decs}.
	 * @param ctx the parse tree
	 */
	void enterDecs(inputParser.DecsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#decs}.
	 * @param ctx the parse tree
	 */
	void exitDecs(inputParser.DecsContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#typefield}.
	 * @param ctx the parse tree
	 */
	void enterTypefield(inputParser.TypefieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#typefield}.
	 * @param ctx the parse tree
	 */
	void exitTypefield(inputParser.TypefieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#typefields}.
	 * @param ctx the parse tree
	 */
	void enterTypefields(inputParser.TypefieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#typefields}.
	 * @param ctx the parse tree
	 */
	void exitTypefields(inputParser.TypefieldsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regularFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 */
	void enterRegularFields(inputParser.RegularFieldsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regularFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 */
	void exitRegularFields(inputParser.RegularFieldsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 */
	void enterEmptyFields(inputParser.EmptyFieldsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyFields}
	 * labeled alternative in {@link inputParser#finalFields}.
	 * @param ctx the parse tree
	 */
	void exitEmptyFields(inputParser.EmptyFieldsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code regularTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void enterRegularTypeDefExp(inputParser.RegularTypeDefExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code regularTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void exitRegularTypeDefExp(inputParser.RegularTypeDefExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void enterAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignTypeDefExp}
	 * labeled alternative in {@link inputParser#defType}.
	 * @param ctx the parse tree
	 */
	void exitAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#typeID}.
	 * @param ctx the parse tree
	 */
	void enterTypeID(inputParser.TypeIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#typeID}.
	 * @param ctx the parse tree
	 */
	void exitTypeID(inputParser.TypeIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(inputParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(inputParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#paramRest}.
	 * @param ctx the parse tree
	 */
	void enterParamRest(inputParser.ParamRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#paramRest}.
	 * @param ctx the parse tree
	 */
	void exitParamRest(inputParser.ParamRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#defVar}.
	 * @param ctx the parse tree
	 */
	void enterDefVar(inputParser.DefVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#defVar}.
	 * @param ctx the parse tree
	 */
	void exitDefVar(inputParser.DefVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void enterSingleParam(inputParser.SingleParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void exitSingleParam(inputParser.SingleParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void enterMulParam(inputParser.MulParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulParam}
	 * labeled alternative in {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void exitMulParam(inputParser.MulParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#funcallExp}.
	 * @param ctx the parse tree
	 */
	void enterFuncallExp(inputParser.FuncallExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#funcallExp}.
	 * @param ctx the parse tree
	 */
	void exitFuncallExp(inputParser.FuncallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleFieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFieldVar(inputParser.SimpleFieldVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleFieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFieldVar(inputParser.SimpleFieldVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptVar(inputParser.SubscriptVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptVar(inputParser.SubscriptVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleSubscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterSimpleSubscriptVar(inputParser.SimpleSubscriptVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleSubscriptVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitSimpleSubscriptVar(inputParser.SimpleSubscriptVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterFieldVar(inputParser.FieldVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldVar}
	 * labeled alternative in {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitFieldVar(inputParser.FieldVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#initArray}.
	 * @param ctx the parse tree
	 */
	void enterInitArray(inputParser.InitArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#initArray}.
	 * @param ctx the parse tree
	 */
	void exitInitArray(inputParser.InitArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAssign(inputParser.SimpleAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAssign(inputParser.SimpleAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lvalueAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterLvalueAssign(inputParser.LvalueAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lvalueAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitLvalueAssign(inputParser.LvalueAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code initArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterInitArrayAssign(inputParser.InitArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code initArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitInitArrayAssign(inputParser.InitArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleInitArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterSimpleInitArrayAssign(inputParser.SimpleInitArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleInitArrayAssign}
	 * labeled alternative in {@link inputParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitSimpleInitArrayAssign(inputParser.SimpleInitArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(inputParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(inputParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(inputParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(inputParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(inputParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(inputParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(inputParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(inputParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpStmt(inputParser.ExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpStmt(inputParser.ExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#decStmt}.
	 * @param ctx the parse tree
	 */
	void enterDecStmt(inputParser.DecStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#decStmt}.
	 * @param ctx the parse tree
	 */
	void exitDecStmt(inputParser.DecStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(inputParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(inputParser.StmtsContext ctx);
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