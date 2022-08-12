package edu.duke.summer.server.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class FunctionInfo {

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public HashMap<Integer, String> getTest() {
        return test;
    }

    public void setTest(HashMap<Integer, String> test) {
        this.test = test;
    }

    @Id
    private String gameId;

    private HashMap<Integer, String> test;

    public FunctionInfo(String gameId, HashMap<Integer, String> test) {
        this.gameId = gameId;
        this.test = test;
    }
}
