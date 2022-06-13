package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class RollNode extends ExpNode {
    Integer times;
    Integer sides;

    public RollNode(String rollStr){
        int index = rollStr.indexOf("d");
        int len = rollStr.length();
        String substr_t = rollStr.substring(0,index);
        String substr_s = rollStr.substring(index + 1);
        try{
            times = Integer.parseInt(substr_t);
            sides = Integer.parseInt(substr_s);
        }catch (Exception e){
            throw new NumberFormatException("Input format is not supported.");
        }

    }
    public Integer getSides() {
        return sides;
    }
    public Integer getTimes() {
        return times;
    }


    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        Integer randomResult = 0;
        for(int i = 0; i < times; i++){
            //set upper limit for the random numbers
            randomResult = randNumGen.nextInt(sides) + 1;
        }
      //  System.out.println("RollExp:" + randomResult);
        return randomResult;

    }

    @Override
    public void save(RuleInfo info) {

    }
}
