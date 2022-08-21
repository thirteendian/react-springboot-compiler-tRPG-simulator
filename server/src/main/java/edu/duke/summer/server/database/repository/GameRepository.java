package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  Game findById(String id);

  boolean existsById(String id);

  List<Game> findByIdStartsWith(String id);

  List<Game> findByHostUuidStartsWith(String hostUuid);

  List<Game> findByGameNameStartsWith(String gameName);

  @Query("select game from Game game where game.curNum < game.playerNum and game.status ='preparing'")
  List<Game> findAvailableGames();

  @Query("update Game game set game.curNum = game.curNum + 1 where game.id = :gameId")
  void addPlayer(@Param("gameId") String gameId);

}
