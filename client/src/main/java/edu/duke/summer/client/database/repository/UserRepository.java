package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail (String email);

    boolean existsByEmail (String email);
}
