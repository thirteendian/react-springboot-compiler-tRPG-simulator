package edu.duke.summer.server.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.Column;

public class GameStartRequestDto {

    @NotNull
    public String gameId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GameStartRequestDto() {}

    public GameStartRequestDto(String gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "GameStartRequestDto{" +
                "gameId='" + gameId + '\'' +
                '}';
    }
}

