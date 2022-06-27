package edu.duke.summer.client.database.model;

import java.io.Serializable;

public class ValueArrayId implements Serializable {
    private String gameId;
    private String elmtType;
    private  int valNum;
    private int index;

    public ValueArrayId() {}

    public ValueArrayId(String gameId, String elmtType, int valNum, int index) {
        this.gameId = gameId;
        this.elmtType = elmtType;
        this.valNum = valNum;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (!getClass().equals(o.getClass())) return false;
        ValueArrayId valueArrayId = (ValueArrayId) o;
        return this.gameId.equals(valueArrayId.getGameId()) &&
                this.elmtType.equals(valueArrayId.getElmtType()) &&
                this.valNum==valueArrayId.getValNum() &&
                this.index==valueArrayId.getIndex();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 17;
        hash = hash*prime + this.gameId.hashCode();
        hash = hash*prime + this.elmtType.hashCode();
        hash = hash*prime + this.valNum;
        hash = hash*prime + this.index;
        return hash;
    }

    public String getGameId() {
        return gameId;
    }

    public String getElmtType() {
        return elmtType;
    }

    public int getValNum() {
        return valNum;
    }

    public int getIndex() {
        return index;
    }
}
