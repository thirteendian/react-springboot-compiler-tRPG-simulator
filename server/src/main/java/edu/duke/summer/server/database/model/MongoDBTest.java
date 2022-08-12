package edu.duke.summer.server.database.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

public class MongoDBTest {
    @Id
    private String id;

    public String firstName;
    public String lastName;
    public MongoDBTest(){}

    public MongoDBTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
