package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.*;

import java.util.Random;

public abstract class AstVisitor<T> {
    public abstract T Visit(AddNode node);
    public abstract T Visit(SubNode node);
    public abstract T Visit(MulNode node);
    public abstract T Visit(DivNode node);
    public abstract T Visit(ValueNode node);
    public abstract T Visit(RollNode node, Random randNumGen);
    public abstract T Visit(SingleRollNode node, Random randNumGen);
    public abstract T Visit(ConditionalNode node);
    public abstract T Visit(VarNode node);

    public T Visit(ExpNode node)
    {
            if(node instanceof AddNode) {
                return Visit((AddNode) node);
            } else if(node instanceof SubNode) {
                return Visit((SubNode) node);
            } else if(node instanceof MulNode) {
                return Visit((MulNode) node);
            } else if(node instanceof DivNode) {
                return Visit((DivNode) node);
            } else if(node instanceof RollNode) {
                return Visit((RollNode) node);
            } else if(node instanceof SingleRollNode) {
                return Visit((SingleRollNode) node);
            } else if(node instanceof ValueNode) {
                return Visit((ValueNode) node);
            } else {
                throw new IllegalArgumentException("the operation is not supported");
            }
    }

}
