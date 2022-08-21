package edu.duke.summer.server.dto.Request;

public class GetAllPlayersRequestDto {

    public String gameId;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GetAllPlayersRequestDto() {}

    public GetAllPlayersRequestDto(String gameId) {
        this.gameId = gameId;
    }
}
