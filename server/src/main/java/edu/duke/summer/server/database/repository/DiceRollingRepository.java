package edu.duke.summer.server.database.repository;

import edu.duke.summer.server.database.model.DiceRolling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface DiceRollingRepository extends JpaRepository<DiceRolling, Long> {
    DiceRolling findById(String id);
}
