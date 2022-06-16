package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_find_and_query() {
        User test1 = new User("kelvin@gmail.com","john",
                "smith","johnsmith","role_user",true);
        userRepository.save(test1);
        User test2 = new User("davidbrown@gmail.com","david",
                "brown","davidbrown","role_user",true);
        userRepository.save(test2);
        assertEquals(Optional.empty(), userRepository.findByEmail("stellaBrown@gmail.com"));
        assertEquals(test1, userRepository.findByEmail("kelvin@gmail.com").get());

        assertTrue(userRepository.existsUserByEmail("davidbrown@gmail.com"));
        assertFalse(userRepository.existsUserByEmail("davidBrown@gmail.com"));
    }

}