package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.*;
import edu.duke.summer.server.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class Block extends Stmt{
    StmtList list;

    public Block(int p, StmtList s){pos = p; list = s; }
    int i = 0;

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        varEntry.startBlock();
        if(state.getReturnMark()){
            return new VoidValue();
        }
        Value returnValue = new VoidValue();
        for(Stmt s : list.list){
            returnValue = s.eval(varEntry, randNumGen, info, state);
            if(s instanceof IfStmt){
                state.pushSubState("i");
            }
            if(s instanceof WhileStmt){
                state.pushSubState("l");
            }
            if(s instanceof ForStmt){
                state.pushSubState("f");
            }
            if(s instanceof ReturnStmt){
                state.setReturnMark(true);
                return returnValue;
            }
            if(s instanceof BreakStmt){
               state.setBreakMark(true);
            }
        }
        varEntry.endBlock();
        return returnValue;
    }
}
