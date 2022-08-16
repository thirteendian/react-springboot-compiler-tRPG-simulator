package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.lang.*;

@Entity
@Table(name = "param")
public class Parameter {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String funcName;

    @Column(nullable = false)
    private String paramNum;

    @Column(nullable = false)
    private String paramName;

    @Column(nullable = false)
    private String paramType;

    public String getId() {
        return id;
    }

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

    public Parameter() {}

    public Parameter(String gameId, String funcName, String paramNum, String paramName, String paramType) {
        this.gameId = gameId;
        this.funcName = funcName;
        this.paramNum = paramNum;
        this.paramName = paramName;
        this.paramType = paramType;
    }

    @Override
    public String toString() {
        return "Param{" +
                "id='" + id + '\'' +
                ", gameId='" + gameId + '\'' +
                ", funcName='" + funcName + '\'' +
                ", paramNum='" + paramNum + '\'' +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                '}';
    }
}



