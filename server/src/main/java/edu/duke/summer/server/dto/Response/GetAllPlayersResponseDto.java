package edu.duke.summer.server.dto.Response;

import java.util.List;

public class GetAllPlayersResponseDto {

    public List<String> playerList;

    public List<String> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<String> playerList) {
        this.playerList = playerList;
    }

    public GetAllPlayersResponseDto() {}

    public GetAllPlayersResponseDto(List<String> playerList) {
        this.playerList = playerList;
    }
}
