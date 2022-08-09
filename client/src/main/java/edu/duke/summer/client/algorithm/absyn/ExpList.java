package edu.duke.summer.client.algorithm.absyn;

public class ExpList {
   public Exp head;
   public ExpList tail;
   public ExpList(Exp h, ExpList t) {head=h; tail=t;}
   public ExpList append(ExpList list){
      if(tail != null){
         tail = tail.append(list);
      }else{
         tail = list;
      }
      return this;
   }

   public void printInfo(){
      ExpList curr= tail;
      while(curr != null){
         curr = curr.tail;

      }
   }
}
