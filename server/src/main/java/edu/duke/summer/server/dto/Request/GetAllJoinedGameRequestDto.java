package edu.duke.summer.server.dto.Request;

public class GetAllJoinedGameRequestDto {

    public String playerId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public GetAllJoinedGameRequestDto() {}

    public GetAllJoinedGameRequestDto(String playerId) {
        this.playerId = playerId;
    }
}
