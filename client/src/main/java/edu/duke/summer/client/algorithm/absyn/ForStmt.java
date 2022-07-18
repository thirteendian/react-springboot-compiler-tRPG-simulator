package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class ForStmt extends Stmt {
   public VarDec var;
   public Exp scope;
   public Stmt body;
   public ForStmt(int p, VarDec v, Exp h, Stmt b) {pos=p; var=v; scope=h; body=b;}
   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }

}
