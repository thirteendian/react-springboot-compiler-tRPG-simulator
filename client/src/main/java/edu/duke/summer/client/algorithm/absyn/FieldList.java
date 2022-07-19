package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
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

   public FieldList(int p, Symbol n, Symbol t,FieldList x) {
      pos=p; name=n; typ=t; tail=x;
   }

   public FieldList(int p, Symbol n, Symbol t, Ty ty, FieldList x) {
      pos=p; name=n; typ=t; tail=x; type = ty;
   }

   public void append(FieldList list){
      FieldList mark = tail;
      while(tail != null){
         tail = tail.tail;
      }
      tail = list;
      tail = mark;
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
      System.out.println(type.getName() + " " + type.getKey());
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
//         while((tmp instanceof ArrayTy) || (tmp instanceof OptionTy)){
//            if((tmp instanceof ArrayTy)){
//               System.out.println("key: "  + ((ArrayTy) tmp).getKey().toString());
//               System.out.println(((ArrayTy) tmp).elem.toString());
//               tmp = ((ArrayTy) tmp).elem;
//            }else{
//               System.out.println("key: "  + ((OptionTy) tmp).getKey().toString());
//               System.out.println(((OptionTy) tmp).elem.toString());
//               tmp = ((OptionTy) tmp).elem;
//            }
//         }
//         if(tmp instanceof PrimTy){
//            System.out.println("name: " + ((PrimTy) tmp).name );
//            System.out.println("key: " + ((PrimTy) tmp).key);
//         }
//         if(tmp instanceof BooleanTy) {
//            System.out.println("name: " + ((BooleanTy) tmp).name );
//            System.out.println("key: " + ((BooleanTy) tmp).key);
//         }
         tail = tail.tail;
      }
      tail = mark;
   }

   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
      if(type instanceof NameTy){
         String str = ((NameTy) type).getName().toString();
         if(!(info.getTypes().containsKey(str))){
            throw new IllegalArgumentException("Using undefined type in type declaration!");
         }
      }
      return new VoidValue();
   }
}
