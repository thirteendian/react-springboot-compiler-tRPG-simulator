package edu.duke.summer.server.database.model;

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
    private String game;

    @Column(nullable = false)
    private String player;

    @Column(nullable = false)
    private String result;

    public String getId() {return id;}

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setPlayer(String player) {this.player = player;}

    public String getPlayer() {return player;}

    public void setResult(String result) {this.result = result;}

    public String getResult() {return result;}

    public Visibility() {}

    @Override
    public String toString() {
        return "Visibility{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

}
