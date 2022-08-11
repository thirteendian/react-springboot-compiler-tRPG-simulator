package edu.duke.summer.server.dto;

import javax.validation.constraints.NotNull;

public class FieldValueDto {

    @NotNull
    private String objectValueId;

    @NotNull
    private String fieldType;

    @NotNull
    private String value;

    private String arrayListRelationship;

    public String getObjectValueId() {
        return objectValueId;
    }

    public void setObjectValueId(String objectValueId) {
        this.objectValueId = objectValueId;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getArrayListRelationship() {
        return arrayListRelationship;
    }

    public void setArrayListRelationship(String arrayListRelationship) {
        this.arrayListRelationship = arrayListRelationship;
    }

    public FieldValueDto() {}

    public FieldValueDto(String objectValueId, String fieldType, String value, String arrayListRelationship) {
        this.objectValueId = objectValueId;
        this.fieldType = fieldType;
        this.value = value;
        this.arrayListRelationship = arrayListRelationship;
    }
}
