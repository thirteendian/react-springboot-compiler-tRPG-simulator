package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.RuleInfo;

import java.util.HashMap;

public interface EvalService {

    /*
     *evaluate dice rolling string such as '3d20 + 3', 'invisible?d30+2:d30+1'
     *@param rollStr is the dice rolling string
     *@param vars contains the value of the variables included in the dice rolling string such as {'invisible':0}
     *@param randNumGen provides a random generator such as new Random().
     *@return the value of the dice rolling string
     */
    Integer EvalRoll(String rollStr, HashMap<String, Integer> vars, java.util.Random randNumGen);

    /*
     *save rule info
     *@param ruleStr is the complete user input represented by a string
     *@return the info contained in the ruleStr
     */
    RuleInfo SaveRules(String ruleStr);
}
