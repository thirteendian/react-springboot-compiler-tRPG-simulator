package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AssignExp extends Exp {
   public Var var;
   public Exp exp;

   public AssignExp(int p, Var v, Exp e) {pos=p; var=v; exp=e;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      Value val = exp.eval(varEntry, randNumGen, info, state);
      var.setVal(varEntry, randNumGen, info, state, val);
      return new VoidValue();
   }
}
