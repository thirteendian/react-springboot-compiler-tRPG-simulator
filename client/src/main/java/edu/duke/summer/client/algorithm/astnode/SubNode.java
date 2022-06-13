package edu.duke.summer.client.algorithm.astnode;

import edu.duke.summer.client.algorithm.astnode.ArithmeticNode;

import java.util.HashMap;
import java.util.Random;

public class SubNode extends ArithmeticNode {
    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        return this.leftExp.eval(vars, randNumGen) - this.rightExp.eval(vars, randNumGen);
    }

    @Override
    public void save(RuleInfo info) {

    }
}
