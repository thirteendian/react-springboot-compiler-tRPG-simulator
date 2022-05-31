package edu.duke.summer.client.database.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "magicCheck")
public class MagicCheck {

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String data;

    public void setId(String id) {this.id = id;}

    public String getId() {return id;}

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public String getUserEmail() {return userEmail;}

    public void setData(String data) {this.data = data;}

    public String getData() {return data;}

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(getClass())) {
            MagicCheck magicCheck = (MagicCheck) obj;
            if (this.id.equals(magicCheck.getId())) {
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
                ", data='" + data + '\'' +
                '}';
    }
}
