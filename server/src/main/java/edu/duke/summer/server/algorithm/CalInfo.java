package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.absyn.Var;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

public class CalInfo {
    public VarEntry varEntry;
    public Random randNumGen;
    public RuleInfo info;
    public StateInfo state;
    public CalInfo(VarEntry v, Random r, RuleInfo ru, StateInfo s){
        varEntry = v;
        randNumGen = r;
        info = ru;
        state = s;
    }
}
