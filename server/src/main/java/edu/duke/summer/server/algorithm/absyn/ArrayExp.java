package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class ArrayExp extends Exp {
   public Ty typ;
   //todo: deal with the assignment without init typeId
   public Exp size;
   //todo: deal with declaration with size
   public Exp init;
   //initArrayExp
   public ArrayExp(int p, Ty t, Exp i) {pos=p; typ=t; init=i;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      Value v = init.eval(varEntry, randNumGen, info, state);
      return v;
   }
}
