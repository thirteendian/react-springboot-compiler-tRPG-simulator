package edu.duke.summer.server.dto.Response;

import edu.duke.summer.server.dto.AvaliableGameDto;

import java.util.List;

public class GetAllJoinedGameResponseDto {
    List<AvaliableGameDto> listOfGame;

    public List<AvaliableGameDto> getListOfGame() {
        return listOfGame;
    }

    public void setListOfGame(List<AvaliableGameDto> listOfGame) {
        this.listOfGame = listOfGame;
    }
}
