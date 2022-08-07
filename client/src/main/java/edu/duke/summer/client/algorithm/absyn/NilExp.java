package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.Value;
import edu.duke.summer.client.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class NilExp extends Exp {
  public NilExp(int p) {pos=p;}

  @Override
  public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
    return new VoidValue();
  }
}
