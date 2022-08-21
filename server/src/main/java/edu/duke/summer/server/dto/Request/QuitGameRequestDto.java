package edu.duke.summer.server.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

public class QuitGameRequestDto {
    @NotNull
    private String gameId;

    @NotNull
    private String playerUuid;

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }
}
