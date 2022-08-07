package edu.duke.summer.server.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EvalServicemplTest {

    @Test
    void evalRoll() {
        EvalServicempl input = new EvalServicempl();
        HashMap vars = new HashMap<String, Integer>();
        Random randGen = mock(Random.class);
        when(randGen.nextInt(10)).thenReturn(1);
        when(randGen.nextInt(12)).thenReturn(10);
        vars.put("invisible", 0);
        vars.put("test", 1);
        assertEquals(14, input.evalRoll("(1 + invisible?0:1 + d10 * 6)", vars, randGen));
        assertEquals(13, input.evalRoll("(1 + test?0:1 + d10 * 6)", vars, randGen));
        assertEquals(67, input.evalRoll("(1 + 2d12 * 6)", vars, randGen));
        assertEquals(194, input.evalRoll("(1 + invisible?0:1 + 32 * 6)", vars, new Random()));
        assertEquals(1, input.evalRoll("(1 - invisible?0:1 + 6 / 6)", vars, new Random()));
        assertThrows(IllegalArgumentException.class, ()->input.evalRoll("(1 - notexist?0:1 + 6 / 6)", vars, new Random()));

    }

    @Test
    void saveRules() {
        new EvalServicempl().saveRules("{type rollwithmod {\n" +
                                "    numdice:int,\n" +
                                "    numsides:int option option [],\n" +
                                "    modifier:int [][][] option\n" +
                                "    }\n" +
                                "type test = rollwithmod;\n" +
                                "type newType {\n" +
                                "    a:rollwithmod,\n" +
                                "    b:string option [] option,\n" +
                                "    c:boolean option []\n" +
                                "    }\n" +
                                "}");
    }
}