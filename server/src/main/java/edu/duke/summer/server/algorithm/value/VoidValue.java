package edu.duke.summer.server.algorithm.value;

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
