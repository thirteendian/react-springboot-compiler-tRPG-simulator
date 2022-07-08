package edu.duke.summer.client.stomp;

import java.util.HashMap;
import java.util.List;

public class RespObjectCreatingField {
    private List<String> objectField;
    private HashMap<String, String> fieldType;

    public RespObjectCreatingField(){}
    public RespObjectCreatingField(List<String> objectField, HashMap<String, String> fieldType) {
        this.objectField = objectField;
        this.fieldType = fieldType;
    }

    public List<String> getObjectField() {
        return objectField;
    }

    public void setObjectField(List<String> objectField) {
        this.objectField = objectField;
    }

    public HashMap<String, String> getFieldType() {
        return fieldType;
    }

    public void setFieldType(HashMap<String, String> fieldType) {
        this.fieldType = fieldType;
    }
}
