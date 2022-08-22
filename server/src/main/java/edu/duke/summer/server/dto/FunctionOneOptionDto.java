package edu.duke.summer.server.dto;

import edu.duke.summer.server.algorithm.UserOptionInfo;

public class FunctionOneOptionDto {

    private String id;

    private String gameId;

    private String objectId;

    private String promptMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPromptMsg() {
        return promptMsg;
    }

    public void setPromptMsg(String promptMsg) {
        this.promptMsg = promptMsg;
    }

    public FunctionOneOptionDto() {}

    public FunctionOneOptionDto(String id, String gameId, String objectId, String promptMsg) {
        this.id = id;
        this.gameId = gameId;
        this.objectId = objectId;
        this.promptMsg = promptMsg;
    }

    @Override
    public String toString() {
        return "FunctionOneOptionDto{" +
                "id='" + id + '\'' +
                ", gameId='" + gameId + '\'' +
                ", objectId='" + objectId + '\'' +
                ", promptMsg='" + promptMsg + '\'' +
                '}';
    }
}
