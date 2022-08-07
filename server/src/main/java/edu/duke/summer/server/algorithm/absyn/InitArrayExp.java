package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InitArrayExp extends Exp{
    ArrayList<Exp> list;

    public InitArrayExp(){
        list = new ArrayList<Exp>();
    }

    public void add(Exp ele){
        list.add(ele);
    }

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
