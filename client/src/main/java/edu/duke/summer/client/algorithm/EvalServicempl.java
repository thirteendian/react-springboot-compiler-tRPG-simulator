package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.ExpNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;


//refer to The Definitive ANTLR 4 Reference
public class EvalServicempl implements EvalService{

    @Override
    public Integer EvalRoll(String rollStr, HashMap<String, Integer> vars, Random randNumGen) {
        ANTLRInputStream input = new ANTLRInputStream(rollStr);
        inputLexer lexer = new inputLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        inputParser parser = new inputParser(tokenStream);
        inputParser.ProgContext context = parser.prog();
        ExpNode node = new BuildAstVisitor().visitProg(context);
        //int result = new EvalExpVisitor().Visit(node);
        int result =  node.eval(vars, randNumGen);
        return result;
    }
}