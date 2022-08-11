package edu.duke.summer.server.algorithm.value;

public class BooleanValue extends Value {
    Boolean value;

    public BooleanValue(){
        Value val = getInitValue();
        value = ((BooleanValue)val).getValue();}

    public BooleanValue(Boolean input){
        this.value = input;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String getTypeName() {
        return "Boolean";
    }

    @Override
    public Value getInitValue() {
        return new BooleanValue(false);
    }

    @Override
    public String getPrintInfo() {
        if(value.equals(false)) return "false";
        else if (value.equals(true)) return "true";
        return null;
    }
}
