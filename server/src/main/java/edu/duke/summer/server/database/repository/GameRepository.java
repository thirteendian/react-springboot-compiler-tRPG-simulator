package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {

  Game findById(String id);

  boolean existsById(String id);

  List<Game> findByIdStartsWith(String id);

  List<Game> findByHostUuidStartsWith(String hostUuid);

  List<Game> findByGameNameStartsWith(String gameName);

  @Query("select game from Game game where game.curNum < game.playerNum and game.status ='preparing'")
  List<Game> findAvailableGames();

  @Modifying
  @Query("update Game game set game.curNum = game.curNum + 1 where game.id = :gameId")
  void addPlayer(@Param("gameId") String gameId);

  @Modifying
  @Query("update Game game set game.status = :status where game.id = :gameId")
  void changeGameStatus(@Param("gameId") String gameId, @Param("status") String status);


  @Query("select game from Game game, Player player where game.status='paused' and game.id = player.gameId and player.userId = :playerId")
  List<Game> findJoinedGames(@Param ("playerId") String playerId);

}
