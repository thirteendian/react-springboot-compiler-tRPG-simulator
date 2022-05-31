package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findById(String id);

    boolean existsById(String id);

}
