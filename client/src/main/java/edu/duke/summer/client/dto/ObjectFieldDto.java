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
    private HashMap<String, String> fieldType;

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

    public void addFieldType(String field, String type) {
        fieldType.put(field, type);
    }

    public HashMap<String, String> getFieldType() {
        return fieldType;
    }

    public ObjectFieldDto() {
        objectField = new ArrayList<>();
        fieldType = new HashMap<>();
    }

    @Override
    public String toString() {
        return "DiceRolling{" +
                ", typeName='" + typeName + '\'' +
                ", objectField='" + objectField + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }

}
