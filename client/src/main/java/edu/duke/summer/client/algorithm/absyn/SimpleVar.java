package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.IntValue;
import edu.duke.summer.client.algorithm.value.Value;

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
      HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
      //System.out.println("inSimpleVar"+varEntry.getBlockId());
      Value value = vars.get(name.toString());
      //if(vars.get("i") != null)System.out.println("insimpleVar:" + ((IntValue)vars.get("i")).getValue());
         if (value == null){
            throw new IllegalArgumentException("the var " + name.toString() + " does not exist in the vars map!");
         } else {
            return value;
         }
   }

   @Override
   public void setVal(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state, Value val) {
      HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
      if(vars.get(name.toString()) == null){
         throw new IllegalArgumentException("Var " + name.toString() + " not exist in the scope.");
      }
      vars.replace(name.toString(), val);
   }
}
