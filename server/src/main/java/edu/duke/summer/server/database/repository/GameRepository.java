package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  Game findById(String id);

  boolean existsById(String id);

  List<Game> findByIdStartsWith(String id);

  List<Game> findByHostUuidStartsWith(String hostUuid);

  List<Game> findByGameNameStartsWith(String gameName);

}
