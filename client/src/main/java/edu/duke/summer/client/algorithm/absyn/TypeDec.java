package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.TypeInfo;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class TypeDec extends Dec {
   public Symbol typeId;

   public Ty ty;

   public TypeDec(int p, Symbol n, Ty t) {pos=p; typeId=n; ty=t;}

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
       ty.eval(vars, randNumGen, info, state);
     if(ty instanceof FieldsTy){
        TypeInfo typeinfo = new TypeInfo(typeId.toString(), ty, info);
        info.addTypes(typeinfo);
     }else if(ty instanceof NameTy){
         //check whether the type exists
         ty.eval(vars,randNumGen,info,state);
         String id = ((NameTy) ty).name.toString();
        if(info.getTypes().containsKey(id)){
           TypeInfo referInfo = info.getTypes().get(id);
           TypeInfo newInfo = new TypeInfo(typeId.toString(), referInfo);
           info.addTypes(newInfo);
        }else{
            throw new IllegalArgumentException("Using undefined type!");
        }
     }else if((ty instanceof ArrayTy) || (ty instanceof OptionTy)){
        TypeInfo newInfo = new TypeInfo(typeId.toString(), ty, info);
        info.addTypes(newInfo);
     }else{
        throw new IllegalArgumentException("Invalid type declaration");
      }
      return new VoidValue();
   }
}
