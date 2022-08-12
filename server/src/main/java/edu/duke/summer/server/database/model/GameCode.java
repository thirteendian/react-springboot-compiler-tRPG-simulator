package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "gameCode")
public class GameCode implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    @Lob
    private String code;

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public GameCode() {}

    public GameCode(String gameId, String code) {
        this.gameId = gameId;
        this.code = code;
    }

    @Override
    public String toString() {
        return "GameCode{" +
                "gameId=" + gameId +
                ", code='" + code + '\'' +
                '}';
    }
}
