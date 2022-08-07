package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.VarEntry;
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
   public Value getInitValue() {
      throw new IllegalArgumentException("Some inner problem happened!");
   }

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      if(!(info.getTypes().containsKey(name.toString()))){
         throw new IllegalArgumentException("Using undefined type:" + name.toString() + "!");
      }
      return new VoidValue();
   }
}
