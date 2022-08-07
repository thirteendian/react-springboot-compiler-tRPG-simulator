package edu.duke.summer.server.algorithm;

import edu.duke.summer.server.algorithm.Symbol.Symbol;

import java.util.HashMap;

public class RuleInfo {
    HashMap<String, TypeInfo> types = new HashMap<>();

    public RuleInfo(){
        TypeInfo i = new TypeInfo(Symbol.symbol("int"));
        TypeInfo s = new TypeInfo(Symbol.symbol("string"));
        TypeInfo b = new TypeInfo(Symbol.symbol("boolean"));
        types.put("int", i);
        types.put("string", s);
        types.put("boolean", b);
    }
    public void setTypes(HashMap<String, TypeInfo> types) {
        this.types = types;
    }

    public HashMap<String, TypeInfo> getTypes() {
        return types;
    }

    public void addTypes(TypeInfo newType){
        types.put(newType.getTypeId().toString(), newType);
    }

    public void printInfo(){
        System.out.println("-------printInfo-------");
        for(String s : types.keySet()){
            TypeInfo info = types.get(s);
            info.printTyInfo();
        }
    }
}
