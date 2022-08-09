
package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.absyn.Absyn;
import edu.duke.summer.server.algorithm.absyn.Exp;
import edu.duke.summer.server.algorithm.value.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


//refer to The Definitive ANTLR 4 Reference
public class EvalServicempl implements EvalService{

    public Absyn buildAstVisitor(String userInput){
        ANTLRInputStream input = new ANTLRInputStream(userInput);
        inputLexer lexer = new inputLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        inputParser parser = new inputParser(tokenStream);
        inputParser.ProgContext context = parser.prog();
        return new BuildASTVisitor().visitProg(context);
    }

    @Override
    public Value evalRoll(String rollStr, HashMap<String, Value> vars, Random randNumGen){
        Exp node = (Exp)buildAstVisitor(rollStr);
        RuleInfo info = new RuleInfo();
        StateInfo state = new StateInfo();
        VarEntry varEntry = new VarEntry();
        for(Map.Entry<String, Value> entry : vars.entrySet()){
            varEntry.addVar(state.getBlockId(),entry.getKey(), entry.getValue());
        }
        Value nodeValue = node.eval(varEntry, randNumGen,info,state);
        if(nodeValue instanceof IntValue) {
            int result = ((IntValue) nodeValue).getValue();
            System.out.println(result);
            return new IntValue(result);
        }else{
            throw new IllegalArgumentException(" Require Integer type for evalRoll interface!");
        }
    }
    @Override
    public RuleInfo saveRules(String ruleStr){
        RuleInfo info = new RuleInfo();
        StateInfo state = new StateInfo();
        VarEntry varEntry = new VarEntry();
        Absyn node = buildAstVisitor(ruleStr);
        node.eval(varEntry, new Random(), info, state);
        return info;
    }

    @Override
    public FuncCallResult getFunResult(String ruleStr, String funcName, HashMap<String, Value> params, StateInfo state) {
        RuleInfo ruleInfo = saveRules(ruleStr);
        return ruleInfo.getFuncs().get(funcName).getResult(params, state);
    }

}
