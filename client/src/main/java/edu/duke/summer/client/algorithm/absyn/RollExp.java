package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class RollExp extends Exp {
    Integer times;
    Integer sides;

    public RollExp(int p, String rollStr){
        pos = p;
        int index = rollStr.indexOf("d");
        int len = rollStr.length();
        String substr_t = rollStr.substring(0,index);
        String substr_s = rollStr.substring(index + 1);
        times = Integer.parseInt(substr_t);
        sides = Integer.parseInt(substr_s);

    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        Integer randomResult = 0;
        for(int i = 0; i < times; i++){
            //set upper limit for the random numbers
            randomResult = randNumGen.nextInt(sides) + 1;
        }
        System.out.println("RollExp:" + randomResult);
        IntValue res = new IntValue(randomResult);
        return res;
    }
}
