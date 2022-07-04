package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.ObjectField;
import edu.duke.summer.client.database.model.ObjectValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface ObjectValueRepository extends JpaRepository<ObjectValue, Long> {

    List<ObjectValue> findByGameId(String gameId);

    @Query("select o from ObjectValue o where o.gameId = :gameId and o.typeName = :typeName and o.valueNum = :valueNum order by o.fieldNum")
    List<ObjectValue> findObjectValue(@Param("gameId") String gameId, @Param("typeName") String typeName, @Param("valueNum") String valueNum);

}
