package edu.duke.summer.server.algorithm.value;

import edu.duke.summer.server.algorithm.Types.STRING;
import edu.duke.summer.server.algorithm.absyn.Ty;

import java.util.ArrayList;

public class ArrayValue extends Value{
    Ty type;
    ArrayList<Value> value;

    public Integer getLength(){
        return value.size();
    }

    public ArrayValue(Ty t) {
        type = t;
        value = new ArrayList<>();
    }
    public ArrayValue(ArrayList<Value> input) {
        value = new ArrayList<>(input);
        initCheck();
    }

    private void initCheck(){
        int size = value.size();
        String pre = "";
        if(size == 0){
            throw new IllegalArgumentException("Invalid Array declaration: Please specify the data type or initialize with a non-empty array");
        }
        if(size != 0) {
            pre = value.get(0).getTypeName();
        }
        for(int i = 1; i < size; i++){
            String curr = value.get(i).getTypeName();
            if(!curr.equals(pre)){
                throw new IllegalArgumentException("Invalid Array Value! All values in the Array should be of the same type.");
            }
        }
    }
    public ArrayList<Value> getValue() {
        return value;
    }

    public Value getElem(int index){
        Value init;
        if(value.size() == 0 && type== null){
            throw new IllegalArgumentException("Array is not initialized!");
        }else if (value.size() != 0){
            init = value.get(0).getInitValue();
        }else{
            init = type.getInitValue();
        }
        if(value.size() <= index){
            for(int i = value.size(); i <= index; i++){
                value.add(init);
            }
        }
        return value.get(index);
    }

    public void setElem(int index, Value val){
        getElem(index);
        value.set(index, val);
    }

    @Override
    public String getTypeName() {
        return "Array";
    }
    @Override
    public Value getInitValue() {
        if(value.size() != 0){
            Value init = value.get(0).getInitValue();
            ArrayList<Value> res = new ArrayList<>();
            res.add(init);
            return new ArrayValue(res);
        }else if(type != null){
            return new ArrayValue(type);
        }else{
            throw new IllegalArgumentException("Invalid Array declaration: Please specify the data type or initialize with a non-empty array");
        }
    }

    @Override
    public String getPrintInfo(){
        String res = "{ ";
        for(int i = 0; i < value.size() - 1; i++){
                res += (value.get(i).getPrintInfo()) + ",";
        }
        res += (value.get(value.size() - 1).getPrintInfo());
        res += "} ";
        return res;
    }

}
