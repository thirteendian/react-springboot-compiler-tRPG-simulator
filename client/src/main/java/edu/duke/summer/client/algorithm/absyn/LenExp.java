package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.ArrayValue;
import edu.duke.summer.client.algorithm.value.IntValue;
import edu.duke.summer.client.algorithm.value.StringValue;
import edu.duke.summer.client.algorithm.value.Value;

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
