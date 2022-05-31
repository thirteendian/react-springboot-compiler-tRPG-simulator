package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.Visibility;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.*;

@Repository
public interface VisibilityRepository extends JpaRepository<Visibility, Long> {

    @Query("select v from Visibility v where v.gameId = :game and v.playerId = :player")
    List<Visibility> findRecentResults(@Param("game") String game, @Param("player") String player, Pageable pageable);

    default List<Visibility> findTop20RecentResults(String game, String player) {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("id").descending());
        return findRecentResults(game, player, pageable);
    }

}
