package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.*;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.Value;
import edu.duke.summer.client.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class FunctionDec extends Dec {
   public Symbol name;
   public FieldList params;
   public Ty result;  /* optional */
   public Stmt body;
   public FunctionDec(int p, Symbol n, FieldList a, Ty r, Stmt b) {
      pos=p; name=n; params=a; result=r; body=b;
   }

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      CalInfo calInfo = new CalInfo(new VarEntry(), randNumGen, info, new StateInfo());
//      if(params != null) {
//         String paramName = params.name.toString();
//         Ty paramType = params.type;
//         calInfo.vars.put(paramName, new VoidValue());
//         FieldList tail = params.tail;
//         while (tail != null) {
//            paramName = tail.name.toString();
//            paramType = tail.type;
//            calInfo.vars.put(paramName, new VoidValue());
//            tail = tail.tail;
//         }
//      }
      FuncInfo funInfo = new FuncInfo(name.toString(), params, result, calInfo, body);
      info.addFuncs(funInfo);
      return new VoidValue();
   }
}
