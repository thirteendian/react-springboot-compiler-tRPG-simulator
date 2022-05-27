package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.*;


import org.springframework.data.domain.Pageable;

@Repository
public interface DiceRollingRepository extends JpaRepository<DiceRolling, Long> {

    DiceRolling findById(String id);

    @Query("select d from DiceRolling d where d.game = :game and d.userEmail= :userEmail")
    //@Query("select d from DiceRolling d where d.game = :game case when d.userEmail = :userEmail then true else d.visible = true end")
    List<DiceRolling> findRecentResults(@Param("game") String game, @Param("userEmail") String userEmail, Pageable pageable);

    default List<DiceRolling> findTop20RecentResults(String game, String userEmail) {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("id").descending());
        return findRecentResults(game, userEmail, pageable);
    }

}
