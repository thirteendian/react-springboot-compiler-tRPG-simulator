package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.astnode.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EvalServicemplTest {

    @Test
    void EvalRoll() {
        EvalServicempl input = new EvalServicempl();
        HashMap vars = new HashMap<String, Integer>();
        Random randGen = mock(Random.class);
        when(randGen.nextInt(10)).thenReturn(1);
        when(randGen.nextInt(12)).thenReturn(10);
        vars.put("invisible", 0);
        vars.put("test", 1);
        assertEquals(14, input.EvalRoll("(1 + invisible?0:1 + d10 * 6)", vars, randGen));
        assertEquals(13, input.EvalRoll("(1 + test?0:1 + d10 * 6)", vars, randGen));
        assertEquals(67, input.EvalRoll("(1 + 2d12 * 6)", vars, randGen));
        assertEquals(194, input.EvalRoll("(1 + invisible?0:1 + 32 * 6)", vars, new Random()));
        assertEquals(1, input.EvalRoll("(1 - invisible?0:1 + 6 / 6)", vars, new Random()));
        assertThrows(IllegalArgumentException.class, ()->input.EvalRoll("(1 - notexist?0:1 + 6 / 6)", vars, new Random()));

    }

    @Test
    void SaveRules(){
        EvalServicempl input = new EvalServicempl();
        TypeDefNode type1 = new TypeDefNode();
        TypeDefNode type2 = new TypeDefNode();
        HashMap<String, String> typeFields = new HashMap<>();
        typeFields.put("numdice", "string");
        typeFields.put("numsides", "option of int");
        typeFields.put("modifier", "array of array of option of int");
        typeFields.put("array", "array of int");
        type1.setTypeFields(typeFields);
        type1.setTypeId("rollwithmod");
        type2.setTypeFields(typeFields);
        type2.setTypeId("test");
        HashMap<String, TypeDefNode> types = new HashMap<>();
        types.put("rollwithmod", type1);
        types.put("test", type2);
        RuleInfo realRes = input.SaveRules("{type rollwithmod {  \n" +
                "   numdice:string,\n" +
                "   numsides:option of int,\n" +
                "   modifier:array of array of option of int,\n" +
                "   array:array of int\n" +
                "}\n" +
                "; type test = rollwithmod; }");
        HashMap<String, TypeDefNode> realTypes = realRes.getTypes();
        for(String str : realTypes.keySet()){
            TypeDefNode value = realTypes.get(str);
            assertEquals(true, value.checkSameType(types.get(str)));
        }
        AssignTypeNode node = new AssignTypeNode("testType","notExist");
        assertThrows(IllegalArgumentException.class, ()->node.save(realRes));
    }

    @Test
    void testAssign(){
        EvalServicempl input = new EvalServicempl();
        HashMap vars = new HashMap<String, Integer>();
        vars.put("invisible", 0);
        AssignTypeNode node = new AssignTypeNode("testType","notExist");
        assertEquals(null, node.eval(vars, new Random()));

    }
}