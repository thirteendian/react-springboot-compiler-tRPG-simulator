package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.*;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CallExp extends Exp {
   public Symbol func;
   public ExpList args;
   public CallExp(int p, Symbol f, ExpList a) {pos=p; func=f; args=a;}

   public void removeParams(HashMap<String, Value> vars){

   }
   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      HashMap<String, FuncInfo> funcMap = info.getFuncs();
      FuncInfo funInfo = funcMap.get(func.toString());
      if(funInfo == null){
         throw new IllegalArgumentException("Function " + func.toString() + " not exist in this scope!");
      }else {
         CalInfo newCalInfo = new CalInfo(new VarEntry(), randNumGen, info, new StateInfo());
         if (funInfo.getParams() != null) {
            FieldList params = funInfo.getParams();
            HashMap<String, Value> paramList = new HashMap<>();
            String name = params.name.toString();
            Value value = args.head.eval(varEntry, randNumGen, info, state);
            paramList.put(name, value);
            FieldList fieldTail = params.tail;
            ExpList expTail = args.tail;
            while (fieldTail != null && expTail != null) {
               name = fieldTail.name.toString();
               Value val = expTail.head.eval(varEntry, randNumGen, info, state);
               paramList.put(name, val);
               fieldTail = fieldTail.tail;
               expTail = expTail.tail;
            }
            if (fieldTail == null && expTail == null) {
               funInfo.setCalInfo(newCalInfo);
               FuncCallResult result = funInfo.getResult(paramList, state);
               Value res = result.getVal();
               return res;

            } else {
               throw new IllegalArgumentException(pos + ":Invalid parameters in function call to function " + funInfo.getFuncName());
            }
         } else if (funInfo.getParams() == null) {
            HashMap<String, Value> nullParamList = new HashMap<>();
            funInfo.setCalInfo(newCalInfo);
            FuncCallResult result = funInfo.getResult(nullParamList, state);
            Value res = result.getVal();
            return res;
         }else{
            throw new IllegalArgumentException(pos + ":Invalid call exp of function " + func.toString());
         }
      }
   }
}
