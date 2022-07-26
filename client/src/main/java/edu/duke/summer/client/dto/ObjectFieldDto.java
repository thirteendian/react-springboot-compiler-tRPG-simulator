package edu.duke.summer.client.dto;

import edu.duke.summer.client.database.model.ObjectField;

import javax.persistence.*;
import java.util.*;

public class ObjectFieldDto {

    @Column(nullable = false)
    private String typeName;

    @Column(nullable = false)
    private List<String> objectField;

    @Column(nullable = false)
    private HashMap<String, ObjectFieldTypeDto> fieldType;

    @Column
    private HashMap<String, List<String>> objectIdList;

    public ObjectFieldDto() {
        this.objectField = new ArrayList<>();
        this.fieldType = new HashMap<>();
        this.objectIdList = new HashMap<>();
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void addObjectField(String field) {
        objectField.add(field);
    }

    public List<String> getObjectField() {
        return objectField;
    }

    public void addFieldType(String field, ObjectFieldTypeDto objectFieldTypeDto) {
        fieldType.put(field, objectFieldTypeDto);
    }

    public HashMap<String, ObjectFieldTypeDto> getFieldType() {
        return fieldType;
    }


    public void addObjectIdList(String typeName, List<String> idList) {
        objectIdList.put(typeName, idList);
    }

    public HashMap<String, List<String>> getObjectIdList() {
        return objectIdList;
    }

    @Override
    public String toString() {
        return "DiceRolling{" +
                "typeName='" + typeName + '\'' +
                ", objectField='" + objectField + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", objectIdList='" + objectIdList + '\'' +
                '}';
    }

}
