package edu.duke.summer.client.database.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.*;

@Entity
@Table(name = "objectFieldType")
public class ObjectFieldType {

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String k;

    @Column
    private String name = "null";

    @Column
    private String elem = "null";

    public String getId() {
        return id;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getK() {
        return k;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public String getElem() {
        return elem;
    }

    public ObjectFieldType() {}

    public ObjectFieldType(String k, String name, String elem) {
        this.k = k;
        this.name = name;
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "ObjectFieldType{" +
                "id=" + id +
                ", k='" + k + '\'' +
                ", name='" + name + '\'' +
                ", elem='" + elem + '\'' +
                '}';
    }
}
