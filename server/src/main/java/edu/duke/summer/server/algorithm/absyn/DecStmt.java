package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class DecStmt extends Stmt{

    Dec dec;

    public DecStmt(int p, Dec d){
        pos = p;
        dec = d;
    }

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        if(state.getBreakMark()){
            return new VoidValue();
        }
        return dec.eval(varEntry, randNumGen, info, state);
    }
}
