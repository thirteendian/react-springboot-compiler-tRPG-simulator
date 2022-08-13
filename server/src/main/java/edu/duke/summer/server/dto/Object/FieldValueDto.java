package edu.duke.summer.server.dto.Object;

import javax.validation.constraints.NotNull;

public class FieldValueDto {

    // uuid created from front end
    @NotNull
    private String valueId;

    // prim, boolean, array, option, user
    @NotNull
    private String fieldType;

    // if type is prim, boolean or user, value would never be null
    @NotNull
    private String value;

    // if type is the inner structure of array or option, it points to its outer structure's objectValueId
    private String relationship;

    public String getObjectValueId() {
        return valueId;
    }

    public void setObjectValueId(String objectValueId) {
        this.valueId = objectValueId;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public FieldValueDto() {}

    public FieldValueDto(String objectValueId, String fieldType, String value, String relationship) {
        this.valueId = objectValueId;
        this.fieldType = fieldType;
        this.value = value;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "FieldValueDto{" +
                "valueId='" + valueId + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", value='" + value + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}


