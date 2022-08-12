package edu.duke.summer.server;

import edu.duke.summer.server.database.repository.MyMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootTest//(classes={ClientApplication.class})
public class MongoDBTest {

    @Autowired
    private MyMongoRepository myMongoRepository;

    @Test
    public void test_mongoDB(){
        this.myMongoRepository.insert(new edu.duke.summer.server.database.model.MongoDBTest("mary","smith"));

    }

}
