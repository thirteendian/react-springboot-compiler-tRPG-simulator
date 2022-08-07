package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.*;
import edu.duke.summer.client.algorithm.value.VoidValue;

import java.util.HashMap;
import java.util.Random;

public class Block extends Stmt{
    StmtList list;

    public Block(int p, StmtList s){pos = p; list = s; }
    int i = 0;

    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        state.addBlockId("b");
        varEntry.addBlockId("b");
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
        varEntry.popBlockId();
        state.popBlockId();
        return returnValue;
    }
}
