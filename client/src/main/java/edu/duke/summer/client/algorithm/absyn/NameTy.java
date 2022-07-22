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

   public String getName() {
      return name.toString();
   }

   public String getKey() {
      return key.toString();
   }

   public Ty getElem() {
      return null;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      if(!(info.getTypes().containsKey(name.toString()))){
         throw new IllegalArgumentException("Using undefined type:" + name.toString() + "!");
      }
      return new VoidValue();
   }
}
