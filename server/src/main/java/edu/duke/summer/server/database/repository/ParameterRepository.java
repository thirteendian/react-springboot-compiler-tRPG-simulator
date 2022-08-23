package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.ObjectField;
import edu.duke.summer.server.database.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    Parameter findById(String id);

    @Query("select o from Parameter o where o.gameId = :gameId and o.funcName = :functionName order by o.id")
    List<Parameter> findParameters(@Param("gameId") String gameId, @Param("functionName") String functionName);

    @Query("select o from Parameter o where o.gameId = :gameId and o.funcName = :funcName and o.paramName = :paramName")
    Parameter findParameter(@Param("gameId") String gameId, @Param("funcName") String funcName, @Param("paramName") String paramName);
}

