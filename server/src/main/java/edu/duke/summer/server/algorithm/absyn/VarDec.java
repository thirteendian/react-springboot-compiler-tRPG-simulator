package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class VarDec extends Dec {
   public Symbol name;
   public boolean escape = true;
   public NameTy typ; /* optional */
   public Exp init;
   public VarDec(int p, Symbol n, NameTy t, Exp i) {pos=p; name=n; typ=t; init=i;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
