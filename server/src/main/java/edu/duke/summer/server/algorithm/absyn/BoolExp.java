package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.BooleanValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class BoolExp extends Exp{
    public Boolean value;

    public BoolExp(int p, Boolean v) {pos=p; value=v;}

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        return new BooleanValue(value);
    }
}
