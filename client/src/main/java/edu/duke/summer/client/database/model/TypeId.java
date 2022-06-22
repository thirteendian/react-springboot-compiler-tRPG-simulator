package edu.duke.summer.client.database.model;

import java.io.Serializable;

public class TypeId implements Serializable {
    private String gameId;
    private String typeName;
    private int fieldNum;

    public TypeId() {}

    public TypeId(String gameId, String typeName, int fieldNum) {
        this.gameId = gameId;
        this.typeName = typeName;
        this.fieldNum = fieldNum;
    }


    @Override
    public boolean equals(Object o) {
        if (!getClass().equals(o.getClass())) return false;
        TypeId typeId = (TypeId) o;
        return this.gameId.equals(typeId.getGameId()) &&
                this.typeName.equals(typeId.getTypeName()) &&
                this.fieldNum==typeId.getFieldNum();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 17;
        hash = hash*prime + this.gameId.hashCode();
        hash = hash*prime + this.typeName.hashCode();
        hash = hash*prime + this.fieldNum;
        return hash;
    }

    public String getGameId() {
        return gameId;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getFieldNum() {
        return fieldNum;
    }
}
