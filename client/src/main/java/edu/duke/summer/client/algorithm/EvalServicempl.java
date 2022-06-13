package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.ExpNode;
import edu.duke.summer.client.algorithm.astnode.RuleInfo;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


//refer to The Definitive ANTLR 4 Reference
public class EvalServicempl implements EvalService{

    public ExpNode buildAstVisitor(String userInput){
        ANTLRInputStream input = new ANTLRInputStream(userInput);
        inputLexer lexer = new inputLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        inputParser parser = new inputParser(tokenStream);
        inputParser.ProgContext context = parser.prog();
        return new BuildAstVisitor().visitProg(context);
    }
    @Override
    public Integer EvalRoll(String rollStr, HashMap<String, Integer> vars, java.util.Random randNumGen){
        ExpNode node = buildAstVisitor(rollStr);
        int result =  node.eval(vars, randNumGen);
        System.out.println(result);
        return result;
    }
    @Override
    public RuleInfo SaveRules(String ruleStr){
        String[] subStr;
        RuleInfo info = new RuleInfo();
        String subRuleStr = ruleStr.substring(1, ruleStr.length() - 1);
        subStr = subRuleStr.split(";");
        for(int i = 0; i < subStr.length - 1; i++){
            ExpNode node = buildAstVisitor(subStr[i]);
            node.save(info);
        }
        info.printInfo();
        return info;
    }

}