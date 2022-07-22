package edu.duke.summer.client.algorithm.absyn;

public class DecList {
   public Dec head;
   public DecList tail;
   public DecList(Dec h, DecList t) {head=h; tail=t;}

   public void printInfo(){
      if(head instanceof TypeDec)System.out.println(((TypeDec) head).typeId);
      DecList curr = tail;
      while(curr != null){
         if(head instanceof TypeDec)System.out.println(((TypeDec) curr.head).typeId);
         curr = curr.tail;
      }
   }

   public void append(DecList list){
     // DecList mark = tail;
      while(tail != null){
         tail = tail.tail;
      }
      tail = list;
      //tail = mark;
   }
}
