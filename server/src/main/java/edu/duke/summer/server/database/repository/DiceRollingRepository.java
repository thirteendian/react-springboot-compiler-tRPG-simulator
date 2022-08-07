package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.DiceRolling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRollingRepository extends JpaRepository<DiceRolling, Long> {

    DiceRolling findById(String id);

}
