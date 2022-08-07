package edu.duke.summer.client.algorithm.absyn;

import edu.duke.summer.client.algorithm.StateInfo;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.VarEntry;
import edu.duke.summer.client.algorithm.value.StringValue;
import edu.duke.summer.client.algorithm.value.Value;

import java.util.HashMap;
import java.util.Random;

import static edu.duke.summer.client.algorithm.absyn.SingleRollExp.trimFirstAndLastChar;

public class StringExp extends Exp {
   public String value;
   public StringExp(int p, String v) {pos=p; value=trimFirstAndLastChar(v, "\"");;}

   @Override
   public Value eval(VarEntry varEntry, Random randNumGen, RuleInfo info, StateInfo state) {
      return new StringValue(value);
   }
}
