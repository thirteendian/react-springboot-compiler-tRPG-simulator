package edu.duke.summer.server.dto.Response;

import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.Column;

public class JoinGameResponseDto {

    @NotNull
    private String gameName;

    @NotNull
    private int playerNum;

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

    public JoinGameResponseDto() {}

    public JoinGameResponseDto(String gameName, int playerNum) {
        this.gameName = gameName;
        this.playerNum = playerNum;
    }
}
