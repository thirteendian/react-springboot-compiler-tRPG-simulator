package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class SingleRollNode extends ExpNode {
    Integer sides;

    public SingleRollNode(String singleRollStr){
        String substr = singleRollStr.substring(1);
        sides = Integer.parseInt(substr);
    }
    public Integer getSides() {
        return sides;
    }

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        //set upper limit for the random numbers
        int randNum = randNumGen.nextInt(sides) + 1;
        return randNum;
    }

    @Override
    public void save(RuleInfo info) {

    }
}
