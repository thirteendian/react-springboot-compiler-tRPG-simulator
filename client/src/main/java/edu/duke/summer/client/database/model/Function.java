package edu.duke.summer.client.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "function")
public class Function implements Serializable {

    @Id
    @Column(nullable = false)
    private String gameId;

    @Column
    private String paramList;

    @Column
    private String returnType;

}
