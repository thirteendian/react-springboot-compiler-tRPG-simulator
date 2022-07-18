package edu.duke.summer.client.algorithm;

import edu.duke.summer.client.algorithm.Symbol.Symbol;
import edu.duke.summer.client.algorithm.absyn.*;

import java.util.HashMap;
import java.util.Map;

public class TypeInfo {
    String typeId;
    Ty ty;

    HashMap<String, String> typeFields;


    public TypeInfo(Symbol primType){
        String str = primType.toString();
        typeId = str;
        Ty type;
        if(str.equals("int") || str.equals("string")){
            type = new PrimTy(-1, primType, Symbol.symbol("prim"));
        }else if(str.equals("boolean")){
            type = new BooleanTy(-1, primType, Symbol.symbol("boolean"));
        }else{
            throw new IllegalArgumentException("Invalid basic type used in TypeInfo!");
        }
        ty = type;
    }

    public TypeInfo(String id, Ty t, RuleInfo info){
        typeId = id;
        if(t instanceof FieldsTy){
            typeFields = ((FieldsTy) t).getFields(info);
        }
        ty = t;
    }

    public TypeInfo(String id, TypeInfo info){
        typeId = id;
        Ty type = info.getTy();
        System.out.println(type.toString());
        ty = info.getTy();
        typeFields = info.getTypeFields();
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setTypeFields(HashMap<String, String> typeFields) {
        this.typeFields = typeFields;
    }

    public void setTy(Ty ty) {
        this.ty = ty;
    }

    public Ty getTy() {
        return ty;
    }

    public String getTypeId() {
        return typeId;
    }

    public HashMap<String, String> getTypeFields() {
        return typeFields;
    }

    public void printInfo(){
        System.out.println("-------typeId:" + typeId + "-------" );
        if(!typeFields.isEmpty()){
            for (Map.Entry<String, String> entry: typeFields.entrySet()){
                System.out.println(entry.getKey() +":" +  entry.getValue());
            }
        }else if (ty instanceof ArrayTy){
            System.out.println(((ArrayTy) ty).getName());
        }else if (ty instanceof OptionTy){
            System.out.println(((OptionTy) ty).getName());
        }
    }

    public void printTyInfo(){
        System.out.println("-------typeId:" + typeId + "-------" );
        if(ty != null){
            if(ty instanceof FieldsTy){
                ((FieldsTy)ty).printInfo();
            }
        }

    }
}
