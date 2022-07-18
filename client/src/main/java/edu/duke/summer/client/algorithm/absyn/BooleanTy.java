package edu.duke.summer.client.algorithm.absyn;
import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class BooleanTy extends Ty{
    Symbol key;
    Symbol name;

    public BooleanTy(int p, Symbol n, Symbol k){
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
    public Ty getElem() {
        return null;
    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
