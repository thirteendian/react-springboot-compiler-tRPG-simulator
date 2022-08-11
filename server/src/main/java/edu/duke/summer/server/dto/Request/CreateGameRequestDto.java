package edu.duke.summer.server.dto.Request;

import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.*;

public class CreateGameRequestDto {

  @NotNull
  private String hostUuid;

  @NotNull
  private String gameName;

  @NotNull
  private int playerNum;

  @NotNull
  private String code;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CreateGameRequestDto() {}

  public CreateGameRequestDto(String hostUuid, String gameName, int playerNum, String code) {
    this.hostUuid = hostUuid;
    this.gameName = gameName;
    this.playerNum = playerNum;
    this.code = code;
  }
}
