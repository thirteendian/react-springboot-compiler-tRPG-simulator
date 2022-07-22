package edu.duke.summer.client.dto;

import javax.persistence.Column;

public class ObjectFieldTypeDto {

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String k;

    @Column
    private String name;

    @Column
    private ObjectFieldTypeDto elem;

    public ObjectFieldTypeDto() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectFieldTypeDto getElem() {
        return elem;
    }

    public void setElem(ObjectFieldTypeDto elem) {
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "Field Type {" +
                " id = " + id +
                ", kind = " + k +
                ", name = " + name +
                ", elem = " + elem +
                "}";
    }
}
