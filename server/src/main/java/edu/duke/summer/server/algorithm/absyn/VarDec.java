package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VarDec extends Dec {
   public Symbol name;
   public boolean escape = true;
   public Ty typ; /* optional */
   public Exp init;
   public VarDec(int p, Symbol n, Ty t, Exp i) {pos=p; name=n; typ=t; init=i;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      Value initValue = init.eval(varEntry, randNumGen, info, state);
      HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
      if(vars.containsKey(name.toString())){
         HashMap<String, Value> currBlockVars = varEntry.getCurrBlockVars(state.getBlockId());
         if(currBlockVars.containsKey(name.toString())){
            throw new IllegalArgumentException("The name of the variable " + name.toString() + " has already been used before!");
         }else{
           varEntry.addVar(state.getBlockId(), name.toString(), initValue);
         }
      }else{
         varEntry.addVar(state.getBlockId(),name.toString(), initValue);
      }
      return new VoidValue();
   }
}
