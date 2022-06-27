package edu.duke.summer.client.database.model;

import java.io.Serializable;

public class ValueId implements Serializable {
    private String gameId;
    private String typeName;
    private int valNum;
    private int fieldNum;

    public ValueId() {}

    public ValueId (String gameId, String typeName, int valNum, int fieldNum) {
        this.gameId = gameId;
        this.typeName = typeName;
        this.valNum = valNum;
        this.fieldNum = fieldNum;
    }

    @Override
    public boolean equals(Object o) {
        if(!getClass().equals(o.getClass())) return false;
        ValueId valueId = (ValueId) o;
        return this.gameId.equals(valueId.getGameId()) &&
                this.typeName.equals(valueId.getTypeName()) &&
                this.valNum==valueId.getValNum() &&
                this.fieldNum== valueId.getFieldNum();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 17;
        hash = hash*prime + this.gameId.hashCode();
        hash = hash*prime + this.typeName.hashCode();
        hash = hash*prime + this.valNum;
        hash = hash*prime + this.fieldNum;
        return hash;
    }

    public String getGameId() {
        return gameId;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getValNum() {
        return valNum;
    }

    public int getFieldNum() {
        return fieldNum;
    }
}
