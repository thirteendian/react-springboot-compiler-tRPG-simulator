package edu.duke.summer.client.algorithm.absyn;

public class DecList {
   public Dec head;
   public DecList tail;
   public DecList(Dec h, DecList t) {head=h; tail=t;}

   public void printInfo(){
      DecList curr = tail;
      while(curr != null){
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
