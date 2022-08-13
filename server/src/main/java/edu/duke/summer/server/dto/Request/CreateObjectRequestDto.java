package edu.duke.summer.server.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

public class CreateObjectRequestDto {

    @NotNull
    private String gameId;

    @NotNull
    private String playerUuid;

    @NotNull
    private String objectName;

    @NotNull
    // JSON object
    private String objectValue;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(String objectValue) {
        this.objectValue = objectValue;
    }

    public CreateObjectRequestDto() {}

    public CreateObjectRequestDto(String gameId, String playerUuid, String objectName, String objectValue) {
        this.gameId = gameId;
        this.playerUuid = playerUuid;
        this.objectName = objectName;
        this.objectValue = objectValue;
    }

    @Override
    public String toString() {
        return "CreateObjectRequestDto{" +
                "gameId='" + gameId + '\'' +
                ", playerUuid='" + playerUuid + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectValue='" + objectValue + '\'' +
                '}';
    }
}

