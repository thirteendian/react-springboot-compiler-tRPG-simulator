package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.Symbol.Symbol;
import edu.duke.summer.server.algorithm.TypeInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;

import java.util.HashMap;
import java.util.Random;

public class UnInitVarDec extends Dec{
    public Symbol name;

    public boolean escape = true;
    public Ty typ;
    public UnInitVarDec(int p, Symbol n, Ty t) {pos=p; name=n; typ=t;}

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
        if(vars.containsKey(name.toString())){
            throw new IllegalArgumentException("The name of the variable " + name.toString() + " has already been used before!");
        }else{
            Value val;
            if(typ instanceof ArrayTy){
                val = new ArrayValue(((ArrayTy) typ).elem);
            }else if (typ instanceof OptionTy){
                val = new OptionValue(((OptionTy) typ).elem);
            }else if (typ instanceof BooleanTy){
                val = new BooleanValue();
            }else if (typ instanceof NameTy){
                String TypeId = typ.getName();
                TypeInfo typeinfo = info.getTypes().get(TypeId);
                FieldList list = typeinfo.getFields();
                val = new TypeValue(TypeId, list, info);
            }else if (typ instanceof PrimTy) {
                if(typ.getName().equals("int")){
                    val = new IntValue();
                }else{
                    val = new StringValue();
                }
            }else{
                throw new IllegalArgumentException("Invalid field type of type " + typ.getName());
            }
            vars.put(name.toString(), val);
        }
        return new VoidValue();
    }
}
