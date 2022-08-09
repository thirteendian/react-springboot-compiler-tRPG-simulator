package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.BooleanValue;
import edu.duke.summer.server.algorithm.value.Value;

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
