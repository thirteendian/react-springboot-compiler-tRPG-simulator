package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.*;
import edu.duke.summer.server.algorithm.value.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BuildInFuncStmt extends Stmt{
    String funcName;
    FieldList params;
    public BuildInFuncStmt(String name, FieldList p){
        funcName = name;
        params = p;
    }
    @Override
    public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
        HashMap<String, Value> vars = varEntry.getVars(state.getBlockId());
        if(funcName.equals("output")){
            String name = params.name.toString();
            Value val = vars.get(name);
            if(val == null){
                throw new IllegalArgumentException("Parameters needed is not passed for function " + funcName + ".");
            }else{
                state.addOutput(val.getPrintInfo());
            }
        }else if(funcName.equals("roll")){
            String paramName = params.name.toString();
            Value rollInfo = vars.get(paramName);
            if(rollInfo instanceof StringValue){
                String rollStr = ((StringValue)rollInfo).getValue();
                Value res = new EvalServicempl().evalRoll(rollStr, vars, new Random());
                state.pushSubState("r");
                String id = state.getCurrState();
                //System.out.println(rollStr + ": rollId:"+ id);
                HashMap<String, Integer> rollVals = state.getRolls();
                ArrayList<String> reRollDices = state.getReRollDices();
                for(int i = 0; i < reRollDices.size(); i++){
                    if(!rollVals.containsKey(reRollDices.get(i))){
                        throw new IllegalArgumentException("the reRollDice Id not exist in the rollVals HashMap");
                    }else{
                        if(res instanceof IntValue){
                            rollVals.replace(reRollDices.get(i), ((IntValue) res).getValue());
                        }else{
                            throw new IllegalArgumentException("invalid reroll value!");
                        }
                    }
                }
                if(!rollVals.containsKey(id)){
                    state.addRoll(id, ((IntValue) res).getValue());
                }
                return res;
            }else{
                throw new IllegalArgumentException("Invalid rollStr for rolling dice!");
            }

        }else if(funcName.equals("oneUserOption")){
            String objectName = params.name.toString();
            Value objectInfo = vars.get(objectName);
            state.pushSubState("u");
            String id = state.getCurrState();
            //System.out.println("oneUserOption:"+ id);
            String gameId = "", objectId = "";
            if(objectInfo instanceof TypeValue){
                gameId = ((TypeValue) objectInfo).getGameId();
                objectId = ((TypeValue) objectInfo).getObjectId();
            }else{
                throw new IllegalArgumentException("Invalid message format for userOption prompt!");
            }
            String msg = "";
            while(params.tail != null){
                String msgName = params.tail.name.toString();
                Value msgVal = vars.get(msgName);
                if(msgVal instanceof StringValue){
                    msg = ((StringValue) msgVal).getValue();
                }else{
                    throw new IllegalArgumentException("Invalid message format for userOption prompt!");
                }
            }
            ArrayList<String> trueUserOptions = state.getTrueUserOptions();
            for(int i = 0; i < trueUserOptions.size(); i++){
                if(id.equals(trueUserOptions.get(i))){
                    return new BooleanValue(true);
                }
            }
            UserOptionInfo oneUserOptionInfo = new UserOptionInfo(gameId,objectId,msg);
            state.addUserOption(id, oneUserOptionInfo);
            return new BooleanValue(false);
        }else if(funcName.equals("userOption")){
            String msgName = params.name.toString();
            Value msgVal = vars.get(msgName);
            state.pushSubState("u");
            String id = state.getCurrState();
           // System.out.println("userOption:"+ id);
            String msg = "";
            if(msgVal instanceof StringValue){
                msg = ((StringValue) msgVal).getValue();
            }else{
                throw new IllegalArgumentException("Invalid message format for userOption prompt!");
            }
            ArrayList<String> trueUserOptions = state.getTrueUserOptions();
            for(int i = 0; i < trueUserOptions.size(); i++){
                if(id.equals(trueUserOptions.get(i))){
                   // System.out.println("returnTrue");
                    return new BooleanValue(true);
                }
            }
            UserOptionInfo userOptionInfo = new UserOptionInfo(msg);
            state.addUserOption(id, userOptionInfo);
            return new BooleanValue(false);
        }
        return new VoidValue();
    }
}
