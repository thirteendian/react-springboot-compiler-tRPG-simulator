package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.StringValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class PrimTy extends Ty{
    Symbol key;
    Symbol name;

    public PrimTy(int p, Symbol n, Symbol k){
        pos = p;
        name = n;
        key = k;
    }

    public String getName() {
        return name.toString();
    }

    public String getKey() {
        return key.toString();
    }

    public Ty getElem() {
        return null;
    }

    @Override
    public Value getInitValue() {
       if(name.toString().equals("int")){
           return new IntValue(0);
       }else{
           return new StringValue("");
       }
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        return new VoidValue();
    }
}
