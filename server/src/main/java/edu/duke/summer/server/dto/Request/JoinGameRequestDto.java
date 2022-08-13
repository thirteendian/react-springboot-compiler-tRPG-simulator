package edu.duke.summer.server.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.Column;

public class JoinGameRequestDto {

    @NotNull
    private String gameId;

    @NotNull
    private String playerUuid;

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

    public JoinGameRequestDto() {}

    public JoinGameRequestDto(String gameId, String playerUuid) {
        this.gameId = gameId;
        this.playerUuid = playerUuid;
    }

    @Override
    public String toString() {
        return "JoinGameRequestDto{" +
                "gameId='" + gameId + '\'' +
                ", playerUuid='" + playerUuid + '\'' +
                '}';
    }
}


