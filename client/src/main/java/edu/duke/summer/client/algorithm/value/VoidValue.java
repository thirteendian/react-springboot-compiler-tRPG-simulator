package edu.duke.summer.client.algorithm.value;

public class VoidValue extends Value{
    @Override
    public String getTypeName() {
        return "Void";
    }
    @Override
    public Value getInitValue() {
        return new VoidValue();
    }

    @Override
    public String getPrintInfo() {
        return "Void";
    }
}
