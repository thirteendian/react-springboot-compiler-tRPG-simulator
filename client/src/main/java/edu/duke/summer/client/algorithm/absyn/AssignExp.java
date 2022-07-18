package edu.duke.summer.client.algorithm.absyn;
import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class AssignExp extends Exp {
   public Var var;
   public Exp exp;

   public AssignExp(int p, Var v, Exp e) {pos=p; var=v; exp=e;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {

      return null;
   }
}
