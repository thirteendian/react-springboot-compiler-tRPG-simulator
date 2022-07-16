package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.Value;

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

    public Symbol getName() {
        return name;
    }

    public Symbol getKey() {
        return key;
    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
