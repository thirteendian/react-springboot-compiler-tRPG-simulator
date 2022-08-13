package edu.duke.summer.server.database.model;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "functionInfo")
@IdClass(FunctionInfo.class)
public class FunctionInfo implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Id
    @Column(nullable = false)
    private String funcName;

    @Column(nullable = false)
    private String paramNum;

    @Column(nullable = false)
    private String paramName;

    @Column(nullable = false)
    private String paramType;

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setParamNum(String paramNum) {
        this.paramNum = paramNum;
    }

    public String getParamNum() {
        return paramNum;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamType() {
        return paramType;
    }

    public FunctionInfo() {}

    public FunctionInfo(String gameId, String funcName, String paramNum, String paramName, String paramType) {
        this.gameId = gameId;
        this.funcName = funcName;
        this.paramNum = paramNum;
        this.paramName = paramName;
        this.paramType = paramType;
    }

    @Override
    public String toString() {
        return "FunctionInfo{" +
                "gameId=" + gameId +
                ", funcName='" + funcName + '\'' +
                ", paramNum='" + paramNum + '\'' +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                '}';
    }
}



