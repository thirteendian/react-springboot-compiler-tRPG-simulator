package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class AddNode extends ArithmeticNode {

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        System.out.println("AddExp:");
       return this.leftExp.eval(vars, randNumGen) + this.rightExp.eval(vars, randNumGen);
    }
}
