package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.*;


public interface ObjectValueRepository extends MongoRepository<ObjectValue, Long> {

    @Query("{'gameId': ?0, 'playerUuid' : ?1}")
    List<ObjectValue> findMyObjects(String gameId, String playerUuid);

}
