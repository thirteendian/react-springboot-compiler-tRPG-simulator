package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class WhileStmt extends Stmt {
   public Exp test;
   public Stmt body;
   public WhileStmt(Exp t, Stmt b) {test=t; body=b;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
