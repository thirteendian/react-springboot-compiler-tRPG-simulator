package edu.duke.summer.server.dto;

public class FunctionOneRollDto {

    private String id;

    private int value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public FunctionOneRollDto() {}

    public FunctionOneRollDto(String id, int value) {
        this.id = id;
        this.value = value;
    }
}
