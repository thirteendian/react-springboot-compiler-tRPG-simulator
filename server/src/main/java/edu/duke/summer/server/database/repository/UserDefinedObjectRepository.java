package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.UserDefinedObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface UserDefinedObjectRepository extends JpaRepository<UserDefinedObject, Long> {

    @Query("select o from UserDefinedObject o where o.gameId= :gameId")
    List<UserDefinedObject> findByGameId(String gameId);
}
