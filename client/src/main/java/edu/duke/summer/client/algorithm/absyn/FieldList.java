package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class FieldList extends Absyn {

   public Symbol name;

   public Ty type;

   public FieldList tail;
   public Symbol typ; //type string
   // e.g.string option [] option

   public boolean escape = true;

   public Symbol getName() {
      return name;
   }

   public Ty getType() {
      return type;
   }

   public FieldList getTail() {
      return tail;
   }

   public FieldList(int p, Symbol n, Symbol t, FieldList x) {
      pos=p; name=n; typ=t; tail=x;
   }

   public FieldList(int p, Symbol n, Symbol t, Ty ty, FieldList x) {
      pos=p; name=n; typ=t; tail=x; type = ty;
   }

   public void append(FieldList list){
      while(tail != null){
         tail = tail.tail;
      }
      tail = list;
   }

   public void printInfo(){
//      System.out.println("----------------------");
//      FieldList curr = tail;
//      System.out.println("field" + name.toString() + " " + typ.toString());
//      while(curr != null){
//         System.out.println("field" + curr.name.toString() + " " + curr.typ.toString());
//         curr = curr.tail;
//      }
      int i = 0;
      FieldList mark = tail;
      System.out.println(i + ": name:" + name);
      System.out.println(type.toString());
      while(type instanceof OptionTy || type instanceof ArrayTy){
         System.out.println("option/array -key:" + type.getKey());
         System.out.println("option/array -elem: " + type.getElem());
         type = type.getElem();
      }
      System.out.println("name:" + type.getName() + " key: "  + type.getKey());
      while(tail != null){
         i++;
         System.out.println(i + ": name:" + tail.name);
         System.out.println(tail.type.toString());
         Ty tmp = tail.type;
         while(tmp instanceof OptionTy || tmp instanceof ArrayTy){
            System.out.println("option/array -key:" + tmp.getKey());
            System.out.println("option/array -elem: " + tmp.getElem());
            tmp = tmp.getElem();
         }
         System.out.println("name:" + tmp.getName() + " key: "  + tmp.getKey());
         tail = tail.tail;
      }
      tail = mark;
   }

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      if(type instanceof NameTy){
         String str = type.getName();
         if(!(info.getTypes().containsKey(str))){
            throw new IllegalArgumentException("Using undefined type in type declaration!");
         }
      }
      return new VoidValue();
   }
}
