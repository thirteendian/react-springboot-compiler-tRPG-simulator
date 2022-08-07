package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.absyn.*;
import edu.duke.summer.client.algorithm.errormsg.ErrorMsg;
import edu.duke.summer.client.algorithm.Symbol.Symbol;

import java.util.ArrayList;
import java.util.List;

//build AST tree
public class BuildASTVisitor extends inputBaseVisitor<Absyn>{
    ErrorMsg errorMsg = new ErrorMsg("BuildBasicVisitor");

    @Override
    public Absyn visitProg(inputParser.ProgContext ctx) {return visit(ctx.exp());}

    @Override
    public Absyn visitOptionExp(inputParser.OptionExpContext ctx){
       return visit(ctx.optionVal());
    }
    @Override
    public Absyn visitOptionVal(inputParser.OptionValContext ctx){
        if(ctx.SOME() != null) return new OptionExp(true, (Exp)visit(ctx.exp()));
        else return new OptionExp(false);
    }


    @Override
    public Absyn visitStrExp(inputParser.StrExpContext ctx){
        return new StringExp(ctx.start.getLine(), String.valueOf(ctx.STRING().getText()));
    }


    @Override
    public Absyn visitLenExp(inputParser.LenExpContext ctx){
        return new LenExp(ctx.start.getLine(), (Exp)visit(ctx.exp()));
    }

    @Override
    public Absyn visitTrueExp(inputParser.TrueExpContext ctx){
        return new BoolExp(ctx.start.getLine(), true);
    }

    @Override
    public Absyn visitFalseExp(inputParser.FalseExpContext ctx){
        return new BoolExp(ctx.start.getLine(), false);
    }

    @Override
    public Absyn visitNonExp(inputParser.NonExpContext ctx){
        return new NonExp((Exp)visit(ctx.exp()));
    }

    @Override
    public Absyn visitTypefield(inputParser.TypefieldContext ctx) {
        String ID = String.valueOf(ctx.ID().getText());
        Ty type = (Ty) visitTypeID(ctx.typeID());
        String typeId;
        if (type instanceof ArrayTy){
            typeId = ((ArrayTy) type).getTyName().toString();
        }else if (type instanceof OptionTy){
            typeId = ((OptionTy) type).getTyName().toString();
        }else {
            typeId = type.getName();
        }
        return new FieldList(ctx.start.getLine(),
                Symbol.symbol(ID),
                Symbol.symbol(typeId),
                type, null);
    }

    @Override
    public Absyn visitTypefields(inputParser.TypefieldsContext ctx){
        if(ctx.typefields() == null) return visitTypefield(ctx.typefield());
        String ID = String.valueOf(ctx.typefield().ID().getText());
        Ty type = (Ty) visitTypeID(ctx.typefield().typeID());
        String TypeId;
        if (type instanceof ArrayTy){
            TypeId = ((ArrayTy) type).getTyName().toString();
        }else if (type instanceof OptionTy){
            TypeId = ((OptionTy) type).getTyName().toString();
        }else {
            TypeId = type.getName();
        }
        return new FieldList(ctx.start.getLine(),
                Symbol.symbol(ID),
                Symbol.symbol(TypeId),
                type,
                (FieldList) visitTypefields(ctx.typefields()));
    }

    @Override
    public Absyn visitRegularFields(inputParser.RegularFieldsContext ctx){
        return visitTypefields(ctx.typefields());
    }

    @Override
    public Absyn visitEmptyFields(inputParser.EmptyFieldsContext ctx) {
        return new FieldList(ctx.start.getLine(),
                Symbol.symbol(""),
                Symbol.symbol(""),
                null);
    }

