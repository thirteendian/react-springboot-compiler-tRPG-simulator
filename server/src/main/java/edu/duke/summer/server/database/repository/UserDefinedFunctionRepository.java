package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.UserDefinedFunction;
import edu.duke.summer.server.database.model.UserDefinedObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDefinedFunctionRepository extends JpaRepository<UserDefinedFunction, Long> {

    @Query("select o from UserDefinedFunction o where o.gameId= :gameId")
    List<UserDefinedFunction> findByGameId(String gameId);
}
