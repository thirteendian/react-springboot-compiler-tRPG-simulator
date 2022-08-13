package edu.duke.summer.server.dto.Object;

import javax.validation.constraints.NotNull;

public class ObjectFieldDto {

    @NotNull
    private String id;

    @NotNull
    private String fieldName;

    @NotNull
    private ObjectFieldTypeDto objectFieldTypeDto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ObjectFieldTypeDto getObjectFieldTypeDto() {
        return objectFieldTypeDto;
    }

    public void setObjectFieldTypeDto(ObjectFieldTypeDto objectFieldTypeDto) {
        this.objectFieldTypeDto = objectFieldTypeDto;
    }

    public ObjectFieldDto() {}

    public ObjectFieldDto(String id, String fieldName, ObjectFieldTypeDto objectFieldTypeDto) {
        this.id = id;
        this.fieldName = fieldName;
        this.objectFieldTypeDto = objectFieldTypeDto;
    }

    @Override
    public String toString() {
        return "ObjectFieldDto{" +
                "id='" + id + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", objectFieldTypeDto=" + objectFieldTypeDto +
                '}';
    }
}
