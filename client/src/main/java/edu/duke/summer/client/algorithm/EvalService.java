package edu.duke.summer.client.algorithm;

import java.util.HashMap;

public interface EvalService {

    Integer EvalRoll(String rollStr, HashMap<String, Integer> vars, java.util.Random randNumGen);
}
