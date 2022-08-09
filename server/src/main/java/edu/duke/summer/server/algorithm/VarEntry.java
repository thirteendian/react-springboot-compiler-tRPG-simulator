package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.value.IntValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Map;

public class VarEntry {
    String blockId;

    HashMap<String, HashMap<String, Value>> blockVars;

    HashMap<String, HashMap<String, Value>> currBlockVars;

    public VarEntry(){
         blockId = "Init";
         blockVars = new HashMap<>();
         currBlockVars = new HashMap<>();
    }

    public void popBlockId(){
        blockId.substring(0, blockId.length() - 2);
    }

    public HashMap<String, Value> getCurrBlockVars(String id){
        HashMap<String, Value> vars =  currBlockVars.get(id);
        if(vars == null){
            return new HashMap<>();
        }else{
            return vars;
        }
    }

    public void addCurrBlockVars(String id, String name, Value val){
        HashMap<String, Value> vars = getCurrBlockVars(id);
        if(vars.containsKey(name)){
            throw new IllegalArgumentException("The variable has already been defined in this scope!");
        }else{
            vars.put(name, val);
        }
        currBlockVars.put(id, vars);
    }

    public HashMap<String, Value> getVars(String id) {
        HashMap<String, Value> vars =  blockVars.get(id);
        if(vars == null){
            vars = new HashMap<>();
        }
        for(Map.Entry<String, HashMap<String, Value>> entry : blockVars.entrySet()){
            if(id.length() == entry.getKey().length() + 1){
                for(Map.Entry<String, Value> subEntry: entry.getValue().entrySet()){
                    if(vars.containsKey(subEntry.getKey()))continue;
                    vars.put(subEntry.getKey(),subEntry.getValue());
                }
            }
        }
        blockVars.put(id, vars);
        Value val = vars.get("i");
        Integer i = 0;
        if(val != null){
            if(val instanceof IntValue){
                i = ((IntValue) val).getValue();
            }
        }
        return vars;
    }

    public void addBlockId(String str){
        blockId = blockId.concat(str);
    }

    public String getBlockId(){
        return blockId;
    }

    public void addVar(String id, String name, Value val){
        addCurrBlockVars(id, name, val);
        HashMap<String, Value> vals = blockVars.get(id);
        for(Map.Entry<String, HashMap<String, Value>> entry : blockVars.entrySet()){
            for(Map.Entry<String, Value> subEntry: entry.getValue().entrySet()){
                if(vals.containsKey(subEntry.getKey()))continue;
                vals.put(subEntry.getKey(),subEntry.getValue());
            }
        }
        if(vals == null){
            vals = new HashMap<>();
            vals.put(name, val);
            blockVars.put(id, new HashMap<>(vals));
        }else{
            vals.put(name, val);
            blockVars.put(id, vals);
        }
    }
}
