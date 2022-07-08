package edu.duke.summer.client.stomp;

public class ReqObjectCreatingName {

    private String objectName;

    public ReqObjectCreatingName(){
    }
    public ReqObjectCreatingName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
