package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.BooleanValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class WhileStmt extends Stmt {
   public Exp test;
   public Stmt body;
   public WhileStmt(Exp t, Stmt b) {test=t; body=b;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      state.pushSubState("w");
      if(state.getBreakMark()){
         return new VoidValue();
      }
      Value value = test.eval(varEntry, randNumGen, info, state);
      HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
      if(value instanceof BooleanValue){
         while(((BooleanValue) value).getValue().equals(true)){
            if(state.getBreakMark()){
               break;
            }
            body.eval(varEntry, randNumGen, info, state);
            value = test.eval(varEntry, randNumGen, info, state);
         }
         state.setBreakMark(false);
      }else{
         throw new IllegalArgumentException("Require Boolean Type for the condition of the While Stmt!");
      }
      return new VoidValue();
   }
}
