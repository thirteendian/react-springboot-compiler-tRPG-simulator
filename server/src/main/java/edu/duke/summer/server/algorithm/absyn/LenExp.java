package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.ArrayValue;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.StringValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class LenExp extends Exp{
    Exp exp;
    public LenExp(int p, Exp e){pos = p; exp = e;}

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        Value val = exp.eval(varEntry, randNumGen, info, state);
        Integer size;
        if(val instanceof ArrayValue){
            size = ((ArrayValue) val).getLength();
        }else if(val instanceof StringValue){
            size = ((StringValue) val).getLength();
        }else{
            throw new IllegalArgumentException("Require String or Array type for length function.");
        }
        return new IntValue(size);
    }
}
