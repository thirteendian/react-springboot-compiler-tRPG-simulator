package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class ValueNode extends ExpNode {
    private int value;
    public ValueNode(int input){
        this.value = input;
    }
    public int getValue() {
        return value;
    }

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        return this.value;
    }

    @Override
    public void save(RuleInfo info) {

    }
}
