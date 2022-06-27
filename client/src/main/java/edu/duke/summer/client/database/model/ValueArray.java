package edu.duke.summer.client.database.model;

import javax.persistence.*;

@Entity
@IdClass(ValueArrayId.class)
@Table(name = "value_array")
public class ValueArray {
    @Id
    @Column
    private String gameId;

    @Id @Column
    private String elmtType;

    @Id @Column
    private int valNum;

    @Id @Column
    private int index;

    @Column
    private int intVal;

    @Column
    private String stringVal;

    public ValueArray() {}

    public ValueArray (String gameId, String elmtType, int valNum, int index,
                       int intVal, String stringVal) {
        this.gameId = gameId;
        this.elmtType = elmtType;
        this.valNum = valNum;
        this.index = index;
        this.intVal = intVal;
        this.stringVal = stringVal;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getElmtType() {
        return elmtType;
    }

    public void setElmtType(String elmtType) {
        this.elmtType = elmtType;
    }

    public int getValNum() {
        return valNum;
    }

    public void setValNum(int valNum) {
        this.valNum = valNum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
        if (!getClass().equals(o.getClass())) return false;
        ValueArray valueArray = (ValueArray) o;
        return this.gameId.equals(valueArray.getGameId()) &&
                this.elmtType.equals(valueArray.getElmtType()) &&
                this.valNum==valueArray.getValNum() &&
                this.index==valueArray.getIndex();
    }

    @Override
    public String toString() {
        return "ValueArray {" + "gameId=" + gameId +
                ", element type=" + elmtType +
                ", value number=" + valNum +
                ", index=" + index +
                ", int value=" + intVal +
                ", string value=" + stringVal + "}";
    }
}
