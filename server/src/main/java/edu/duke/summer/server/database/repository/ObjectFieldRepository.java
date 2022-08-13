package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectFieldRepository extends JpaRepository<ObjectField, Long> {

    @Query("select o from ObjectField o where o.gameId = :gameId and o.objectName = :objectName order by o.id")
    List<ObjectField> findObjectFields(@Param("gameId") String gameId, @Param("objectName") String objectName);

    @Query("select o from ObjectField o where o.gameId = :gameId and o.objectName = :objectName and o.fieldName = :fieldName")
    ObjectField findObjectField(@Param("gameId") String gameId, @Param("objectName") String typeName, @Param("fieldName") String fieldName);
}
