package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.BooleanValue;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class NonExp extends Exp{
    Exp exp;

    public NonExp(Exp e){
        exp = e;
    }
    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        Value val = exp.eval(varEntry, randNumGen, info, state);
        if(val instanceof BooleanValue){
            Boolean b = !((BooleanValue) val).getValue();
            return new BooleanValue(b);
        }
        throw new IllegalArgumentException("Require boolean type for nonExp!");
    }
}
