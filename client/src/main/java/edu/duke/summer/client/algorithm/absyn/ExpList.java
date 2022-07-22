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
      System.out.println(head.toString());
      ExpList curr= tail;
      while(curr != null){
         System.out.println(curr.head.toString());
         curr = curr.tail;

      }
   }
}
