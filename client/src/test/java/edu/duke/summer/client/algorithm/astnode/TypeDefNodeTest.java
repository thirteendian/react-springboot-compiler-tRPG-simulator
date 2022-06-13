package edu.duke.summer.client.algorithm.astnode;

import edu.duke.summer.client.algorithm.EvalServicempl;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TypeDefNodeTest {

    @Test
    void eval() {
        TypeDefNode node = new TypeDefNode();
        HashMap vars = new HashMap<String, Integer>();
        assertEquals(null, node.eval(vars, new Random()));
    }

    @Test
    void checkSameType() {
        EvalServicempl input = new EvalServicempl();
        TypeDefNode type1 = new TypeDefNode();
        TypeDefNode type2 = new TypeDefNode();
        HashMap typeFields = new HashMap<String, String>();
        typeFields.put("numdice", "int");
        typeFields.put("numsides", "array of int");
        typeFields.put("modifier", "option of array of int");
        type1.setTypeFields(typeFields);
        type1.setTypeId("rollwithmod");
        type2.setTypeFields(typeFields);
        type2.setTypeId("test");
        HashMap<String, TypeDefNode> types = new HashMap<>();
        types.put("rollwithmod", type1);
        types.put("test", type2);
        RuleInfo realRes = input.SaveRules("{type rollwithmod {  \n" +
                "   numdice:int,\n" +
                "   numsides:option of int,\n" +
                "   modifier:array of array of option of int\n" +
                "}\n" +
                "; type test = rollwithmod; }");
        HashMap<String, TypeDefNode> realTypes = realRes.getTypes();
        TypeDefNode testNode = new TypeDefNode();
        testNode.setTypeId("notSame");
        TypeDefNode testNode1 = new TypeDefNode();
        testNode1.setTypeId("rollwithmod");
        HashMap<String, String> typeFields1 = new HashMap<>();
        typeFields1.put("test11", "int");
        typeFields1.put("numsides1", "int");
        typeFields1.put("numsides2", "int");
        testNode1.setTypeFields(typeFields1);
        TypeDefNode notSameLen = new TypeDefNode();
        notSameLen.setTypeId("rollwithmod");
        HashMap<String, String> notSameLenFields = new HashMap<>();
        notSameLenFields.put("test11", "int");
        notSameLenFields.put("numsides1", "int");
        notSameLen.setTypeFields(notSameLenFields);
        for (String str : realTypes.keySet()) {
            TypeDefNode value = realTypes.get(str);
            assertEquals(false, value.checkSameType(types.get(str)));
            assertEquals(false, value.checkSameType(testNode));
            assertEquals(false, value.checkSameType(testNode1));
            assertEquals(false, value.checkSameType(notSameLen));
        }
    }
}