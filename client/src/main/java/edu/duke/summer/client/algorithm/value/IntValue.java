package edu.duke.summer.client.algorithm.value;

public class IntValue extends Value{
    Integer value;
    public IntValue (Integer input){
        this.value = input;
    }
    public Integer getValue(){
        return value;
    }
}
