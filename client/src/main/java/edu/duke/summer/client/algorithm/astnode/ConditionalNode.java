package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class ConditionalNode extends ExpNode {
    ExpNode condExp;
    ExpNode opt1Exp;
    ExpNode opt2Exp;

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        if (condExp.eval(vars, randNumGen) != 0){
            System.out.println("ConsitionalExp cond: true");
            return opt1Exp.eval(vars, randNumGen);
        }
        System.out.println("ConsitionalExp cond: false");
        return opt2Exp.eval(vars, randNumGen);
    }

    public void setCondExp(ExpNode condExp) {
        this.condExp = condExp;
    }

    public void setOpt1Exp(ExpNode opt1Exp) {
        this.opt1Exp = opt1Exp;
    }

    public void setOpt2Exp(ExpNode opt2Exp) {
        this.opt2Exp = opt2Exp;
    }
}
