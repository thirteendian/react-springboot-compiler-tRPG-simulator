package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.FunctionInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FunctionInfoRepository extends MongoRepository<FunctionInfo, Long> {
    public FunctionInfo findByGameId(String gameId);
}
