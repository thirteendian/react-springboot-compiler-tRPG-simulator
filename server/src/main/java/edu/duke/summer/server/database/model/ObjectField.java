package edu.duke.summer.server.database.model;

import edu.duke.summer.server.dto.Object.ObjectFieldDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "objectField")
public class ObjectField {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String objectName;

    @Column(nullable = false)
    private String fieldNum;

    @Column(nullable = false)
    private String fieldName;

    @Column(nullable = false)
    private String fieldType;

    public String getId() {
        return id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(String fieldNum) {
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

    public ObjectField() {}

    public ObjectField( String gameId, String objectName, String fieldNum, String fieldName, String fieldType) {
        this.gameId = gameId;
        this.objectName = objectName;
        this.fieldNum = fieldNum;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "ObjectField{" +
                "id='" + id + '\'' +
                ", gameId='" + gameId + '\'' +
                ", objectName='" + objectName + '\'' +
                ", fieldNum='" + fieldNum + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }
}
