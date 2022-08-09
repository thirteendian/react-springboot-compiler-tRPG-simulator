package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

abstract public class Absyn {
  public int pos;
  public abstract Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state);

}
