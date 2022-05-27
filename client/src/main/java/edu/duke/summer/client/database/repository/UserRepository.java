package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail (String email);
    //JpaRepository->findBy(primaryKey's name)

    @Query("select case when count(c)>0 then true else false end from User c where lower(c.email) like lower(:email)")
    boolean existsUserByEmail (@Param("email") String email);
}
