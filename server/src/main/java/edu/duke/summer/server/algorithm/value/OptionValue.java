package edu.duke.summer.server.algorithm.value;

import edu.duke.summer.server.algorithm.absyn.Ty;

public class OptionValue extends Value{

    Boolean bool;

    Ty type;

    Value elem;

    public OptionValue(Boolean b, Value v){
        bool = b;
        elem = v;
    }

    public OptionValue(Ty t){
        type = t;
        elem = type.getInitValue();
        bool = false;
    }

    @Override
    public String getTypeName() {
        return "Option";
    }

    @Override
    public Value getInitValue() {
        return new OptionValue(type);
    }

    @Override
    public String getPrintInfo() {
        String res = "";
        if(bool.equals(false)) return "NONE";
        else if(bool.equals(true)) {
            res += "SOME(";
            res += elem.getPrintInfo();
            res += ")";
        }
        return res;
    }
}
