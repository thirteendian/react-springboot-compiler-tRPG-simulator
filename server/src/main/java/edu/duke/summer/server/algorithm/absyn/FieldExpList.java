package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class FieldExpList extends Absyn {
   public Symbol name;
   public Exp init;
   public FieldExpList tail;
   public FieldExpList(int p, Symbol n, Exp i, FieldExpList t) {pos=p;
	name=n; init=i; tail=t;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
