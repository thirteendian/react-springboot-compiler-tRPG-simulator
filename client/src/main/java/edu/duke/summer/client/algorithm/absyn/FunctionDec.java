package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class FunctionDec extends Dec {
   public Symbol name;
   public FieldList params;
   public NameTy result;  /* optional */
   public Stmt body;
   public FunctionDec(int p, Symbol n, FieldList a, NameTy r, Stmt b)
			       {pos=p; name=n; params=a; result=r; body=b;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
