package edu.duke.summer.server.stomp;

import edu.duke.summer.server.dto.Object.ObjectFieldTypeDto;

import java.util.HashMap;
import java.util.List;

public class RespObjectCreatingField {
    private List<String> objectField;
    private HashMap<String, ObjectFieldTypeDto> fieldType;

    public RespObjectCreatingField(){}
    public RespObjectCreatingField(List<String> objectField, HashMap<String, ObjectFieldTypeDto> fieldType) {
        this.objectField = objectField;
        this.fieldType = fieldType;
    }

    public List<String> getObjectField() {
        return objectField;
    }

    public void setObjectField(List<String> objectField) {
        this.objectField = objectField;
    }

    public HashMap<String, ObjectFieldTypeDto> getFieldType() {
        return fieldType;
    }

    public void setFieldType(HashMap<String, ObjectFieldTypeDto> fieldType) {
        this.fieldType = fieldType;
    }
}
