package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.lang.*;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name = "games")
public class Game {

  @Id @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid",strategy = "uuid")
  @Column(unique = true, nullable = false, insertable = false, updatable = false)
  private String id;

  @Column(nullable = false, unique = false, length = 45)
  private String hostUuid;

  @Column(nullable = false, unique=true,length = 45)
  private String gameName;

  @Column(nullable = false)
  private int playerNum;

  @Column(nullable = false)
  private int curNum;

  @Column(nullable = false)
  private String status;

  @Lob
  @Column(nullable = false)
  private String code;

  public String getId() {
    return id;
  }

  public String getHostUuid() {
    return hostUuid;
  }

  public void setHostUuid(String hostUuid) {
    this.hostUuid = hostUuid;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public int getPlayerNum() {
    return playerNum;
  }

  public void setPlayerNum(int playerNum) {
    this.playerNum = playerNum;
  }

  public int getCurNum() {
    return curNum;
  }

  public void setCurNum(int curNum) {
    this.curNum = curNum;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Game() {}

  public Game(String hostUuid, String gameName, int playerNum, String code) {
    this.hostUuid = hostUuid;
    this.gameName = gameName;
    this.playerNum = playerNum;
    this.curNum = 1;
    this.status = "waiting";
    this.code = code;
  }

  @Override
  public String toString() {
    return "Game{" +
            "id='" + id + '\'' +
            ", hostUuid='" + hostUuid + '\'' +
            ", gameName='" + gameName + '\'' +
            ", playerNum=" + playerNum +
            ", curNum=" + curNum +
            ", status=" + status +
            ", code='" + code + '\'' +
            '}';
  }
}


