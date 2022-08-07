package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.*;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class IntExp extends Exp {
   public int value;
   public IntExp(int p, int v) {pos=p; value=v;}


   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      IntValue val = new IntValue(value);
      return val;
   }
}
