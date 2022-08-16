package edu.duke.summer.server.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.*;

@Entity
@Table(name = "UserDefinedFunction")
public class UserDefinedFunction {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String functionName;

    public String getId() {return id;}

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public UserDefinedFunction() {}

    public UserDefinedFunction(String gameId, String functionName) {
        this.gameId = gameId;
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return "UserDefinedFunction{" +
                "id='" + id + '\'' +
                ", gameId='" + gameId + '\'' +
                ", functionName='" + functionName + '\'' +
                '}';
    }
}
