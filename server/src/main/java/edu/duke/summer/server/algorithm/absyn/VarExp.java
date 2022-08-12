package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class VarExp extends Exp {
   public Var var;
   public VarExp(int p, Var v) {pos=p; var=v;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
     return var.eval(varEntry, randNumGen, info, state);
   }
}
