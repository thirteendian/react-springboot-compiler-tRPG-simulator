package edu.duke.summer.client.algorithm.value;

import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.TypeInfo;
import edu.duke.summer.client.algorithm.absyn.*;

import java.util.HashMap;
import java.util.Map;

public class TypeValue extends Value {
    String TypeId;
    String gameId;
    String objectId;
    FieldList list;
    HashMap<String, Value> typeFields;
    RuleInfo info;

    public String getGameId() {
        return gameId;
    }

    public String getObjectId() {
        return objectId;
    }

    public HashMap<String, Value> getTypeFields() {
        return typeFields;
    }

    public TypeValue(String Id, FieldList l, RuleInfo i){
        typeFields = new HashMap<>();
        TypeId = Id;
        list = l;
        info = i;
        String fieldName = list.name.toString();
        Value val = getVal(list.type);
        typeFields.put(fieldName, val);
        FieldList tail = list.tail;
        while(tail != null){
            fieldName = tail.name.toString();
            val = getVal(list.type);
            typeFields.put(fieldName, val);
            tail = tail.tail;
        }
    }

    public Value getVal(Ty ty){
        Value val;
        if(ty instanceof ArrayTy){
            val = new ArrayValue(((ArrayTy) ty).elem);
        }else if (ty instanceof OptionTy){
            val = new OptionValue(((OptionTy) ty).elem);
        }else if (ty instanceof BooleanTy){
            val = new BooleanValue();
        }else if (ty instanceof NameTy){
            String TypeId = ty.getName();
            TypeInfo typeinfo = info.getTypes().get(TypeId);
            FieldList list = typeinfo.getFields();
            val = new TypeValue(TypeId, list, info);
        }else if (ty instanceof PrimTy) {
            if(ty.getName().equals("int")){
                val = new IntValue();
            }else{
                val = new StringValue();
            }
        }else{
            throw new IllegalArgumentException("Invalid field type of type " + TypeId);
        }
        return val;
    }


    public void setTypeFields(HashMap<String, Value> typeFields) {
        this.typeFields = typeFields;
    }

    public void setList(FieldList list) {
        this.list = list;
    }

    public void setFieldValue(String field, Value val){
        if(typeFields.get(field) != null){
            typeFields.replace(field, val);
        }else{
            throw new IllegalArgumentException("Field " + field + " not exist in the type!");
        }
    }

    @Override
    public String getTypeName() {
        return "Type";
    }

    @Override
    public Value getInitValue() {
        return null;
    }

    @Override
    public String getPrintInfo() {
        String res = "TypeName: ";
        res += TypeId + "\n";
        for(Map.Entry<String, Value> entry : typeFields.entrySet()){
            res += "fieldName: " + entry.getKey() + "\n";
            Value value = entry.getValue();
            res += "fieldValue:" + value.getPrintInfo() + "\n";
        }
        return res;
    }

    public void printInfo(){
        for(Map.Entry<String, Value> entry : typeFields.entrySet()){
            System.out.println("fieldName: " + entry.getKey());
            Value value = entry.getValue();
            if(value instanceof IntValue){
                System.out.println(" fieldValue:" + ((IntValue) value).getValue());
            }
        }
    }
}
