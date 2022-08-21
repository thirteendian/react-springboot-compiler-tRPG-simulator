package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.AvaliableGameDto;

import java.util.List;

public class GetAllAvailableGameForJoinResponseDto {
    private List<AvaliableGameDto> listOfAvaliableGame;

    public List<AvaliableGameDto> getListOfAvaliableGame() {
        return listOfAvaliableGame;
    }

    public void setListOfAvaliableGame(List<AvaliableGameDto> listOfAvaliableGame) {
        this.listOfAvaliableGame = listOfAvaliableGame;
    }
}
