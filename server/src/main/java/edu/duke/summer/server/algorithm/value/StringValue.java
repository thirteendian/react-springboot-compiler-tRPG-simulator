package edu.duke.summer.server.algorithm.value;

public class StringValue extends Value{
    String value;
    public StringValue(String input){
        this.value = input;
    }
    public StringValue(){
        Value val = getInitValue();
        value = ((StringValue)val).getValue();
    }

    public Integer getLength(){
        return value.length();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getTypeName() {
        return "String";
    }

    @Override
    public Value getInitValue() {
        return new StringValue("");
    }

    @Override
    public String getPrintInfo() {
        return value;
    }
}
