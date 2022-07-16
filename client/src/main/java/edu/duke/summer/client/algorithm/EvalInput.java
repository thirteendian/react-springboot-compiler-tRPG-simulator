package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.absyn.Absyn;
import edu.duke.summer.client.algorithm.absyn.Exp;
import edu.duke.summer.client.algorithm.value.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


//refer to The Definitive ANTLR 4 Reference
public class EvalInput {
    public Absyn buildAstVisitor(String userInput){
        ANTLRInputStream input = new ANTLRInputStream(userInput);
        inputLexer lexer = new inputLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        inputParser parser = new inputParser(tokenStream);
        inputParser.ProgContext context = parser.prog();
        return new BuildASTVisitor().visitProg(context);
    }
    public int evalRoll(String rollStr, HashMap<String, Integer> vars, Random randNumGen){
        Exp node = (Exp)buildAstVisitor(rollStr);
        RuleInfo info = new RuleInfo();
        RollState state = new RollState();
        HashMap<String, Value> vals = new HashMap<>();
        for(Map.Entry<String, Integer> entry : vars.entrySet()){
            vals.put(entry.getKey(), new IntValue(entry.getValue()));
        }
        Value nodeValue = node.eval(vals, randNumGen,info,state);
        if(nodeValue instanceof IntValue) {
            int result = ((IntValue) nodeValue).getValue();
            System.out.println(result);
            return result;
        }else{
            throw new IllegalArgumentException(" Require Integer type for evalRoll interface!");
        }
    }

    public RuleInfo saveRules(String ruleStr){
        RuleInfo info = new RuleInfo();
        RollState state = new RollState();
        HashMap<String, Value> VarEntry = new HashMap<String, Value>();
        Absyn node = buildAstVisitor(ruleStr);
        node.eval(VarEntry, new Random(), info, state);
        info.printInfo();
        return info;
    }

}