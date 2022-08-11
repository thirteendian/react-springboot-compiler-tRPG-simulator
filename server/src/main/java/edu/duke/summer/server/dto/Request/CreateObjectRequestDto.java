package edu.duke.summer.server.dto.Request;

import edu.duke.summer.server.dto.FieldValueDto;
import edu.duke.summer.server.service.SeqNumService;
import org.antlr.v4.runtime.misc.NotNull;

import javax.persistence.*;
import java.util.*;

public class CreateObjectRequestDto {

    @NotNull
    private String gameId;

    @NotNull
    private String playerUuid;

    @NotNull
    private List<FieldValueDto> fieldValue;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public List<FieldValueDto> getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(List<FieldValueDto> fieldValue) {
        this.fieldValue = fieldValue;
    }

    public CreateObjectRequestDto() {}

    public CreateObjectRequestDto(String gameId, String playerUuid, List<FieldValueDto> fieldValue) {
        this.gameId = gameId;
        this.playerUuid = playerUuid;
        this.fieldValue = fieldValue;
    }
}
