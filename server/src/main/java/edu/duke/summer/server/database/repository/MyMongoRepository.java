package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.MongoDBTest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMongoRepository extends MongoRepository<MongoDBTest,String> {
    public MongoDBTest findByFirstName(String firstName);
}
