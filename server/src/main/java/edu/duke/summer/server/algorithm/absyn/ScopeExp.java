package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.*;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class ScopeExp extends Exp {
   public DecList decs;
   public Exp body;
   public ScopeExp(int p, DecList d, Exp b) {pos=p; decs=d; body=b;}
   public void append(ScopeExp exp){
      decs.append(exp.decs);
   }
   public void printInfo(){
      System.out.println("-----scopeExp-----");
      DecList curr = decs;
      System.out.println(decs.head.toString());
      while(curr.tail != null){
         System.out.println(decs.head.toString());
         curr = curr.tail;
      }
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      DecList curr = decs;
      while(curr != null){
         curr.head.eval(vars, randNumGen, info, state);
         curr = curr.tail;
      }
      if(body != null) body.eval(vars, randNumGen, info, state);
      return new VoidValue();
   }
}
