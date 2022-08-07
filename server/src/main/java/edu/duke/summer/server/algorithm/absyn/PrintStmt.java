package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.RollState;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.value.Value;
import java.util.HashMap;
import java.util.Random;

public class PrintStmt extends Stmt{
    Exp val;

    public PrintStmt(int p, Exp m){ pos = p; val = m;}

    @Override
    public Value eval(HashMap<String, Value> vars, Random randNumGen, RuleInfo info, RollState state) {
        return null;
    }
}
