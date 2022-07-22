package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.absyn.*;
import edu.duke.summer.client.algorithm.errormsg.ErrorMsg;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import java.util.List;

//build AST tree
public class BuildASTVisitor extends inputBaseVisitor<Absyn>{
    ErrorMsg errorMsg = new ErrorMsg("BuildBasicVisitor");

    @Override
    public Absyn visitProg(inputParser.ProgContext ctx) {;return visit(ctx.exp());}

    @Override
    public Absyn visitQuoStrExp(inputParser.QuoStrExpContext ctx){
        String str = String.valueOf(ctx.getText());
        StringExp exp = new StringExp(ctx.start.getLine(), str);
        return exp;
    }

    @Override
    public Absyn visitLenExp(inputParser.LenExpContext ctx){
        LenExp exp = new LenExp(ctx.start.getLine(), (Exp)visit(ctx.exp()));
        return exp;
    }

    @Override
    public Absyn visitTrueExp(inputParser.TrueExpContext ctx){
        BoolExp exp = new BoolExp(ctx.start.getLine(), true);
        return exp;
    }

    @Override
    public Absyn visitFalseExp(inputParser.FalseExpContext ctx){
        BoolExp exp = new BoolExp(ctx.start.getLine(), false);
        return exp;
    }

    @Override
    public Absyn visitTypefield(inputParser.TypefieldContext ctx) {
        String ID = String.valueOf(ctx.ID().getText());
        Ty type = (Ty) visitTypeID(ctx.typeID());
        String typeId = "";
        if(type instanceof NameTy){
            typeId = ((NameTy) type).getName().toString();
        }else if(type instanceof PrimTy) {
            typeId = ((PrimTy) type).getName().toString();
        }else if (type instanceof ArrayTy){
            typeId = ((ArrayTy) type).getTyName().toString();
        }else if (type instanceof OptionTy){
            typeId = ((OptionTy) type).getTyName().toString();
        }else if (type instanceof BooleanTy){
            typeId = ((BooleanTy) type).getName().toString();
        }
        FieldList field = new FieldList(ctx.start.getLine(),
                Symbol.symbol(ID),
                Symbol.symbol(typeId), type, null);
        return field;
    }

    @Override
    public Absyn visitTypefields(inputParser.TypefieldsContext ctx){
        if(ctx.typefields() == null) return visitTypefield(ctx.typefield());
        String ID = String.valueOf(ctx.typefield().ID().getText());
        Ty type = (Ty) visitTypeID(ctx.typefield().typeID());
        String TypeId = "";
        if(type instanceof NameTy){
            TypeId = ((NameTy) type).getName().toString();
        }else if (type instanceof ArrayTy){
            TypeId = ((ArrayTy) type).getTyName().toString();
        }else if (type instanceof OptionTy){
            TypeId = ((OptionTy) type).getTyName().toString();
        }else if (type instanceof PrimTy){
            TypeId = ((PrimTy) type).getName().toString();
        }else if (type instanceof BooleanTy){
            TypeId = ((BooleanTy) type).getName().toString();
        }
        FieldList fields = new FieldList(ctx.start.getLine(),
                Symbol.symbol(ID),
                Symbol.symbol(TypeId),
                type,
                (FieldList) visitTypefields(ctx.typefields()));
        return fields;
    }

    @Override
    public Absyn visitRegularFields(inputParser.RegularFieldsContext ctx){
        return visitTypefields(ctx.typefields());
    }

    @Override
    public Absyn visitEmptyFields(inputParser.EmptyFieldsContext ctx) {
        FieldList fields = new FieldList(ctx.start.getLine(),
                Symbol.symbol(""),
                Symbol.symbol(""),
                null);
        return fields;
    }

