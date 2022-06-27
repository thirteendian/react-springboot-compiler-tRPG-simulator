package edu.duke.summer.client.database.model;

import javax.persistence.*;

@Entity
@IdClass(ValueId.class)
@Table(name = "values")
public class Value {
    @Id
    @Column
    private String gameId;

    @Id @Column
    private String typeName;

    @Id @Column
    private int valNum;

    @Id @Column
    private int fieldNum;

    @Column
    private int intVal;

    @Column
    private String stringVal;

    public Value() {}

    public Value (String gameId, String typeName, int valNum, int fieldNum,
                  int intVal, String stringVal) {
        this.gameId = gameId;
        this.typeName = typeName;
        this.valNum = valNum;
        this.fieldNum = fieldNum;
        this.intVal = intVal;
        this.stringVal = stringVal;
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

    public int getValNum() {
        return valNum;
    }

    public void setValNum(int valNum) {
        this.valNum = valNum;
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    @Override
    public boolean equals(Object o) {
        if(!getClass().equals(o.getClass())) return false;
        Value value = (Value) o;
        return this.gameId.equals(value.getGameId()) &&
                this.typeName.equals(value.getTypeName()) &&
                this.valNum==value.getValNum() &&
                this.fieldNum== value.getFieldNum();
    }

    @Override
    public String toString() {
        return "Value {" + "gameId=" + gameId +
                ", type name=" + typeName +
                ", value number=" + valNum +
                ", field number=" + fieldNum +
                ", int value=" + intVal +
                ", string value=" + stringVal + "}";
    }
}
