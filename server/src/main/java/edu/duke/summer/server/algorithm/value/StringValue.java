package edu.duke.summer.server.algorithm.value;

public class StringValue extends Value{
    String value;
    public StringValue(String input){
        this.value = input;
    }

    public String getValue() {
        return value;
    }
}
