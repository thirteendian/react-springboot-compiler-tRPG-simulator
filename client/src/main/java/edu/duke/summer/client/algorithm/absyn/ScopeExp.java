package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class ScopeExp extends Exp {
   public DecList decs;
   public Exp body;
   public ScopeExp(int p, DecList d, Exp b) {pos=p; decs=d; body=b;}
   public ScopeExp append(ScopeExp exp){
      decs = decs.append(exp.decs);
      return this;
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
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      DecList curr = decs;
      while(curr != null){
         curr.head.eval(varEntry, randNumGen, info, state);
         curr = curr.tail;
      }
      if(body != null) body.eval(varEntry, randNumGen, info, state);
      return new VoidValue();
   }
}
