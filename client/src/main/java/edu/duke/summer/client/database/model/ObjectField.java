package edu.duke.summer.client.database.model;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "objectField")
@IdClass(ObjectField.class)
public class ObjectField implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Id
    @Column(nullable = false)
    private String typeName;

    @Id
    @Column(nullable = false)
    private String fieldNum;

    @Column(nullable = false)
    private String fieldName;

    @Column(nullable = false)
    private String fieldType;

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

    public void setFieldNum(String fieldNum) {
        this.fieldNum = fieldNum;
    }

    public String getFieldNum() {
        return fieldNum;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldType() {
        return fieldType;
    }

    public ObjectField() {}

    public ObjectField(String gameId, String typeName, String fieldNum, String fieldName, String fieldType) {
        this.gameId = gameId;
        this.typeName = typeName;
        this.fieldNum = fieldNum;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "ObjectField{" +
                "gameId=" + gameId +
                ", typeName='" + typeName + '\'' +
                ", fieldNum='" + fieldNum + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }

}
