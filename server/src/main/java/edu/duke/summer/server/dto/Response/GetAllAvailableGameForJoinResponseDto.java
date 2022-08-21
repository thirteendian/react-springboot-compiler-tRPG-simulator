package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.AvaliableGameDto;

import java.util.List;

public class GetAllAvailableGameForJoinResponseDto {
    private List<AvaliableGameDto> listOfAvailableGame;

    public List<AvaliableGameDto> getListOfAvailableGame() {
        return listOfAvailableGame;
    }

    public void setListOfAvailableGame(List<AvaliableGameDto> listOfAvailableGame) {
        this.listOfAvailableGame = listOfAvailableGame;
    }
}