    @Override
    public Absyn visitTypeID(inputParser.TypeIDContext ctx){
        if(ctx.ID() != null){
            String id = String.valueOf(ctx.ID().getText());
            Ty ty;
            if(id.equals("int")){
                ty = new PrimTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("int"), Symbol.symbol("prim"));
            }else if(id.equals("string")){
                ty = new PrimTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("string"), Symbol.symbol("prim"));
            }else if(id.equals("boolean")){
                ty = new BooleanTy(ctx.ID().getSymbol().getLine(), Symbol.symbol("boolean"), Symbol.symbol("boolean"));
            }else{
                ty = new NameTy(ctx.ID().getSymbol().getLine(), Symbol.symbol(id), Symbol.symbol("user"));
            }
            return ty;
        }else if(ctx.LBRACK() != null){
            ArrayTy ty;
            if(ctx.INT() != null){
                ty = new ArrayTy(ctx.typeID().start.getLine(), visitTypeID(ctx.typeID()), Integer.valueOf(ctx.INT().getText()));
            }else{
                ty = new ArrayTy(ctx.typeID().start.getLine(), visitTypeID(ctx.typeID()), -1);
            }
            return ty;
        }else if(ctx.OPTION() != null){
            OptionTy ty = new OptionTy(ctx.OPTION().getSymbol().getLine(), visitTypeID(ctx.typeID()));
            return ty;
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
       TypeDec dec = new TypeDec(ctx.start.getLine(), Symbol.symbol(Id), struct);
       return dec;
    }

    @Override
    public Absyn visitAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx){
        String newTypeId = String.valueOf(ctx.ID().getText());
        Ty node = (Ty) visitTypeID(ctx.refer);
        TypeDec dec = new TypeDec(ctx.start.getLine(), Symbol.symbol(newTypeId), node);
         return dec;
    }

    @Override
    public Absyn visitDefVar(inputParser.DefVarContext ctx){
        String Id = String.valueOf(ctx.ID(0).getText());
        NameTy referId = new NameTy(ctx.ID(1).getSymbol().getLine(), Symbol.symbol(ctx.ID(1).getText()), Symbol.symbol("user"));
        Exp exp = (Exp) visit(ctx.exp());
        VarDec dec = new VarDec(ctx.start.getLine(), Symbol.symbol(Id), referId, exp);
        return dec;
    }

    @Override
    public Absyn visitSimpleAssign(inputParser.SimpleAssignContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        AssignExp exp = new AssignExp(ctx.start.getLine(), var, (Exp)visit(ctx.exp()));
        return exp;
    }

    @Override
    public Absyn visitLvalueAssign(inputParser.LvalueAssignContext ctx){
        Var var = (Var)visit(ctx.lvalue());
        AssignExp exp = new AssignExp(ctx.start.getLine(), var, (Exp)visit(ctx.exp()));
        return exp;
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
        AssignExp exp = new AssignExp(ctx.start.getLine(),
                (Var)visit(ctx.lvalue()), (Exp)visit(ctx.initArray()));
        return exp;
    }

    @Override
    public Absyn visitSimpleInitArrayAssign(inputParser.SimpleInitArrayAssignContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        AssignExp exp = new AssignExp(ctx.start.getLine(),
                var, (Exp)visit(ctx.initArray()));
        return exp;
    }

    @Override
    public Absyn visitSimpleFieldVar(inputParser.SimpleFieldVarContext ctx){
        String id1 = String.valueOf(ctx.ID(0).getText());
        String id2 = String.valueOf(ctx.ID(1).getText());
        SimpleVar var = new SimpleVar(ctx.ID(0).getSymbol().getLine(), Symbol.symbol(id1));
        FieldVar fVar = new FieldVar(ctx.start.getLine(), var, Symbol.symbol(id2));
        return fVar;
    }

    @Override
    public Absyn visitSimpleSubscriptVar(inputParser.SimpleSubscriptVarContext ctx) {
        String id = String.valueOf(ctx.ID().getText());
        SimpleVar var = new SimpleVar(ctx.ID().getSymbol().getLine(), Symbol.symbol(id));
        SubscriptVar sVar = new SubscriptVar(ctx.ID().getSymbol().getLine(), var, (Exp)visit(ctx.exp()));
        return sVar;
    }

    @Override
    public Absyn visitFieldVar(inputParser.FieldVarContext ctx){
        String id = String.valueOf(ctx.ID().getText());
        FieldVar var = new FieldVar(ctx.start.getLine(), (Var)visit(ctx.lvalue()), Symbol.symbol(id));
        return var;
    }

    @Override
    public Absyn visitSubscriptVar(inputParser.SubscriptVarContext ctx){
        SubscriptVar sVar = new SubscriptVar(ctx.start.getLine(), (Var)visit(ctx.lvalue()), (Exp)visitChildren(ctx.exp()));
        return sVar;
    }

    @Override
    public Absyn visitReturnStmt(inputParser.ReturnStmtContext ctx){
        ReturnStmt rs = new ReturnStmt(ctx.start.getLine(), (Exp)visit(ctx.exp()));
        return rs;
    }

    @Override
    public Absyn visitForStmt(inputParser.ForStmtContext ctx){
        VarDec dec = new VarDec(ctx.ID().getSymbol().getLine(),
                Symbol.symbol(String.valueOf(ctx.ID().getText())),
                null,(Exp)visit(ctx.exp()));
        //todo: use arrayValue to init
        ForStmt stmt = new ForStmt(ctx.FOR().getSymbol().getLine(), dec, (Exp)visit(ctx.exp()),
                (Stmt) visit(ctx.stmts()));
        return stmt;
    }

    @Override
    public Absyn visitIfStmt(inputParser.IfStmtContext ctx){
        Exp test = (Exp)visit(ctx.condExp);
        Stmt thenclause = (Stmt) visit(ctx.op1);
        if(ctx.op2.isEmpty()){
            IfStmt stmt = new IfStmt(ctx.start.getLine(),test,thenclause);
            return stmt;

        }else{
            Stmt elseclause = (Stmt) visit(ctx.op2);
            IfStmt stmt = new IfStmt(ctx.start.getLine(),test,thenclause, elseclause);
            return stmt;
        }
    }

    @Override
    public Absyn visitWhileStmt(inputParser.WhileStmtContext ctx){
        Exp test = (Exp)visit(ctx.exp());
        Stmt body = (Stmt) visit(ctx.stmts());
        WhileStmt stmt = new WhileStmt(test, body);
        return stmt;
    }

    @Override
    public Absyn visitExpStmt(inputParser.ExpStmtContext ctx){
        ExpStmt stmt = new ExpStmt(ctx.start.getLine(), (Exp)visit(ctx.exp()));
        return stmt;
    }

    public Block getBlock(int p, List<inputParser.StmtsContext> list){
        StmtList stmts = new StmtList();
        for (inputParser.StmtsContext subCtx : list) {
            Stmt s = (Stmt) visit(subCtx);
            stmts.addStmt(s);
        }
        Block block = new Block(p, stmts);
        return block;
    }

    @Override
    public Absyn visitStmts(inputParser.StmtsContext ctx){
        if(ctx.stmts() != null) return getBlock(ctx.start.getLine(), ctx.stmts());
        if(ctx.expStmt() != null) return visit(ctx.expStmt());
        if(ctx.forStmt() != null) return visit(ctx.forStmt());
        if(ctx.ifStmt() != null) return visit(ctx.ifStmt());
        if(ctx.whileStmt() != null) return visit(ctx.whileStmt());
        if(ctx.BREAK() != null) return new BreakExp(ctx.BREAK().getSymbol().getLine());
        if(ctx.printStmt() != null) return visit(ctx.printStmt());
        errorMsg.error(ctx.start.getLine(), "invalid statement!");
        throw new IllegalArgumentException("invalid statement!");
    }

    @Override
    public Absyn visitParamRest(inputParser.ParamRestContext ctx){
        String typeId = String.valueOf(ctx.typeID().getText());
        String Id = String.valueOf(ctx.ID().getText());
        FieldList list = new FieldList(ctx.start.getLine(), Symbol.symbol(typeId), Symbol.symbol(Id), null);
        return list;
    }

    @Override
    public Absyn visitParamList(inputParser.ParamListContext ctx){
        String typeId = String.valueOf(ctx.typeID().getText());
        String Id = String.valueOf(ctx.ID().getText());
        FieldList list = new FieldList(ctx.start.getLine(), Symbol.symbol(typeId), Symbol.symbol(Id), null);
        for(inputParser.ParamRestContext subCtx : ctx.paramRest()){
            list.append((FieldList) visitParamRest(subCtx));
        }
        return list;
    }

    @Override
    public Absyn visitDefFun(inputParser.DefFunContext ctx){
        Symbol funId = Symbol.symbol(String.valueOf(ctx.ID().getText()));
        FieldList fields = (FieldList) visitParamList(ctx.paramList());
        Symbol raId = Symbol.symbol(String.valueOf(ctx.typeID().getText()));
        NameTy ty = new NameTy(ctx.typeID().start.getLine(), raId, Symbol.symbol("user"));
        Stmt body = getBlock(ctx.stmts(0).start.getLine(), ctx.stmts());
        FunctionDec dec = new FunctionDec(ctx.start.getLine(), funId, fields, ty, body);
        return dec;
    }

    @Override
    public Absyn visitParensExp(inputParser.ParensExpContext ctx){
        return visit(ctx.exp());
    }

    @Override
    public Absyn visitSimpleVarExp(inputParser.SimpleVarExpContext ctx){
        SimpleVar var = new SimpleVar(ctx.start.getLine(), Symbol.symbol(String.valueOf(ctx.ID().getText())));
        return var;
    }

    @Override
    public Absyn visitIntExp(inputParser.IntExpContext ctx){
        IntExp exp = new IntExp(ctx.start.getLine(), Integer.valueOf(ctx.INT().getText()));
        return exp;
    }

    @Override
    public Absyn visitStringExp(inputParser.StringExpContext ctx){
        StringExp exp = new StringExp(ctx.start.getLine(), String.valueOf(ctx.STRING().getText()));
        return exp;
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
        NilExp exp = new NilExp(ctx.start.getLine());
        return exp;
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
        SeqExp seq = new SeqExp(ctx.exp().start.getLine(), list);
        return seq;
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
        SeqExp seq = (SeqExp) visit(ctx.params());
        CallExp exp = new CallExp(ctx.start.getLine(), Symbol.symbol(Id), seq.getList());
        return exp;
    }


}
