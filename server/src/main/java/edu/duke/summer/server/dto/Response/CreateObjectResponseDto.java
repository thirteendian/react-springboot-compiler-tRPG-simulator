package edu.duke.summer.server.dto.Response;

import java.util.List;

public class CreateObjectResponseDto {

    // string of list of JSON object
    // [
    // ...
    // {uuid, name, value}
    // ...
    // ]
    public String myObjectList;

    public String getMyObjectList() {
        return myObjectList;
    }

    public void setMyObjectList(String myObjectList) {
        this.myObjectList = myObjectList;
    }

    public CreateObjectResponseDto() {}

    public CreateObjectResponseDto(String myObjectList) {
        this.myObjectList = myObjectList;
    }

    @Override
    public String toString() {
        return "CreateObjectResponseDto{" +
                "myObjectList='" + myObjectList + '\'' +
                '}';
    }
}
