package edu.duke.summer.server.dto.Response;

import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.*;

public class CreateGameResponseDto {

    @NotNull
    public String gameId;

    @NotNull
    private String gameName;

    @NotNull
    private int playerNum;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public CreateGameResponseDto() {}

    public CreateGameResponseDto(String gameId, String gameName, int playerNum) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.playerNum = playerNum;
    }

    @Override
    public String toString() {
        return "CreateGameResponseDto{" +
                "gameId='" + gameId + '\'' +
                ", gameName='" + gameName + '\'' +
                ", playerNum=" + playerNum +
                '}';
    }
}
