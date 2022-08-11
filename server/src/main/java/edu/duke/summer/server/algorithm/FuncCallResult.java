package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.value.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuncCallResult {
    Value val;
    RuleInfo info;
    StateInfo state;

    HashMap<String, Integer> rolls;

    HashMap<String, UserOptionInfo> userOptions;


    public FuncCallResult(Value v, RuleInfo i, StateInfo s){
        val = v;
        info = i;
        state = s;
        rolls = state.getRolls();
        userOptions = state.getUserOptions();
    }

    public Value getVal() {
        return val;
    }

    //get all output message
    public ArrayList<String> getOutput(){
        return state.getOutputMsgs();
    }

    public HashMap<String, Integer> getRolls() {
        return rolls;
    }

    public HashMap<String, UserOptionInfo> getUserOptions() {
        return userOptions;
    }

    public void printInfo(){
        System.out.println("------rollInfo in funcCallResult------");
        for(Map.Entry<String, Integer> entry : rolls.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("------userOptionInfo in funcCallResult------");
        for(Map.Entry<String, UserOptionInfo> entry : userOptions.entrySet()){
            System.out.println(entry.getKey() + ":");
            entry.getValue().printInfo();
        }

    }
}
