package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.lang.*;

@Entity
@Table(name = "players")
public class Player {
    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String userId;

    public Player() {}

    public Player(String gameId, String userId) {
        this.gameId = gameId;
        this.userId = userId;
    }


    public String getId() {
        return id;
    }

    public String getGameId() { return gameId; }

    public void setGameId(String gameId) { this.gameId = gameId; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", game='" + gameId + '\'' +
                ", user='" + userId + '\'' +
                '}';
    }
}
