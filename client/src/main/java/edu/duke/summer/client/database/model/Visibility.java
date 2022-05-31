package edu.duke.summer.client.database.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "visibility")
public class Visibility {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String playerId;

    @Column(nullable = false)
    private String resultId;

    public String getId() {return id;}

    public void setGameId(String gameId) {this.gameId = gameId;}

    public String getGameId() {return gameId;}

    public void setPlayerId(String playerId) {this.playerId = playerId;}

    public String getPlayerId() {return playerId;}

    public void setResultId(String resultId) {this.resultId = resultId;}

    public String getResultId() {return resultId;}

    @Override
    public String toString() {
        return "Visibility{" +
                "id=" + id +
                ", game='" + gameId + '\'' +
                ", player='" + playerId + '\'' +
                ", result='" + resultId + '\'' +
                '}';
    }

}
