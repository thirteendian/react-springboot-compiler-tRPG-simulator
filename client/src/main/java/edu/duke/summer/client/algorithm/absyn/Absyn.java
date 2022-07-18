package edu.duke.summer.client.algorithm.absyn;
import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

abstract public class Absyn {
  public int pos;
  public abstract Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state);

}
