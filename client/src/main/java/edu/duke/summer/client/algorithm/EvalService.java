package edu.duke.summer.client.algorithm;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;

public interface EvalService {

    /*
     *evaluate dice rolling string such as '3d20 + 3', 'invisible?d30+2:d30+1'
     *@param rollStr is the dice rolling string
     *@param vars contains the value of the variables included in the dice rolling string such as {'invisible':0}
     *@param randNumGen provides a random generator such as new Random().
     *@return the value of the dice rolling string
     */
    Value evalRoll(String rollStr, HashMap<String, Value> vars, java.util.Random randNumGen);

    /*
     *save rule info
     *@param ruleStr is the complete user input represented by a string
     *@return the info contained in the ruleStr
     */
    RuleInfo saveRules(String ruleStr);

    /*
     * get function result
     * @param ruleStr is the complete user input represented by a string
     * @param funcName is the called function name
     * @param params are the parameters needed by the function
     * @param info is the stateInfo including roll and userOption information
     * @return the info contained in the ruleStr
     */
    FuncCallResult getFunResult(String ruleStr, String funcName, HashMap<String, Value> params, StateInfo info);

}
