package edu.duke.summer.server.dto.Request;

import edu.duke.summer.server.algorithm.value.Value;

import java.util.HashMap;
import java.util.List;

public class CallFunctionRequestDto {

    private String gameId;

    private String functionId;

    private String userId;

    // <paramId, JSON string> : param id -> json object of param value
    private HashMap<String, String> params;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public CallFunctionRequestDto() {}

    public CallFunctionRequestDto(String gameId, String functionId, String userId, HashMap<String, String> params) {
        this.gameId = gameId;
        this.functionId = functionId;
        this.userId = userId;
        this.params = params;
    }
}
