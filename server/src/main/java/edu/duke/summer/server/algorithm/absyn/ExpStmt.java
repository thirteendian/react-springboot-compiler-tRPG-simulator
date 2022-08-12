package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class ExpStmt extends Stmt{
    Exp exp;

    public ExpStmt(int p, Exp e){
        pos = p;
        exp = e;
    }
    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        if(state.getBreakMark()){
            return new VoidValue();
        }
        return exp.eval(varEntry, randNumGen, info, state);
    }
}
