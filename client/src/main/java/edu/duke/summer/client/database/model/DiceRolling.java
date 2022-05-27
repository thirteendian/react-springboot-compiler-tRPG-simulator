package edu.duke.summer.client.database.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "diceRolling")
public class DiceRolling {
    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String result;

    @Column(nullable = false)
    private boolean visible;

    public String getId() {return id;}

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setUserEmail(String user) {this.userEmail = userEmail;}

    public String getUserEmail() {return userEmail;}

    public void setResult(String result) {this.result = result;}

    public String getResult() {return result;}

    public void setVisible(boolean visible) {this.visible = visible;}

    public boolean getVisible() {return visible;}

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(getClass())) {
            DiceRolling diceRolling = (DiceRolling) obj;
            if (this.id.equals(diceRolling.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DiceRolling{" +
                "id=" + id +
                ", game='" + game + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", result='" + result + '\'' +
                ", visible='" + visible + '\'' +
                '}';
    }
}
