package edu.duke.summer.client.database.model;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "objectValue")
@IdClass(ObjectValue.class)
public class ObjectValue implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Id
    @Column(nullable = false)
    private String typeName;

    @Id
    @Column(nullable = false)
    private String valueNum;

    @Id
    @Column(nullable = false)
    private String fieldNum;

    @Id
    @Column(nullable = false)
    private String index;

    @Column
    private String intVal;

    @Column
    private String stringVal;

    @Column
    private String boolVal;

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setValueNum(String valueNum) {
        this.valueNum = valueNum;
    }

    public String getValueNum() {
        return valueNum;
    }

    public void setFieldNum(String fieldNum) {
        this.fieldNum = fieldNum;
    }

    public String getFieldNum() {
        return fieldNum;
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

    public ObjectValue() {}

    @Override
    public String toString() {
        return "ObjectField{" +
                "gameId=" + gameId +
                ", typeName='" + typeName + '\'' +
                ", valueNum='" + valueNum + '\'' +
                ", fieldNum='" + fieldNum + '\'' +
                ", index='" + index + '\'' +
                ", intVal='" + intVal + '\'' +
                ", stringVal='" + stringVal + '\'' +
                ", boolVal='" + boolVal + '\'' +
                '}';
    }

}