    @Override
    public Absyn visitTypeID(inputParser.TypeIDContext ctx){
        if(ctx.ID() != null){
            String id = String.valueOf(ctx.ID().getText());
            Ty ty;
            switch (id) {
                case "int":
                    ty = new PrimTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("int"), Symbol.symbol("prim"));
                    break;
                case "string":
                    ty = new PrimTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("string"), Symbol.symbol("prim"));
                    break;
                case "boolean":
                    ty = new BooleanTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("boolean"), Symbol.symbol("boolean"));
                    break;
                default:
                    ty = new NameTy(ctx.ID().getSymbol().getLine(), Symbol.symbol(id), Symbol.symbol("user"));
                    break;
            }
            return ty;
        }else if(ctx.LBRACK() != null){
            ArrayTy ty;
            if(ctx.INT() != null){
                ty = new ArrayTy(ctx.typeID().start.getLine(), visitTypeID(ctx.typeID()), Integer.parseInt(ctx.INT().getText()));
            }else{
                ty = new ArrayTy(ctx.typeID().start.getLine(), visitTypeID(ctx.typeID()), -1);
            }
            return ty;
        }else if(ctx.OPTION() != null){
            return new OptionTy(ctx.OPTION().getSymbol().getLine(), visitTypeID(ctx.typeID()));
        }else{
            errorMsg.error(ctx.typeID().start.getLine(), "Invalid typeId!");
            return null;
        }
    }

    @Override
    public Absyn visitRegularTypeDefExp(inputParser.RegularTypeDefExpContext ctx){
       FieldList fields = (FieldList) visitChildren(ctx.finalFields());
       FieldsTy struct = new FieldsTy(ctx.finalFields().start.getLine(), fields);

       String Id = String.valueOf(ctx.ID().getText());
       return new TypeDec(ctx.start.getLine(), Symbol.symbol(Id), struct);
    }

    @Override
    public Absyn visitAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx){
        String newTypeId = String.valueOf(ctx.ID().getText());
        Ty node = (Ty) visitTypeID(ctx.refer);
        return new TypeDec(ctx.start.getLine(), Symbol.symbol(newTypeId), node);
    }

    @Override
    public Absyn visitDefVar(inputParser.DefVarContext ctx){
        String Id = String.valueOf(ctx.ID().getText());
        Ty typeId = null;
        Exp exp;
        if(ctx.typeID() != null) {
            typeId = (Ty) visit(ctx.typeID());
        }
        if(ctx.exp() != null) {
            exp = (Exp) visit(ctx.exp());
        }
        else if(ctx.initArray() != null){
            Exp initExp = (Exp) visit(ctx.initArray());
            exp = new ArrayExp(ctx.start.getLine(), typeId, initExp);
        }else{
            return new UnInitVarDec(ctx.start.getLine(), Symbol.symbol(Id), typeId);
        }
        return new VarDec(ctx.start.getLine(), Symbol.symbol(Id), typeId, exp);
    }

    @Override
    public Absyn visitSimpleAssign(inputParser.SimpleAssignContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        return new AssignExp(ctx.start.getLine(), var, (Exp)visit(ctx.exp()));
    }

    @Override
    public Absyn visitLvalueAssign(inputParser.LvalueAssignContext ctx){
        Var var = (Var)visit(ctx.lvalue());
        return new AssignExp(ctx.start.getLine(), var, (Exp)visit(ctx.exp()));
    }

    @Override
    public Absyn visitInitArray(inputParser.InitArrayContext ctx){
        List<inputParser.ExpContext> Ctxs= ctx.exp();
        InitArrayExp exp = new InitArrayExp();
        for(inputParser.ExpContext subCtx : Ctxs){
            exp.add((Exp)visit(subCtx));
        }
        return exp;
    }

    @Override
    public Absyn visitInitArrayAssign(inputParser.InitArrayAssignContext ctx){
        return new AssignExp(ctx.start.getLine(),
                (Var)visit(ctx.lvalue()), (Exp)visit(ctx.initArray()));
    }

    @Override
    public Absyn visitSimpleInitArrayAssign(inputParser.SimpleInitArrayAssignContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        return new AssignExp(ctx.start.getLine(),
                var, (Exp)visit(ctx.initArray()));
    }

    @Override
    public Absyn visitSimpleFieldVar(inputParser.SimpleFieldVarContext ctx){
        String id1 = String.valueOf(ctx.ID(0).getText());
        String id2 = String.valueOf(ctx.ID(1).getText());
        SimpleVar var = new SimpleVar(ctx.ID(0).getSymbol().getLine(), Symbol.symbol(id1));
        return new FieldVar(ctx.start.getLine(), var, Symbol.symbol(id2));
    }

    @Override
    public Absyn visitSimpleSubscriptVar(inputParser.SimpleSubscriptVarContext ctx) {
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        return new SubscriptVar(ctx.ID().getSymbol().getLine(), var, (Exp)visit(ctx.exp()));
    }

    @Override
    public Absyn visitFieldVar(inputParser.FieldVarContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        return new FieldVar(ctx.start.getLine(), (Var)visit(ctx.lvalue()), Symbol.symbol(id));
    }

    @Override
    public Absyn visitSubscriptVar(inputParser.SubscriptVarContext ctx){
        return new SubscriptVar(ctx.start.getLine(), (Var)visit(ctx.lvalue()), (Exp)visitChildren(ctx.exp()));
    }

    @Override
    public Absyn visitReturnStmt(inputParser.ReturnStmtContext ctx){
        return new ReturnStmt(ctx.start.getLine(), (Exp) visit(ctx.exp()));
    }

    @Override
    public Absyn visitForStmt(inputParser.ForStmtContext ctx){
        Var dec = new SimpleVar(ctx.start.getLine(), Symbol.symbol(String.valueOf(ctx.ID().getText())));
        //todo: use arrayValue to init
        return new ForStmt(ctx.FOR().getSymbol().getLine(), dec, (Exp)visit(ctx.exp()),
                (Stmt) visit(ctx.stmts()));
    }

    @Override
    public Absyn visitIfStmt(inputParser.IfStmtContext ctx){
        Exp test = (Exp)visit(ctx.condExp);
        Stmt thenclause = (Stmt) visit(ctx.op1);
        if(ctx.op2 == null){
            return new IfStmt(ctx.start.getLine(),test,thenclause);

        }else{
            Stmt elseclause = (Stmt) visit(ctx.op2);
            return new IfStmt(ctx.start.getLine(),test,thenclause, elseclause);
        }
    }

    @Override
    public Absyn visitWhileStmt(inputParser.WhileStmtContext ctx){
        Exp test = (Exp)visit(ctx.exp());
        Stmt body = (Stmt) visit(ctx.stmts());
        return new WhileStmt(test, body);
    }

    @Override
    public Absyn visitExpStmt(inputParser.ExpStmtContext ctx){
        return new ExpStmt(ctx.start.getLine(), (Exp)visit(ctx.exp()));
    }

    public Block getBlock(int p,  List<inputParser.DecStmtContext> decStmt, List<inputParser.StmtsContext> stmtsContexts,  inputParser.ReturnStmtContext reCtx){
        StmtList stmts = new StmtList();
        for (inputParser.DecStmtContext subCtx : decStmt) {
            Stmt s = (Stmt) visit(subCtx);
            stmts.addStmt(s);
        }
        for (inputParser.StmtsContext subCtx : stmtsContexts) {
            Stmt s = (Stmt) visit(subCtx);
            stmts.addStmt(s);
        }
        if(reCtx != null) {
            Stmt s = (Stmt) visit(reCtx);
            stmts.addStmt(s);
        }
        return new Block(p, stmts);
    }

    @Override
    public Absyn visitStmts(inputParser.StmtsContext ctx){
        List<inputParser.DecStmtContext> l = new ArrayList<>();
        if(ctx.expStmt() != null) {
            return visit(ctx.expStmt());}
        if(ctx.forStmt() != null) return visit(ctx.forStmt());
        if(ctx.ifStmt() != null) return visit(ctx.ifStmt());
        if(ctx.whileStmt() != null) return visit(ctx.whileStmt());
        if(ctx.BREAK() != null) {
            Stmt stmt = new BreakStmt(ctx.BREAK().getSymbol().getLine());
            return stmt;
        }
        if(ctx.decStmt() != null) return visit(ctx.decStmt());
        if(ctx.returnStmt() != null) return visit(ctx.returnStmt());
        if(ctx.stmts() != null)return getBlock(ctx.start.getLine(), l, ctx.stmts(), null);
        errorMsg.error(ctx.start.getLine(), "invalid statement!");
        throw new IllegalArgumentException("invalid statement!");
    }

    @Override
    public Absyn visitParamRest(inputParser.ParamRestContext ctx){
        String typeId = String.valueOf(ctx.typeID().getText());
        String Id = String.valueOf(ctx.ID().getText());
        Ty type = (Ty) visit(ctx.typeID());
        return new FieldList(ctx.start.getLine(), Symbol.symbol(Id), Symbol.symbol(typeId), type, null);
    }

    @Override
    public Absyn visitParamList(inputParser.ParamListContext ctx){
        if(ctx.ID() == null) return null;
        String typeId = String.valueOf(ctx.typeID().getText());
        String Id = String.valueOf(ctx.ID().getText());
        Ty type = (Ty) visit(ctx.typeID());
        FieldList list = new FieldList(ctx.start.getLine(),Symbol.symbol(Id), Symbol.symbol(typeId), type, null);
        for(inputParser.ParamRestContext subCtx : ctx.paramRest()){
            list.append((FieldList) visitParamRest(subCtx));
        }
        return list;
    }

    @Override
    public Absyn visitDefFun(inputParser.DefFunContext ctx){
        Symbol funId = Symbol.symbol(String.valueOf(ctx.ID().getText()));
        FieldList fields = (FieldList) visitParamList(ctx.paramList());
        Ty type = (Ty) visit(ctx.typeID());
        Stmt body;
        if(ctx.decStmt() == null && ctx.stmts() == null) {
            body = getBlock(ctx.start.getLine(), null, null, ctx.returnStmt());
        }else if(ctx.decStmt() == null){
            body = getBlock(ctx.start.getLine(), null, ctx.stmts(), ctx.returnStmt());
        }else if(ctx.stmts() == null){
            body = getBlock(ctx.start.getLine(),  ctx.decStmt(), null, ctx.returnStmt());
        }else{
            body = getBlock(ctx.start.getLine(), ctx.decStmt(), ctx.stmts(), ctx.returnStmt());
        }
        return new FunctionDec(ctx.start.getLine(), funId, fields, type, body);
    }

    @Override
    public Absyn visitParensExp(inputParser.ParensExpContext ctx){
        return visit(ctx.exp());
    }

    @Override
    public Absyn visitSimpleVarExp(inputParser.SimpleVarExpContext ctx){
        Var sVar = new SimpleVar(ctx.start.getLine(), Symbol.symbol(String.valueOf(ctx.ID().getText())));
        return new VarExp(ctx.start.getLine(), sVar);
    }

    @Override
    public Absyn visitIntExp(inputParser.IntExpContext ctx){
        return new IntExp(ctx.start.getLine(), Integer.parseInt(ctx.INT().getText()));
    }


    @Override
    public Absyn visitDecList(inputParser.DecListContext ctx){
        return visit(ctx.decs());
    }

    @Override
    public Absyn visitDecs(inputParser.DecsContext ctx){
        Dec dec = (Dec) visit(ctx.dec());
        DecList list = new DecList(dec, null);
        ScopeExp scope = new ScopeExp(ctx.start.getLine(), list, null);
        if(ctx.decs() != null){
            scope.append((ScopeExp)visit(ctx.decs()));
        }
        return scope;
    }

    @Override
    public Absyn visitDecStmt(inputParser.DecStmtContext ctx){
        return new DecStmt(ctx.start.getLine(), (Dec)visit(ctx.defVar()));
    }

    @Override
    public Absyn visitDec(inputParser.DecContext ctx){
        return visitChildren(ctx);
    }


    @Override
    public Absyn visitUminusExp(inputParser.UminusExpContext ctx) {
        OpExp node;
        node = new OpExp(ctx.start.getLine(), new IntExp(ctx.start.getLine(), 0), 1, (Exp) visit(ctx.exp()));
        return node;
    }

    @Override
    public Absyn visitNilExp(inputParser.NilExpContext ctx){
        return new NilExp(ctx.start.getLine());
    }

    @Override
    public Absyn visitLvalueExp(inputParser.LvalueExpContext ctx){
        return new VarExp(ctx.start.getLine(), (Var) visit(ctx.lvalue()));
    }

    @Override
    public Absyn visitArithmeticExp(inputParser.ArithmeticExpContext ctx){
        OpExp node;
        switch (ctx.op.getType()){
            case inputLexer.PLUS:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 0, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.MINUS:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 1, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.MUL:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 2, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.DIV:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 3, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.EQ:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 4, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.NE:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 5, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.LT:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 6, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.LE:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 7, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.GT:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 8, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.GE:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 9, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.AND:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 10, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.OR:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 11, (Exp)visit(ctx.rightExp));
                break;
            case inputLexer.MOD:
                node = new OpExp(ctx.op.getLine(), (Exp)visit(ctx.leftExp), 12, (Exp)visit(ctx.rightExp));
                break;
            default :
                throw new IllegalArgumentException("unsupported operation!");
        }

        return node;
    }

    @Override
    public Absyn visitConditionalExp(inputParser.ConditionalExpContext ctx) {
        ConditionalExp node = new ConditionalExp(ctx.start.getLine());
        if(visit(ctx.cond) instanceof Var){
            Var v = (Var) visit(ctx.cond);
            VarExp exp = new VarExp(ctx.cond.start.getLine(), v);
            node.setCondExp(exp);
        }else{
            node.setCondExp((Exp)visit(ctx.cond));
        }
        node.setOpt1Exp((Exp)visit(ctx.opt1));
        node.setOpt2Exp((Exp)visit(ctx.opt2));
        return node;
    }


    @Override
    public Absyn visitSingleRollExp(inputParser.SingleRollExpContext ctx) {
        return new SingleRollExp(ctx.start.getLine(), String.valueOf(ctx.SINGLEROLL().getText()));
    }

    @Override
    public Absyn visitRollExp(inputParser.RollExpContext ctx) {
        return new RollExp(ctx.start.getLine(), String.valueOf(ctx.ROLL().getText()));
    }

    @Override
    public Absyn visitExpList(inputParser.ExpListContext ctx){
        return visit(ctx.exps());
    }

    @Override
    public Absyn visitExps(inputParser.ExpsContext ctx){
        Exp head = (Exp)visit(ctx.exp());
        ExpList expList = new ExpList(head, null);
        SeqExp seq = new SeqExp(ctx.start.getLine(), expList);
        if(ctx.exps() != null){
            seq.append((SeqExp) visitExps(ctx.exps()));
        }
        return seq;
    }

    @Override
    public Absyn visitSingleParam(inputParser.SingleParamContext ctx) {
        ExpList list = new ExpList((Exp)visit(ctx.exp()), null);
        return new SeqExp(ctx.exp().start.getLine(), list);
    }

    @Override
    public Absyn visitMulParam(inputParser.MulParamContext ctx){
        ExpList list = new ExpList((Exp)visit(ctx.exp()), null);
        SeqExp seq = new SeqExp(ctx.exp().start.getLine(), list);
        seq.append((SeqExp)visit(ctx.params()));
        return seq;
    }

    @Override
    public Absyn visitFuncallExp(inputParser.FuncallExpContext ctx){
        String Id = String.valueOf(ctx.ID().getText());
        if(ctx.params() != null){
            SeqExp seq = (SeqExp) visit(ctx.params());
            return new CallExp(ctx.start.getLine(), Symbol.symbol(Id), seq.getList());
        }else{
            return new CallExp(ctx.start.getLine(), Symbol.symbol(Id),null);
        }
    }


}
