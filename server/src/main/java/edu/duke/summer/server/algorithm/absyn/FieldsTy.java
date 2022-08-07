package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.*;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

//StructTy
public class FieldsTy extends Ty {
   public FieldList fields;
   public FieldsTy(int p, FieldList f) {pos=p; fields=f;}

   public FieldList getFields() {
      return fields;
   }

   public HashMap<String, String> getFieldsNameStr(RuleInfo info){
      HashMap<String, String> ans = new HashMap<>();
      FieldList list = fields;
      while(list != null){
         String name = list.name.toString();
         String typ = list.typ.toString();
         ans.put(name, typ);
         list = list.tail;
      }
      return ans;
   }

   public FieldList getFieldList() {
      return fields;
   }

   public void printInfo(){
      System.out.println("-------FieldsTy-------");
      fields.printInfo();
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      FieldList list = fields;
      while(list != null){
         fields.eval(vars, randNumGen, info, state);
         list = list.tail;
      }
      return new VoidValue();
   }

   @Override
   public String getKey() {
      return null;
   }

   @Override
   public String getName() {
      return null;
   }

   @Override
   public Ty getElem() {
      return null;
   }
}
