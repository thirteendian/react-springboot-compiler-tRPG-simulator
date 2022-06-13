package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//build AST tree
public class BuildAstVisitor extends inputBaseVisitor<ExpNode>{
    String realTypeId;
    HashMap<String, TypeDefNode> typeList = new HashMap<>();

    public HashMap<String, TypeDefNode> getTypeList() {
        return typeList;
    }

    @Override
    public ExpNode visitProg(inputParser.ProgContext ctx) {
        return visit(ctx.exp());
    }


    @Override
    public ExpNode visitValueExp(inputParser.ValueExpContext ctx) {
        return new ValueNode(Integer.valueOf(ctx.INT().getText()));
    }

    @Override
    public ExpNode visitParensExp(inputParser.ParensExpContext ctx){
        return visit(ctx.exp());
    }

    @Override
    public ExpNode visitArithmeticExp(inputParser.ArithmeticExpContext ctx){
        ArithmeticNode node;
        switch (ctx.op.getType()){
            case inputLexer.ADD:
                node = new AddNode();
                break;
            case inputLexer.SUB:
                node = new SubNode();
                break;
            case inputLexer.MUL:
                node = new MulNode();
                break;
            default :
                node = new DivNode();

        }
        node.setLeftExp(visit(ctx.leftExp));
        node.setRightExp(visit(ctx.rightExp));

        return node;
    }

    @Override
    public ExpNode visitConditionalExp(inputParser.ConditionalExpContext ctx) {
        ConditionalNode node = new ConditionalNode();
        node.setCondExp(visit(ctx.cond));
        node.setOpt1Exp(visit(ctx.opt1));
        node.setOpt2Exp(visit(ctx.opt2));
        return node;
    }

    @Override
    public ExpNode visitVarExp(inputParser.VarExpContext ctx) {
        return new VarNode(String.valueOf(ctx.ID().getText()));
    }

    @Override
    public ExpNode visitSingleRollExp(inputParser.SingleRollExpContext ctx) {
        return new SingleRollNode(String.valueOf(ctx.SINGLEROLL().getText()));
    }

    @Override
    public ExpNode visitRollExp(inputParser.RollExpContext ctx) {
        return new RollNode(String.valueOf(ctx.ROLL().getText()));
    }

    @Override
    public ExpNode visitTypeDefExp(inputParser.TypeDefExpContext ctx){
        return visitChildren(ctx);
    }

    public void getId(inputParser.TypeIDContext typeCtx){
        if(typeCtx.ID() != null){
            realTypeId = realTypeId + typeCtx.ID().getText();
        }else {
            inputParser.ArrayContext arrayCtx = typeCtx.array();
            inputParser.OptionContext optionCtx = typeCtx.option();
            if (arrayCtx != null) {
                realTypeId = realTypeId + "array of " ;
                getId(arrayCtx.typeID());
            }else{
                realTypeId = realTypeId + "option of ";
                getId(optionCtx.typeID());
            }
        }
    }
    @Override
    public ExpNode visitRegularTypeDefExp(inputParser.RegularTypeDefExpContext ctx){
        TypeDefNode node = new TypeDefNode();
        String newTypeId = String.valueOf(ctx.idExp.getText());
        node.setTypeId(newTypeId);
        HashMap<String, String> fields = new HashMap<String, String>();
        List<TerminalNode> fieldIds = ctx.fields().ID();
        List<String> fieldTypes = new ArrayList<>();
        List<inputParser.TypeIDContext> fieldTypeIDContext = ctx.fields().typeID();
        for(inputParser.TypeIDContext typeCtx : fieldTypeIDContext){
            realTypeId = "";
            getId(typeCtx);
            fieldTypes.add(realTypeId);
        }
        for(int i = 0; i < fieldIds.size(); i++){
            fields.put(String.valueOf(fieldIds.get(i).getText()), fieldTypes.get(i));
        }
        node.setTypeFields(fields);
        for(Object obj : fields.keySet()){
            Object value = fields.get(obj);
        }
        typeList.put(newTypeId, node);
        return node;
    }

    @Override
    public ExpNode visitAssignTypeDefExp(inputParser.AssignTypeDefExpContext ctx){
        String newTypeId = String.valueOf(ctx.idExp.getText());
        String referTypeId = String.valueOf(ctx.refer.getText());
        AssignTypeNode node = new AssignTypeNode(newTypeId, referTypeId);
        return node;
    }

}
