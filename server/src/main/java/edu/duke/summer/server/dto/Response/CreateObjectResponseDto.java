package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.database.model.ObjectValue;

import java.util.List;

public class CreateObjectResponseDto {

    // string of list of JSON object
    // [
    // ...
    // {uuid, name, value}
    // ...
    // ]
    private List<ObjectValue> objectList;

    public CreateObjectResponseDto(List<ObjectValue> objectList) {
        this.objectList = objectList;
    }

    public List<ObjectValue> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<ObjectValue> objectList) {
        this.objectList = objectList;
    }
    //
}
