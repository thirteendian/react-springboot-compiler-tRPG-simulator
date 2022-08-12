package edu.duke.summer.server.algorithm.value;

public class IntValue extends Value{
    Integer value;
    public IntValue (){
        Value val = getInitValue();
        value = ((IntValue)val).getValue();
    }
    public IntValue (Integer input){
        this.value = input;
    }
    public Integer getValue(){
        return value;
    }

    @Override
    public String getTypeName() {
        return "Int";
    }

    @Override
    public Value getInitValue() {
        return new IntValue(0);
    }

    @Override
    public String getPrintInfo() {
        return value.toString();
    }
}
