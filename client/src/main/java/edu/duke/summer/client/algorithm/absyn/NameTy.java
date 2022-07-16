package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class NameTy extends Ty {
   public Symbol name;
   public Symbol key;
   public NameTy(int p, Symbol n, Symbol k) {pos=p; name=n; key = k;}

   public Symbol getName() {
      return name;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      if(!(info.getTypes().containsKey(name.toString()))){
         throw new IllegalArgumentException("Using undefined type!");
      }
      return new VoidValue();
   }
}
