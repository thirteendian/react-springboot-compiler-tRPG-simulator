package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class ExpStmt extends Stmt{
    Exp exp;

    public ExpStmt(int p, Exp e){
        pos = p;
        exp = e;
    }
    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
