package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.ArrayValue;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InitArrayExp extends Exp{
    ArrayList<Exp> list;

    public InitArrayExp(){
        list = new ArrayList<>();
    }

    public void add(Exp ele){
        list.add(ele);
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        ArrayList<Value> input = new ArrayList<>();
        for(Exp e : list){
            Value val = e.eval(varEntry, randNumGen, info, state);
            input.add(val);
        }
        ArrayValue res = new ArrayValue(input);
        return res;
    }
}
