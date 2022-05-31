package edu.duke.summer.client.dto;

import com.sun.istack.NotNull;
import edu.duke.summer.client.database.model.DiceRolling;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.*;

public class DiceRollingDto {

    @SequenceGenerator(
            name = "dice_rolling_sequence",
            sequenceName = "dice_rolling_sequence",
            allocationSize = 1
    )
    private String id;

    @Column(nullable = false)
    private String game;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String rawData;

    @Column(nullable = false)
    private List<String> visibles;

    public DiceRollingDto() {}

    public DiceRollingDto(String id, String game, String userEmail, String rawData, List<String> visibles) {
        this.id = id;
        this.game = game;
        this.userEmail = userEmail;
        this.rawData = rawData;
        this.visibles = visibles;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "DiceRolling_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {return id;}

    public void setGame(String game) {this.game = game;}

    public String getGame() {return game;}

    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}

    public String getUserEmail() {return userEmail;}

    public void setRawData(String rawData) {this.rawData = rawData;}

    public String getRawData() {return rawData;}

    public void setVisibles(List<String> visibles) {this.visibles = visibles;}

    public List<String> getVisibles() {return visibles;}

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
                ", rawData='" + rawData + '\'' +
                ", visibles='" + visibles + '\'' +
                '}';
    }
}
