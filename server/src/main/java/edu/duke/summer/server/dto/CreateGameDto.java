package edu.duke.summer.server.dto;

import edu.duke.summer.server.database.model.Game;

import javax.persistence.*;

public class CreateGameDto {

  @SequenceGenerator(
          name = "game_sequence",
          sequenceName = "game_sequence",
          allocationSize = 1
  )

  @Column(name = "GAME_ID")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;  //game id, primary key

  @Column(nullable = false)
  private int playerNum;

  @Column(nullable = false, length = 45)
  private String gameName;

  @Column(nullable = false)
  private String gameSettings;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGameName() {
    return gameName;
  }


  public Integer getPlayerNum() {return playerNum;}


  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public void setPlayerNum(int playerNum) {this.playerNum = playerNum;}

  public String getGameSettings() {
    return gameSettings;
  }

  public void setGameSettings(String gameSettings) {
    this.gameSettings = gameSettings;
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


}
