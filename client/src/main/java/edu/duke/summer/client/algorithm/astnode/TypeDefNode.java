package edu.duke.summer.client.algorithm.astnode;

import java.util.HashMap;
import java.util.Random;

public class TypeDefNode extends ExpNode {
    String typeId;
    HashMap<String, String> typeFields;

    public void setTypeFields(HashMap<String, String> typeFields) {
        this.typeFields = typeFields;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public HashMap<String, String> getTypeFields() {
        return typeFields;
    }

    public void assignType(TypeDefNode node){
        this.typeFields = node.getTypeFields();
    }

    @Override
    public Integer eval(HashMap<String, Integer> vars, Random randNumGen) {
        return null;
    }

    @Override
    public void save(RuleInfo info) {
        info.addTypes(this);
    }

    public void printTypeInfo(){
        System.out.println("Type " + this.typeId + ":");
        for(Object obj : this.typeFields.keySet()){
            Object value = this.typeFields.get(obj);
            System.out.println(obj + "," + value);
        }
    }

    public boolean checkSameType(TypeDefNode node){
        if (!node.getTypeId().equals(this.typeId)){
            return false;
        }else if (node.getTypeFields().size() != this.typeFields.size()) {
            return false;
        }else{
            HashMap<String, String> nodeFields = node.getTypeFields();
            for(String typeId : this.typeFields.keySet()){
                if(!nodeFields.containsKey(typeId)){
                    return false;
                }
                String fieldType = this.typeFields.get(typeId);
                if(!nodeFields.containsValue(fieldType)){
                    return false;
                }
            }
            return true;
        }
    }
}
