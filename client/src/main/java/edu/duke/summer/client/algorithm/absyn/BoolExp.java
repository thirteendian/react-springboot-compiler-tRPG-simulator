package edu.duke.summer.client.algorithm.absyn;
import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class BoolExp extends Exp{
    public Boolean value;

    public BoolExp(int p, Boolean v) {pos=p; value=v;}

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
