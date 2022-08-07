package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.BooleanValue;
import edu.duke.summer.client.algorithm.value.Value;
import edu.duke.summer.client.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class IfStmt extends Stmt {
   public Exp test;
   public Stmt thenclause;
   public Stmt elseclause; /* optional */
   public IfStmt(int p, Exp x, Stmt y) {test=x; thenclause=y; elseclause=null;}
   public IfStmt(int p, Exp x, Stmt y, Stmt z) {test=x; thenclause=y; elseclause=z;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      if(state.getBreakMark()){
         return new VoidValue();
      }
      Value value = test.eval(varEntry, randNumGen, info, state);
      if(value instanceof BooleanValue){
         if(((BooleanValue) value).getValue().equals(true)){
            state.pushSubState("t");
            Value val = thenclause.eval(varEntry, randNumGen, info, state);
            state.popSubState();
            return val;
         }else if (((BooleanValue) value).getValue().equals(false)){
            if(elseclause != null) {
               state.pushSubState("f");
               Value val = elseclause.eval(varEntry, randNumGen, info, state);
               state.popSubState();
               return val;
            }
            else return new VoidValue();
         }else{
            throw new IllegalArgumentException("Invalid Boolean Value in If Stmt!");
         }
      }else{
         throw new IllegalArgumentException("Require Boolean Type for the condition of the If Stmt!");
      }
   }
}
