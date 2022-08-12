package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.BooleanValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

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
        return new BooleanValue(false);
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        return new VoidValue();
    }
}
