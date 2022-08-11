package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.value.*;

import java.util.*;

public class VarEntry {
    Deque<HashMap<String, Value>> vars;

    public VarEntry(){
         vars = new ArrayDeque<>();
    }

    public void startBlock(){
        vars.push(new HashMap<>());
    }

    public void endBlock(){
       vars.pop();
    }

    public HashMap<String, Value> getCurrScopeVars() {
        return vars.peek();
    }

    public void addVar(String name, Value val){
        HashMap<String, Value> stackTop = vars.pop();
        if(stackTop.containsKey(name)){
            throw new IllegalArgumentException("The variable name " + name + " has already been used in this scope!");
        }else{
            stackTop.put(name, val);
            vars.push(stackTop);
        }
    }

    public void forceAddVar(String name, Value val){
        HashMap<String, Value> stackTop = vars.pop();
        stackTop.put(name, val);
        vars.push(stackTop);
    }

    public Value getVar(String name){
        for(HashMap<String, Value> var : vars){
            if(var.containsKey(name)){
                return var.get(name);
            }
        }
        throw new IllegalArgumentException("Undefined variable " + name + " used!");
    }

    public HashMap<String, Value> getAllVars(){
        HashMap<String, Value> allVars = new HashMap<>();
        for(HashMap<String, Value> var : vars){
            for(Map.Entry<String, Value>entry : var.entrySet()){
                if(allVars.containsKey(entry.getKey())) continue;
                else{
                    allVars.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return allVars;

    }
}
