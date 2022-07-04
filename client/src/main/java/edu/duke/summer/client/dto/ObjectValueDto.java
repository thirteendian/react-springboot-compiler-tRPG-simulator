package edu.duke.summer.client.dto;

import edu.duke.summer.client.database.model.ObjectValue;
import edu.duke.summer.client.service.SeqNumService;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

public class ObjectValueDto {

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String typeName;

    @Column(nullable = false)
    private String valueNum;

    @Column(nullable = false)
    private List<String> fieldValue;

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

    public void addFieldValue(String value) {
        fieldValue.add(value);
    }

    public List<String> getFieldValue() {
        return fieldValue;
    }

    public ObjectValueDto() {
        valueNum = String.valueOf(new SeqNumService().createSeqNum());
        fieldValue = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "DiceRolling{" +
                ", gameId='" + gameId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", valueNum='" + valueNum + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                '}';
    }
}
