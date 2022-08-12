package edu.duke.summer.server.database.model;

import edu.duke.summer.server.algorithm.absyn.Ty;

import javax.persistence.Id;

public class FieldType {

    @Id
    private String id;
    private String name;
    private Ty ty;
    private Object value;

}
