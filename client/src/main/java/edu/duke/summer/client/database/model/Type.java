package edu.duke.summer.client.database.model;

import javax.persistence.*;

@Entity
@IdClass(TypeId.class)
@Table(name = "types")
public class Type {
    @Id @Column
    private String gameId;

    @Id @Column
    private String typeName;

    @Id @Column
    private int fieldNum;

    @Column
    private String fieldName;

    @Column
    private String fieldType;

    public Type() {}

    public Type(String gameId, String typeName, int fieldNum, String fieldName, String fieldType) {
        this.gameId = gameId;
        this.typeName = typeName;
        this.fieldNum = fieldNum;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public boolean equals(Object o) {
        if(!getClass().equals(o.getClass())) return false;
        Type t = (Type) o;
        return gameId.equals(t.getGameId()) &&
                typeName.equals(t.getTypeName()) &&
                fieldNum==t.getFieldNum();
    }

    @Override
    public String toString() {
        return "Type {" + "gameId=" + gameId +
                ", type name=" + typeName +
                ", field number=" + fieldNum +
                ", field name=" + fieldName +
                ", field type=" + fieldType + "}";
    }
}
