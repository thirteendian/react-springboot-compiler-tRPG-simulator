package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.ObjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectFieldRepository extends JpaRepository<ObjectField, Long> {

    List<ObjectField> findByGameId(String gameId);

    List<ObjectField> findByTypeName(String typeName);

    @Query("select o from ObjectField o where o.gameId = :gameId and o.typeName = :typeName and o.fieldNum = :fieldNum")
    ObjectField findObjectField(@Param("gameId") String gameId, @Param("typeName") String typeName, @Param("fieldNum") String fieldNum);

}
