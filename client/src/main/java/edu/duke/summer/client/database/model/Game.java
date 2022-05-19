package edu.duke.summer.client.database.model;

import javax.persistence.*;

import java.lang.*;
import java.util.*;

@Entity
@Table(name = "games")
public class Game {
   
  @Id   
  @Column(unique = true, nullable = false, updatable = false)
  private Long id;
  @Column(nullable = false, length = 50)
  private String creatorEmail;
  @Column(nullable = true, length = 50)
  private String password;
  @Column(nullable = false, length = 50)
  private String gameName;

  public Game() {}

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setCreatorEmail(String creatorEmail) {
    this.creatorEmail = creatorEmail;
  }

  public String getCreatorEmail() {
    return creatorEmail;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public String getGameName() {
    return gameName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public Game(Long id, String creatorEmail, String password, String gameName) {
    this.id = id;
    this.creatorEmail = creatorEmail;
    this.password = password;
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
