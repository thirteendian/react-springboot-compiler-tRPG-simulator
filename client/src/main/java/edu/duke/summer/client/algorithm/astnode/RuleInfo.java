package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;

public class RuleInfo {
    /* Mapping TypeId to TypeDefNode, which includes typeId and typeFields */
    HashMap<String, TypeDefNode> types = new HashMap<>();

    public void setTypes(HashMap<String, TypeDefNode> types) {
        this.types = types;
    }

    public HashMap<String, TypeDefNode> getTypes() {
        return types;
    }

    public void addTypes(TypeDefNode newType){
        types.put(newType.getTypeId(), newType);
    }

    public void printInfo(){
        for(TypeDefNode node : types.values()){
            node.printTypeInfo();
        }
    }
}
