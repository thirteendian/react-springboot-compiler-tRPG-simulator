package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.OptionValue;
import edu.duke.summer.server.algorithm.value.StringValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class OptionTy extends Ty{
    public Symbol tyName;
    public Symbol key;
    public Ty elem;
    public OptionTy(int p, Symbol t) {pos=p; tyName=t; key = Symbol.symbol("option");}

    public OptionTy(OptionTy refer){
        tyName = refer.tyName;
        key = refer.key;
        if(refer.elem instanceof OptionTy){
            elem = new OptionTy(pos, refer.elem);
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

    public OptionTy(int p, Absyn a){
        key = Symbol.symbol("option");
        if(a instanceof ArrayTy){
            String tmpTyp = ((ArrayTy) a).getTyName().toString() + " option";
            elem = (ArrayTy) a;
            tyName = Symbol.symbol(tmpTyp);
        }
        else if(a instanceof OptionTy){
            String tmpTyp = ((OptionTy) a).getTyName().toString() + " option";
            elem = (OptionTy) a;
            tyName = Symbol.symbol(tmpTyp);
        }
        else if(a instanceof NameTy || a instanceof PrimTy || a instanceof BooleanTy){
            String tmpTyp = ((Ty) a).getName() + " option";
            elem = (Ty)a;
            tyName = Symbol.symbol(tmpTyp);

        }else{
            throw new IllegalArgumentException("Invalid option declaration!");
        }
    }
    public String getName() {
        return null;
    }

    public Symbol getTyName() {
        return tyName;
    }

    public String getKey() {
        return key.toString();
    }
    public Ty getElem() {
        return elem;
    }

    @Override
    public Value getInitValue() {
        return new OptionValue(elem);
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        return new VoidValue();
    }
}
