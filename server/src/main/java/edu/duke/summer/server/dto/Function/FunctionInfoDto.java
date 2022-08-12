package edu.duke.summer.server.dto.Function;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;

public class FunctionInfoDto {

    @NotNull
    private String gameId;

    @NotNull
    private String funcName;

    @NotNull
    private List<String> params;

    @NotNull
    private HashMap<String, ParamInfoDto> paramType;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public HashMap<String, ParamInfoDto> getParamType() {
        return paramType;
    }

    public void setParamType(HashMap<String, ParamInfoDto> paramType) {
        this.paramType = paramType;
    }

    public FunctionInfoDto() {}

    public FunctionInfoDto(String gameId, String funcName, List<String> params, HashMap<String, ParamInfoDto> paramType) {
        this.gameId = gameId;
        this.funcName = funcName;
        this.params = params;
        this.paramType = paramType;
    }
}
