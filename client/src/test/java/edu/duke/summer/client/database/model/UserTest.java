package edu.duke.summer.client.database.model;

import edu.duke.summer.client.config.UserConfig;
import edu.duke.summer.client.database.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_generate_id() {
        User test = new User("johnSmith@gmail.com","john",
                "smith","johnsmith","role_user",true);
        userRepository.save(test);
        assertNotNull(test.getId());

        User test2 = new User("davidSmith@gmail.com","david",
                "smith","davidsmith","role_user",true);
        assertNull(test2.getId());
        userRepository.save(test2);
        assertNotNull(test2.getId());
        assertNotEquals(test.getId(), test2.getId());
    }

    @Test
    public void test_get_and_equals() {
        User test1 = new User("davidbrown@gmail.com","david",
                "brown","davidbrown","role_user",true);
        User test2 = new User("johnSmith@gmail.com","john",
                "smith","johnsmith","role_user",true);
        User test3 = new User("johnSmith@gmail.com","jo",
                "smi","johnsmith","role_loggedin_user",true);
        assertEquals("johnSmith@gmail.com",test2.getEmail());
        assertEquals("smi",test3.getLastName());
        assertNotEquals(test1,test2);
        assertEquals(test2, test3);
    }

}