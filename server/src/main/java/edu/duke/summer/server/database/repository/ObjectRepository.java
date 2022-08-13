package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectField;
import edu.duke.summer.server.database.model.ObjectValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Long> {


    @Query("select o.objectName from Object o where o.gameId= :gameId")
    List<String> findByGameId(String gameId);
}
