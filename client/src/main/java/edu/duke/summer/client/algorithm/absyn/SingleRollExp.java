package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class SingleRollExp extends Exp {
    Integer sides;

    public SingleRollExp(int p, String singleRollStr){
        pos = p;
        singleRollStr = trimFirstAndLastChar(singleRollStr, "\"");
        String substr = singleRollStr.substring(1);
        sides = Integer.parseInt(substr);
    }

    public static String trimFirstAndLastChar(String str, String element){
        boolean beginIndexFlag = true;
        boolean endIndexFlag = true;
        do{
            int beginIndex = str.indexOf(element) == 0 ? 1 : 0;
            int endIndex = str.lastIndexOf(element) + 1 == str.length() ? str.lastIndexOf(element) : str.length();
            str = str.substring(beginIndex, endIndex);
            beginIndexFlag = (str.indexOf(element) == 0);
            endIndexFlag = (str.lastIndexOf(element) + 1 == str.length());
        } while (beginIndexFlag || endIndexFlag);
        return str;
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        //set upper limit for the random numbers
        int randNum = randNumGen.nextInt(sides) + 1;
        IntValue res = new IntValue(randNum);
        System.out.println("SingleRollExp:" + randNum);
        state.addRoll(state.getCurrState(), randNum);
        return res;
    }
}
