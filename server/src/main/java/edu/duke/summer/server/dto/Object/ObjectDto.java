package edu.duke.summer.server.dto.Object;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

public class ObjectDto {

    @NotNull
    private String id;

    @NotNull
    private String objectName;

    @NotNull
    private List<ObjectFieldDto> fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<ObjectFieldDto> getFields() {
        return fields;
    }

    public void setFields(List<ObjectFieldDto> fields) {
        this.fields = fields;
    }

    public void addFields(ObjectFieldDto objectFieldDto) {
        fields.add(objectFieldDto);
    }

    public ObjectDto() {
        this.fields = new ArrayList<>();
    }

    public ObjectDto(String id, String objectName, List<ObjectFieldDto> fields) {
        this.id = id;
        this.objectName = objectName;
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "ObjectDto{" +
                "id='" + id + '\'' +
                ", objectName='" + objectName + '\'' +
                ", fields=" + fields +
                '}';
    }
}
