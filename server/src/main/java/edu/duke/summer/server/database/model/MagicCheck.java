package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.lang.*;

@Entity
@Table(name = "magicCheck")
public class MagicCheck {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String player;

    @Column(nullable = false)
    private String data;

    public String getId() {return id;}

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setPlayer(String player) {this.player = player;}

    public String getPlayer() {return player;}

    public void setData(String data) {this.data = data;}

    public String getData() {return data;}

    public MagicCheck() {}

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(getClass())) {
            MagicCheck magicCheck = (MagicCheck) obj;
            return this.id.equals(magicCheck.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "DiceRolling{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", player='" + player + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
