package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.ArrayValue;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ForStmt extends Stmt {
   public Var var;
   public Exp scope;
   public Stmt body;
   public ForStmt(int p, Var v, Exp s, Stmt b) {pos=p; var=v; scope=s; body=b;}
   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      if(state.getBreakMark()){
         return new VoidValue();
      }
      Value value = scope.eval(varEntry, randNumGen, info, state);
      HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
      int flag = 0;
      String varName = ((SimpleVar)var).name.toString();
      if(value instanceof ArrayValue){
         ArrayList<Value> list = ((ArrayValue) value).getValue();
         if(vars.get(varName) == null && list.size() > 0){
            vars.put(varName, list.get(0));
            flag = 1;
         }
         for (Value l : list) {
            var.setVal(varEntry, randNumGen, info, state, l);
            body.eval(varEntry, randNumGen, info, state);
            if(state.getBreakMark()){
               break;
            }
         }
         state.setBreakMark(false);
         if(flag == 1){
            vars.remove(varName);
         }
      }
      return new VoidValue();
   }

}
