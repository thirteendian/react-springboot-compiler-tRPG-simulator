package edu.duke.summer.server.dto;

import javax.persistence.*;

import java.util.*;

public class DiceRollingDto {

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String player;

    @Column(nullable = false)
    private String rawData;

    @Column(nullable = false)
    private List<String> visibles;

    @Column(nullable = false)
    private Boolean magicCheck;

    public DiceRollingDto() {}

    public DiceRollingDto(String game, String player, String rawData, List<String> visibles, Boolean magicCheck) {
        this.game = game;
        this.player = player;
        this.rawData = rawData;
        this.visibles = visibles;
        this.magicCheck = magicCheck;
    }

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setPlayer(String player) {this.player = player;}

    public String getPlayer() {return player;}

    public void setRawData(String rawData) {this.rawData = rawData;}

    public String getRawData() {return rawData;}

    public void setVisibles(List<String> visibles) {this.visibles = visibles;}

    public List<String> getVisibles() {return visibles;}

    public void setMagicCheck(Boolean magicCheck) {this.magicCheck = magicCheck;}

    public Boolean getMagicCheck() {return magicCheck;}

    @Override
    public String toString() {
        return "DiceRolling{" +
                ", game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", rawData='" + rawData + '\'' +
                ", visibles='" + visibles + '\'' +
                ", magicCheck='" + magicCheck + '\'' +
                '}';
    }
}
