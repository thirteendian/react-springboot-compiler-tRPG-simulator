package edu.duke.summer.client.dto;

import com.sun.istack.NotNull;
import edu.duke.summer.client.database.model.Game;

import javax.validation.constraints.Size;

import java.util.*;

public class GameDto {


  public GameDto(Long id, String creatorEmail, Integer playerNum, String gameName) {
    this.id = id;
    this.creatorEmail = creatorEmail;
    this.playerNum = playerNum;
    this.gameName = gameName;
  }

  @com.sun.istack.NotNull
  @Size(min = 1)
  private Long id;

  @com.sun.istack.NotNull
  @Size(min = 1, max = 50)
  private String creatorEmail;

//    @Size(max = 50)
//    private String password;

  @com.sun.istack.NotNull
  @Size(min = 1, max = 20)
  private Integer playerNum;



  @NotNull
  @Size(min = 1, max = 50)
  private String gameName;

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setCreatorEmail(final String creatorEmail) {
    this.creatorEmail = creatorEmail;
  }

  public String getCreatorEmail() {
    return creatorEmail;
  }

  public void setGameName(final String gameName) {
    this.gameName = gameName;
  }

  public String getGameName() {
    return gameName;
  }

  public Integer getPlayerNum() {
    return playerNum;
  }

  public void setPlayerNum(Integer playerNum) {
    this.playerNum = playerNum;
  }

  //    public void setPassword(final String password) {
//        this.password = password;
//    }
//
//    public String getPassword() {
//        return password;
//    }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj.getClass().equals(getClass())) {
      Game game = (Game) obj;
      if (this.id == game.getId()) {
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
