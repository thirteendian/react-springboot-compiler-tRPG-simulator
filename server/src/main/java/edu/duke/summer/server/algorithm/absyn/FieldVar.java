package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.TypeInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.TypeValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class FieldVar extends Var {
   public Var var;
   public Symbol field;
   public FieldVar(int p, Var v, Symbol f) {pos=p; var=v; field=f;}

   public Value getStruct(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state){
      if(var instanceof SimpleVar){
         String keyName = ((SimpleVar) var).name.toString();
         Value val = varEntry.getVar(keyName);
         if(val instanceof TypeValue){
            return val;
         }else{
            throw new IllegalArgumentException("Invalid value " + val +  " for FieldVar.");
         }
      }else if(var instanceof FieldVar || var instanceof SubscriptVar){
         Value val = var.eval(varEntry, randNumGen, info, state);
         if(val instanceof TypeValue){
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
      Value val = getStruct(varEntry, randNumGen, info, state);
      HashMap<String, Value> fields = ((TypeValue) val).getTypeFields();
      Value res = fields.get(field.toString());
      if(res == null){
         throw new IllegalArgumentException("Field" + field.toString() + " not exist in the type");
      }else{
         return res;
      }
   }

   @Override
   public void setVal(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state, Value val) {
      Value value = getStruct(varEntry, randNumGen, info, state);
      ((TypeValue) value) .setFieldValue(field.toString(), val);
   }
}
