package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class SimpleVar extends Var {
   public Symbol name;
   public SimpleVar(int p, Symbol n) {
      pos = p;
      this.name = n;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      Value value = vars.get(name.toString());
         if (value == null){
            throw new IllegalArgumentException("the var " + name.toString() + " does not exist in the HashMap!");
         } else {
            return value;
         }
   }
}
