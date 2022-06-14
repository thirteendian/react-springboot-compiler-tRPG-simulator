package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.MagicCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MagicCheckRepository extends JpaRepository<MagicCheck, Long> {

    MagicCheck findById(String id);

    @Query("select m from MagicCheck m where m.game = :game and m.player = :player")
    List<MagicCheck> findMagicCheckData(@Param("game") String game, @Param("player") String player);

}
