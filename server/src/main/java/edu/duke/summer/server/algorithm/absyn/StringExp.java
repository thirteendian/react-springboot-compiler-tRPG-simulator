package edu.duke.summer.server.algorithm.absyn;

import edu.duke.summer.server.algorithm.StateInfo;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.VarEntry;
import edu.duke.summer.server.algorithm.value.StringValue;
import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

import static edu.duke.summer.server.algorithm.absyn.SingleRollExp.trimFirstAndLastChar;

public class StringExp extends Exp {
   public String value;
   public StringExp(int p, String v) {pos=p; value=trimFirstAndLastChar(v, "\"");;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      return new StringValue(value);
   }
}
