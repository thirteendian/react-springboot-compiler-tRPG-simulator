package edu.duke.summer.server.dto.Request;

public class GetAllAvailableGameForJoinRequestDto {

    public String playerId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public GetAllAvailableGameForJoinRequestDto() {}

    public GetAllAvailableGameForJoinRequestDto(String playerId) {
        this.playerId = playerId;
    }
}
