package edu.duke.summer.client.algorithm.absyn;


import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

abstract public class Var extends Absyn {
    public abstract void setVal(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state, Value val);
}
