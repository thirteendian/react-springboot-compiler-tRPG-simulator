package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class SeqExp extends Exp {
   public ExpList list;
   public SeqExp(int p, ExpList l) {pos=p; list=l;}
   public void append(SeqExp tail){
      list.append(tail.list);
   }

   public void printInfo(){
      System.out.println("-------seqExp-------");
      ExpList curr = list;
      System.out.println(curr.toString());
      while(curr.tail != null){
         curr = curr.tail;
         System.out.println(curr.toString());
      }

   }
   public ExpList getList() {
      return list;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      ExpList curr = list;
      while(curr != null){
         curr.head.eval(vars,randNumGen,info,state);
         curr = curr.tail;
      }
      return new VoidValue();
   }
}
