package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findById(String id);

    List<Player> findAllByGameId(String gameId);

    boolean existsById(String id);

    @Query("select player from Player player where player.gameId = :gameId and player.userId = :player")
    Player findPlayer(@Param("gameId") String gameId, @Param("player") String playerId);

}
