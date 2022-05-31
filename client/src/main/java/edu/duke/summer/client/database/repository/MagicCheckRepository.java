package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.MagicCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicCheckRepository extends JpaRepository<MagicCheck, Long> {

    MagicCheck findById(String id);

}
