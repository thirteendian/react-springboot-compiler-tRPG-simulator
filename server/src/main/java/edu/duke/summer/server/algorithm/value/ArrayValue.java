package edu.duke.summer.server.algorithm.value;

import java.util.ArrayList;

public class ArrayValue extends Value{
    ArrayList<Value> list;
    public ArrayValue(ArrayList<Value> input) {
        list = new ArrayList<>(input);
    }

    public ArrayList<Value> getList() {
        return list;
    }
}
