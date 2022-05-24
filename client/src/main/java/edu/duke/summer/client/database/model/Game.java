package edu.duke.summer.client.database.model;

import javax.persistence.*;

import java.lang.*;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "games")
public class Game {

  @SequenceGenerator(
          name = "game_sequence",
          sequenceName = "game_sequence",
          allocationSize = 1
  )

  private Long id;  //game id, primary key

  @Column(nullable = false, unique = true, length = 45)
  private String creatorEmail;

  @Column(nullable = false)
  private int playerNum;

  @Column(nullable = false, length = 45)
  private String gameName;

  public Game() {
  }

  @Column(name = "GAME_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Game(Long id, String creatorEmail, Integer playerNum, String gameName) {
    this.id = id;
    this.creatorEmail = creatorEmail;
    this.playerNum = playerNum;
    this.gameName = gameName;
  }

  public Game(String creatorEmail, Integer playerNum, String gameName) {
    this.creatorEmail = creatorEmail;
    this.playerNum = playerNum;
    this.gameName = gameName;
  }

  @Override
  public String toString() {
    return "Game{" +
            "id=" + id +
            ", CreatorEmail='" + creatorEmail + '\'' +
            ", gameName='" + gameName + '\'' +
            '}';
  }
}

