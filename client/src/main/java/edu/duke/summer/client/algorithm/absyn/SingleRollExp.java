package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class SingleRollExp extends Exp {
    Integer sides;

    public SingleRollExp(int p, String singleRollStr){
        pos = p;
        String substr = singleRollStr.substring(1);
        sides = Integer.parseInt(substr);
    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        //set upper limit for the random numbers
        int randNum = randNumGen.nextInt(sides) + 1;
        IntValue res = new IntValue(randNum);
        System.out.println("SingleRollExp:" + randNum);
        return res;
    }
}
