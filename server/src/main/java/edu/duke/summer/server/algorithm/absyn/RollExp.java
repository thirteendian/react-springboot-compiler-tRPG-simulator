package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static edu.duke.summer.server.algorithm.absyn.SingleRollExp.trimFirstAndLastChar;

public class RollExp extends Exp {
    Integer times;
    Integer sides;

    public RollExp(int p, String rollStr){
        pos = p;
        rollStr = trimFirstAndLastChar(rollStr, "\"");
        int index = rollStr.indexOf("d");
        String substr_t = rollStr.substring(0,index);
        String substr_s = rollStr.substring(index + 1);
        times = Integer.parseInt(substr_t);
        sides = Integer.parseInt(substr_s);

    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        Integer randomResult = 0;
        for(int i = 0; i < times; i++){
            //set upper limit for the random numbers
            randomResult += randNumGen.nextInt(sides) + 1;
        }
        System.out.println("RollExp:" + randomResult);
        state.addRoll(state.getCurrState(), randomResult);
        IntValue res = new IntValue(randomResult);
        return res;

    }
}
