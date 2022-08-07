package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.*;
import edu.duke.summer.server.algorithm.value.BoolValue;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;

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
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        Value cond = condExp.eval(vars, randNumGen, info, state);
        if(cond instanceof IntValue){
            if(((IntValue) cond).getValue() != 0){
                return opt1Exp.eval(vars, randNumGen, info, state);
            }else{
                return opt2Exp.eval(vars, randNumGen, info, state);
            }
        }else if (cond instanceof BoolValue) {
            if(((BoolValue) cond).getValue()){
                return opt1Exp.eval(vars, randNumGen, info, state);
            }else{
                return opt2Exp.eval(vars, randNumGen, info, state);
            }
        }
        throw new IllegalArgumentException("Require boolean type for conditional Exp!");
    }
}
