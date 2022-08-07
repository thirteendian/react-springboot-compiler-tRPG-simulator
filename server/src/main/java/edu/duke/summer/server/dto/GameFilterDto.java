package edu.duke.summer.server.dto;

import edu.duke.summer.server.database.model.Game;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GameFilterDto {

  public GameFilterDto(String id, String creatorEmail, String gameName) {
    this.id = id;
    this.creatorEmail = creatorEmail;
    this.gameName = gameName;
  }

  @NotNull
  @Size(min = 1, max = 50)
  private String id;

  @NotNull
  @Size(min = 1, max = 50)
  private String creatorEmail;

  @NotNull
  @Size(min = 1, max = 50)
  private String gameName;

  public void setId(final String id) {
    this.id = id;
  }

  public String getId() {
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
