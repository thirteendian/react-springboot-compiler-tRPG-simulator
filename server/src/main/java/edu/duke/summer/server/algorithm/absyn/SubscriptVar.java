package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class SubscriptVar extends Var {
   public Var var;
   public Exp index;
   public SubscriptVar(int p, Var v, Exp i) {pos=p; var=v; index=i;}

   public Integer getIndex(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state){
      Value indexVal = index.eval(varEntry, randNumGen, info, state);
      int res;
      if(indexVal instanceof IntValue) {
         res = ((IntValue) indexVal).getValue();
      }else{
         throw new IllegalArgumentException("Invalid index expression in SubscriptVar! Require integer type for index.");
      }
      return res;
   }

   public Value getArray(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state){
      //getElem
      if(var instanceof SimpleVar){
         String keyName = ((SimpleVar) var).name.toString();
         Value val = varEntry.getVar(keyName);
         if(val instanceof ArrayValue){
            return val;
         }else{
            throw new IllegalArgumentException("Invalid value " + var +  " for FieldVar.");
         }
      }else if(var instanceof FieldVar || var instanceof SubscriptVar){
         Value val = var.eval(varEntry, randNumGen, info, state);
         if(val instanceof ArrayValue){
            return val;
         }else{
            throw new IllegalArgumentException("Invalid FieldVar! Struct type required for FieldVar!");
         }
      }else{
         throw new IllegalArgumentException("Invalid FieldVar: Invalid lvalue or invalid ID used.");
      }

   }

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      int index = getIndex(varEntry, randNumGen, info, state);
      Value val = getArray(varEntry, randNumGen, info, state);
      if(val instanceof ArrayValue){
         return ((ArrayValue) val).getElem(index);
      }else{
         throw new IllegalArgumentException("Get array failed!");
      }

   }

   @Override
   public void setVal(VarEntry varEntry,  Random randNumGen, RuleInfo info, StateInfo state, Value val) {
      Value value = getArray(varEntry, randNumGen, info, state);
      int index = getIndex(varEntry, randNumGen, info, state);
      ((ArrayValue)value).setElem(index, val);
//      ((ArrayValue)value).printInfo();
   }
}
