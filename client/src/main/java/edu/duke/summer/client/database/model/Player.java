package edu.duke.summer.client.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.lang.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String userId;

    public Player() {}

    public Player(String game, String userId) {
        this.game = game;
        this.userId = userId;
    }


    public String getId() {
        return id;
    }

    public String getGame() { return game; }

    public void setGame(String game) { this.game = game; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", user='" + userId + '\'' +
                '}';
    }
}
