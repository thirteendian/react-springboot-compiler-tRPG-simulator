package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class FieldVar extends Var {
   public Var var;
   public Symbol field;
   public FieldVar(int p, Var v, Symbol f) {pos=p; var=v; field=f;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
