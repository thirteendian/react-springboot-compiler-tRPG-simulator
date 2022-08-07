package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class StructExp extends Exp {
   public Symbol typ;
   public FieldExpList fields;
   public StructExp(int p, Symbol t, FieldExpList f) {pos=p; typ=t;fields=f;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      return null;
   }
}
