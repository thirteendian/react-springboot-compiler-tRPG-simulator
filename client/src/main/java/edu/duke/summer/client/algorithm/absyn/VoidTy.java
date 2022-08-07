package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.Value;
import edu.duke.summer.client.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class VoidTy extends Ty{
    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        return new VoidValue();
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Ty getElem() {
        return null;
    }

    @Override
    public Value getInitValue() {
        return new VoidValue();
    }
}
