package edu.duke.summer.client.dto;

import com.sun.istack.NotNull;
import edu.duke.summer.client.database.model.Game;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.*;

public class GameDto {

  @SequenceGenerator(
          name = "game_sequence",
          sequenceName = "game_sequence",
          allocationSize = 1
  )

  private String id;  //game id, primary key

  @Column(nullable = false, unique = true, length = 45)
  private String creatorEmail;

  @Column(nullable = false)
  private int playerNum;

  @Column(nullable = false, length = 45)
  private String gameName;

  public GameDto() {
  }

  @Column(name = "GAME_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreatorEmail() {
    return creatorEmail;
  }


  public String getGameName() {
    return gameName;
  }


  public Integer getPlayerNum() {return playerNum;}

  public void setCreatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public void setPlayerNum(int playerNum) {this.playerNum = playerNum;}

  public GameDto(String id, String creatorEmail, Integer playerNum, String gameName) {
    this.id = id;
    this.creatorEmail = creatorEmail;
    this.playerNum = playerNum;
    this.gameName = gameName;
  }

  public GameDto(String creatorEmail, Integer playerNum, String gameName) {
    this.creatorEmail = creatorEmail;
    this.playerNum = playerNum;
    this.gameName = gameName;
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj.getClass().equals(getClass())) {
      Game game = (Game) obj;
      if (this.id.equals(game.getId())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Game{" +
            "id=" + id +
            ", creatorEmail='" + creatorEmail + '\'' +
            ", gameName='" + gameName + '\'' +
            '}';
  }

}
