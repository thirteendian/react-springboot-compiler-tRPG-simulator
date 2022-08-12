package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class ConditionalExp extends Exp {
    Exp condExp;
    Exp opt1Exp;
    Exp opt2Exp;

    public ConditionalExp(int p){pos = p;}


    public void setCondExp(Exp condExp) {
        this.condExp = condExp;
    }

    public void setOpt1Exp(Exp opt1Exp) {
        this.opt1Exp = opt1Exp;
    }

    public void setOpt2Exp(Exp opt2Exp) {
        this.opt2Exp = opt2Exp;
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        Value cond = condExp.eval(varEntry, randNumGen, info, state);
        if(cond instanceof IntValue){
            if(((IntValue) cond).getValue() != 0){
                return opt1Exp.eval(varEntry, randNumGen, info, state);
            }else{
                return opt2Exp.eval(varEntry, randNumGen, info, state);
            }
        }else if (cond instanceof BooleanValue) {
            if(((BooleanValue) cond).getValue()){
                return opt1Exp.eval(varEntry, randNumGen, info, state);
            }else{
                return opt2Exp.eval(varEntry, randNumGen, info, state);
            }
        }
        throw new IllegalArgumentException("Require boolean type for conditional Exp!");
    }
}
