package edu.duke.summer.server.payload.request;

public class GameCreateRequest {
private String gamename;
private String numplayer;

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public String getNumplayer() {
        return numplayer;
    }

    public void setNumplayer(String numplayer) {
        this.numplayer = numplayer;
    }
}
