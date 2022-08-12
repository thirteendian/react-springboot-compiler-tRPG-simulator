package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class IntExp extends Exp {
   public int value;
   public IntExp(int p, int v) {pos=p; value=v;}


   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      IntValue val = new IntValue(value);
      return val;
   }
}
