package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.FunctionInfo;
import edu.duke.summer.server.database.model.GameCode;
import edu.duke.summer.server.database.model.ObjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface GameCodeRepository extends JpaRepository<GameCode, Long> {

    GameCode findByGameId(String gameId);

}
