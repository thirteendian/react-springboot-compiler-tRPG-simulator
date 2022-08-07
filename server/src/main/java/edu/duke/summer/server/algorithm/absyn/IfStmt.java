package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class IfStmt extends Stmt {
   public Exp test;
   public Stmt thenclause;
   public Stmt elseclause; /* optional */
   public IfStmt(int p, Exp x, Stmt y) {test=x; thenclause=y; elseclause=null;}
   public IfStmt(int p, Exp x, Stmt y, Stmt z) {test=x; thenclause=y; elseclause=z;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      return null;
   }
}
