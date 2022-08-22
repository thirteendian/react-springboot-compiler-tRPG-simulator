package edu.duke.summer.server.dto.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReCallFunctionRequestDto {

    private String gameId;

    private String functionId;

    private String userId;

    // <paramId, JSON string> : param id -> json object of param value
    // should the same as the params of call function within one process
    private HashMap<String, String> params;

    // re-roll ids
    private ArrayList<String> reRollDiceIds;

    // true userOption ids
    private ArrayList<String> trueUserOptionIds;

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

    public ArrayList<String> getReRollDiceIds() {
        return reRollDiceIds;
    }

    public void setReRollDiceIds(ArrayList<String> reRollDiceIds) {
        this.reRollDiceIds = reRollDiceIds;
    }

    public  ArrayList<String> getTrueUserOptionIds() {
        return trueUserOptionIds;
    }

    public void setTrueUserOptionIds(ArrayList<String> trueUserOptionIds) {
        this.trueUserOptionIds = trueUserOptionIds;
    }

    public ReCallFunctionRequestDto() {}

    public ReCallFunctionRequestDto(String gameId, String functionId, String userId, HashMap<String, String> params, ArrayList<String> reRollDiceIds, ArrayList<String> trueUserOptionIds) {
        this.gameId = gameId;
        this.functionId = functionId;
        this.userId = userId;
        this.params = params;
        this.reRollDiceIds = reRollDiceIds;
        this.trueUserOptionIds = trueUserOptionIds;
    }

    @Override
    public String toString() {
        return "ReCallFunctionRequestDto{" +
                "gameId='" + gameId + '\'' +
                ", functionId='" + functionId + '\'' +
                ", userId='" + userId + '\'' +
                ", params=" + params +
                ", reRollDiceIds=" + reRollDiceIds +
                ", trueUserOptionIds=" + trueUserOptionIds +
                '}';
    }
}
