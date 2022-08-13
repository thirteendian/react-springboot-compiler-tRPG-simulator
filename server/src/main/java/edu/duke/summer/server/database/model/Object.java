package edu.duke.summer.server.database.model;

import edu.duke.summer.server.dto.Object.ObjectFieldDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "object")
public class Object {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String gameId;

    @Column(nullable = false)
    private String objectName;

    public void setId(String id) {
        this.id = id;
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

    public Object() {}

    public Object(String id, String gameId, String objectName) {
        this.id = id;
        this.gameId = gameId;
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id='" + id + '\'' +
                ", gameId='" + gameId + '\'' +
                ", objectName='" + objectName + '\'' +
                '}';
    }
}
