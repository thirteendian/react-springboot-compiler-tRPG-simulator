package edu.duke.summer.server.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StateInfo {
    //all existing roll info
    HashMap<String, Integer> rolls;

    //all existing userOptions
    HashMap<String, UserOptionInfo> userOptions;

    //Array of the ID of UserOption which has been chosen by the users(so its value changes to true
    ArrayList<String> trueUserOptions;

    //Array of the ID of the dice that needs to be reRoll(when user choose to reroll the dice
    ArrayList<String> reRollDices;


    //Msgs that need to be shown for the users
    ArrayList<String> outputMsgs;


    Boolean returnMark;
    Boolean breakMark;

    String currState;
    Stack<String> subState;


    public ArrayList<String> getOutputMsgs() {
        return outputMsgs;
    }

    public void addOutput(String strVal){
        outputMsgs.add(strVal);
    }
    public void clearMsgs(){
        outputMsgs.clear();
    }

    public HashMap<String, Integer> getRolls() {
        return rolls;
    }

    public HashMap<String, UserOptionInfo> getUserOptions() {
        return userOptions;
    }

    public ArrayList<String> getReRollDices() {
        return reRollDices;
    }

    public ArrayList<String> getTrueUserOptions() {
        return trueUserOptions;
    }

    public void addReRollDice(String id){reRollDices.add(id);}

    public void addTrueUserOption(String id){trueUserOptions.add(id);}
    public void addRoll(String id, Integer rollResult){rolls.put(id, rollResult);}
    public void addUserOption(String id, UserOptionInfo userOption){userOptions.put(id, userOption);}

    public void setReturnMark(Boolean breakMark) {
        this.returnMark = breakMark;
    }

    public void setBreakMark(Boolean breakMark) {
        this.breakMark = breakMark;
    }

    public void pushSubState(String str){subState.push(str);}

    public void popSubState(){if(!subState.empty()) subState.pop();}

    public String getCurrState() {
        currState = "";
        Stack<String> tmp = new Stack<>();
        while(!subState.empty()){
            String str = subState.peek();
            String tmpEle = subState.pop();
            currState = str + currState ;
            tmp.push(tmpEle);
        }
        while(!tmp.empty()){
            String ele = tmp.pop();
            subState.push(ele);
        }
        return currState;
    }

    public Boolean getBreakMark() {
        return breakMark;
    }

    public Boolean getReturnMark() {
        return returnMark;
    }

    public StateInfo(){
        outputMsgs = new ArrayList<>();
        returnMark = false;
        breakMark = false;
        subState = new Stack<>();
        currState = "";
        rolls = new HashMap<>();
        userOptions = new HashMap<>();
        trueUserOptions = new ArrayList<>();
        reRollDices = new ArrayList<>();
    }

    public void printInfo(){
        System.out.println("------stateInfo------");
        for(Map.Entry<String, Integer> entry : rolls.entrySet()){
            System.out.println("------rolls------");
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for(Map.Entry<String, UserOptionInfo> entry : userOptions.entrySet()){
            System.out.println("------userOptions------");
            System.out.println(entry.getKey() + ":");
            entry.getValue().printInfo();
        }
        System.out.println("------trueUserOptions------");
        for(int i = 0; i < trueUserOptions.size(); i++){
            System.out.println(trueUserOptions.get(i));
        }
        System.out.println("------reRollDices------");
        for(int i = 0; i < reRollDices.size(); i++){
            System.out.println(reRollDices.get(i));
        }
    }

    public void setTrueUserOptions(ArrayList<String> trueUserOptions) {
        this.trueUserOptions = trueUserOptions;
    }

    public void setReRollDices(ArrayList<String> reRollDices) {
        this.reRollDices = reRollDices;
    }
}
