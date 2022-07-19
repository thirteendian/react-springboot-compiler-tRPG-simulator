package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.RollState;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class ArrayTy extends Ty {
   public Symbol tyName;
   public Integer size; //optional

   public Symbol key;
   public Ty elem;

   public String getKey() {
      return key.toString();
   }

   @Override
   public String getName() {
      return null;
   }

   public Ty getElem() {
      return elem;
   }

   public Symbol getTyName() {
      return tyName;
   }


   public ArrayTy(int p, Symbol t) {pos = p; tyName = t; key = Symbol.symbol("array");}
   public ArrayTy(ArrayTy refer){
      tyName = refer.tyName;
      size = refer.size;
      key = refer.key;
      if(refer.elem instanceof ArrayTy){
         elem = new ArrayTy(pos, refer.elem, size);
      }else if(refer.elem instanceof OptionTy){
         elem = new OptionTy(pos, refer.elem);
      }else if(refer.elem instanceof PrimTy){
         elem = new PrimTy(pos, Symbol.symbol(((PrimTy) refer.elem).getName()), ((PrimTy) refer.elem).key);
      }else if(refer.elem instanceof NameTy){
         elem = new NameTy(pos, Symbol.symbol(((NameTy) refer.elem).getName()), ((NameTy) refer.elem).key);
      }else if(refer.elem instanceof BooleanTy){
         elem = new BooleanTy(pos, Symbol.symbol(((BooleanTy) refer.elem).getName()), ((BooleanTy) refer.elem).key);
      }{
         throw new IllegalArgumentException("Invalid Array declaration!");
      }
   }
   public ArrayTy(int p, Absyn a, int s){
      key = Symbol.symbol("array");
      size = s;
      if(a instanceof ArrayTy){
         String tmpTyp = ((ArrayTy) a).getTyName().toString() + " []";
         elem =(ArrayTy) a;
         tyName = Symbol.symbol(tmpTyp);
      }
      else if(a instanceof OptionTy){
         String tmpTyp = ((OptionTy) a).getTyName().toString() + " []";
         tyName = Symbol.symbol(tmpTyp);
         elem =(OptionTy) a;
      }
      else if(a instanceof NameTy){
         String tmpTyp = ((NameTy) a).getName().toString()+ " []";
         tyName = Symbol.symbol(tmpTyp);
         elem = (NameTy) a;

      }else if(a instanceof PrimTy) {
         String tmpTyp = ((PrimTy) a).getName().toString() + " []";
         tyName = Symbol.symbol(tmpTyp);
         elem = (PrimTy) a;
      }else if(a instanceof BooleanTy) {
         String tmpTyp = ((BooleanTy) a).getName().toString() + " []";
         tyName = Symbol.symbol(tmpTyp);
         elem = (BooleanTy) a;
      }else{
         throw new IllegalArgumentException("Invalid array declaration!");
      }
   }


   @Override
   public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {

      return new VoidValue();
   }
}
