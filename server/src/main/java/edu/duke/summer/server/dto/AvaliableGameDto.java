package edu.duke.summer.server.dto;

public class AvaliableGameDto {
    private String gameName;
    private String gameID;
    private Integer NumOfPlayer;
    private Integer CurrNumOfPlayer;
    private String creator;

    public AvaliableGameDto() {}

    public AvaliableGameDto(String gameName, String gameID, Integer numOfPlayer, Integer currNumOfPlayer, String creator) {
        this.gameName = gameName;
        this.gameID = gameID;
        NumOfPlayer = numOfPlayer;
        CurrNumOfPlayer = currNumOfPlayer;
        this.creator = creator;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public Integer getNumOfPlayer() {
        return NumOfPlayer;
    }

    public void setNumOfPlayer(Integer numOfPlayer) {
        NumOfPlayer = numOfPlayer;
    }

    public Integer getCurrNumOfPlayer() {
        return CurrNumOfPlayer;
    }

    public void setCurrNumOfPlayer(Integer currNumOfPlayer) {
        CurrNumOfPlayer = currNumOfPlayer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
