package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;


public class VarNode extends ExpNode{
    String ID;
    public VarNode(String ID){
        this.ID = ID;
    }
    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        Integer value = vars.get(ID);
        if (value == null){
            throw new IllegalArgumentException("the var " + ID + " does not exist in the HashMap!");
        } else {
            return value;
        }
    }

    @Override
    public void save(RuleInfo info) {

    }
}
