package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.IntValue;
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
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      Value value = varEntry.getVar(name.toString());
      return value;
   }

   @Override
   public void setVal(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state, Value val) {
      HashMap<String, Value> vars = varEntry.getAllVars();
      if(!vars.containsKey(name.toString())){
         throw new IllegalArgumentException("Var " + name.toString() + " not exist in the scope.");
      }
      varEntry.forceAddVar(name.toString(), val);
   }
}
