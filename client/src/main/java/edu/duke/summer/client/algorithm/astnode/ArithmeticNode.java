package edu.duke.summer.client.algorithm.astnode;

public abstract class ArithmeticNode extends ExpNode {
    ExpNode leftExp;
    ExpNode rightExp;

    public void setRightExp(ExpNode rightExp) {
        this.rightExp = rightExp;
    }

    public void setLeftExp(ExpNode leftExp) {
        this.leftExp = leftExp;
    }
}
