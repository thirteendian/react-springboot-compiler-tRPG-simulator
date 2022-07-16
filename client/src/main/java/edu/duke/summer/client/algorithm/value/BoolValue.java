package edu.duke.summer.client.algorithm.value;

public class BoolValue extends Value {
    Boolean value;

    public BoolValue(Boolean input){
        this.value = input;
    }

    public Boolean getValue() {
        return value;
    }
}
