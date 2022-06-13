package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public abstract class ExpNode {
    public abstract Integer eval(HashMap<String, Integer> vars, Random randNumGen);
    public abstract void save(RuleInfo info);
}
