package edu.duke.summer.client.database.model;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "objectArrayValue")
@IdClass(ObjectArrayValue.class)
public class ObjectArrayValue implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Id
    @Column(nullable = false)
    private String eltType;

    @Id
    @Column(nullable = false)
    private String valueNum;

    @Id
    @Column(nullable = false)
    private String index;

    @Column
    private String intVal = "null";

    @Column
    private String stringVal = "null";

    @Column
    private String boolVal = "null";

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setEltType(String eltType) {
        this.eltType = eltType;
    }

    public String getEltType() {
        return eltType;
    }

    public void setValueNum(String valueNum) {
        this.valueNum = valueNum;
    }

    public String getValueNum() {
        return valueNum;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setIntVal(String intVal) {
        this.intVal = intVal;
    }

    public String getIntVal() {
        return intVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setBoolVal(String boolVal) {
        this.boolVal = boolVal;
    }

    public String getBoolVal() {
        return boolVal;
    }

    public ObjectArrayValue() {}

    @Override
    public String toString() {
        return "ObjectField{" +
                "gameId=" + gameId +
                ", eltType='" + eltType + '\'' +
                ", valueNum='" + valueNum + '\'' +
                ", index='" + index + '\'' +
                ", intVal='" + intVal + '\'' +
                ", stringVal='" + stringVal + '\'' +
                ", boolVal='" + boolVal + '\'' +
                '}';
    }

}
