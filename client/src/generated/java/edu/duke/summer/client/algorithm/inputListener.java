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
	 * Enter a parse tree produced by the {@code arrayExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterArrayExp(inputParser.ArrayExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitArrayExp(inputParser.ArrayExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunExp(inputParser.FunExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunExp(inputParser.FunExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCompareExp(inputParser.CompareExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCompareExp(inputParser.CompareExpContext ctx);
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
	 * Enter a parse tree produced by the {@code varDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVarDefExp(inputParser.VarDefExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDefExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVarDefExp(inputParser.VarDefExpContext ctx);
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
	 * Enter a parse tree produced by the {@code logicExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLogicExp(inputParser.LogicExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExp}
	 * labeled alternative in {@link inputParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLogicExp(inputParser.LogicExpContext ctx);
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
	 * Enter a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 */
	void enterDefFun(inputParser.DefFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#defFun}.
	 * @param ctx the parse tree
	 */
	void exitDefFun(inputParser.DefFunContext ctx);
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
	 * Enter a parse tree produced by {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(inputParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(inputParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#initArrayExp}.
	 * @param ctx the parse tree
	 */
	void enterInitArrayExp(inputParser.InitArrayExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#initArrayExp}.
	 * @param ctx the parse tree
	 */
	void exitInitArrayExp(inputParser.InitArrayExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#initStructExp}.
	 * @param ctx the parse tree
	 */
	void enterInitStructExp(inputParser.InitStructExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#initStructExp}.
	 * @param ctx the parse tree
	 */
	void exitInitStructExp(inputParser.InitStructExpContext ctx);
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
	 * Enter a parse tree produced by {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(inputParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(inputParser.LvalueContext ctx);
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
	 * Enter a parse tree produced by {@link inputParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(inputParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(inputParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#stmtField}.
	 * @param ctx the parse tree
	 */
	void enterStmtField(inputParser.StmtFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#stmtField}.
	 * @param ctx the parse tree
	 */
	void exitStmtField(inputParser.StmtFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(inputParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(inputParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link inputParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(inputParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link inputParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(inputParser.OptionContext ctx);
}