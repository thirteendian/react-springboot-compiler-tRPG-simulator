package edu.duke.summer.server.stomp;

public class SingleMessage {
    private String message;

    public SingleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
