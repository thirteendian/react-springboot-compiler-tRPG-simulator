package edu.duke.summer.server.dto.Object;

import javax.persistence.Column;

public class ObjectFieldTypeDto {

    @Column(nullable = false)
    private String id;

    // key: primitive, boolean, array, user, option
    @Column(nullable = false)
    private String k;

    // while name is not null, it would be primitive, boolean, or user
    // either name or elem would be null
    @Column
    private String name;

    // while elem is not null, it would be either array or option
    @Column
    private ObjectFieldTypeDto elem;


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

    public ObjectFieldTypeDto() {}

    public ObjectFieldTypeDto(String id, String k, String name, ObjectFieldTypeDto elem) {
        this.id = id;
        this.k = k;
        this.name = name;
        this.elem = elem;
    }

    @Override
    public String toString() {
        return "Field Type {" +
                " id = " + id +
                ", k = " + k +
                ", name = " + name +
                ", elem = " + elem +
                "}";
    }
}
