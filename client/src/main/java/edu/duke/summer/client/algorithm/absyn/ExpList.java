package edu.duke.summer.client.algorithm.absyn;

public class ExpList {
   public Exp head;
   public ExpList tail;
   public ExpList(Exp h, ExpList t) {head=h; tail=t;}
   public void append(ExpList list){
     // ExpList mark = tail;
      while(tail != null){
         tail = tail.tail;
      }
      tail = list;
      //tail = mark;
   }

   public void printInfo(){
      ExpList curr= tail;
      while(curr != null){
         curr = curr.tail;

      }
   }
}
