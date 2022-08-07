package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.absyn.*;

import java.util.HashMap;
import java.util.Map;

public class TypeInfo {
    String typeId;
    FieldList fields; //Ty tree
    HashMap<String, String> typeFields; //string

    public FieldList getFields() {
        return fields;
    }

    public TypeInfo(Symbol primType){
        String str = primType.toString();
        typeId = str;
        Ty type;
        if(str.equals("int") || str.equals("string")){
            type = new PrimTy(-1, primType, Symbol.symbol("prim"));
            fields = new FieldList(-1, Symbol.symbol(str), Symbol.symbol(str), type, null);
        }else if(str.equals("boolean")){
            type = new BooleanTy(-1, primType, Symbol.symbol("boolean"));
            fields = new FieldList(-1, Symbol.symbol(str), Symbol.symbol(str), type, null);
        }else if(str.equals("void")) {
            type = new BooleanTy(-1, primType, Symbol.symbol("void"));
            fields = new FieldList(-1, Symbol.symbol(str), Symbol.symbol(str), type, null);
        }else{
                throw new IllegalArgumentException("Invalid basic type used in TypeInfo!");
            }
        }

    public TypeInfo(String id, Ty t, RuleInfo info){
        typeId = id;
        if(t instanceof FieldsTy){
            typeFields = ((FieldsTy) t).getFieldsNameStr(info);
            fields = ((FieldsTy) t).getFields();
        }
    }

    public TypeInfo(String id, TypeInfo info){
        typeId = id;
        fields = info.getFields();
        typeFields = info.getTypeFields();
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setTypeFields(HashMap<String, String> typeFields) {
        this.typeFields = typeFields;
    }


    public String getTypeId() {
        return typeId;
    }

    public HashMap<String, String> getTypeFields() {
        return typeFields;
    }

    public void printStrInfo(){
        System.out.println("-------typeId:" + typeId + "-------" );
        if(!typeFields.isEmpty()){
            for (Map.Entry<String, String> entry: typeFields.entrySet()){
                System.out.println(entry.getKey() +":" +  entry.getValue());
            }
        }
    }

    public void printTyInfo(){
        System.out.println("-------typeId:" + typeId + "-------" );
        if(fields != null){
            fields.printInfo();
        }
    }
}
