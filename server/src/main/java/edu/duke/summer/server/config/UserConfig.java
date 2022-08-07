package edu.duke.summer.server.config;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            User testUser = new User(
                    "user@duke.edu",
                    "test_username",
                    "test_FirstName",
                    "test_LastName",
                    passwordEncoder.encode("pass"),
                    "ROLE_USER",
                    true
            );

            User Admin = new User(
                    "admin@duke.edu",
                    "admin",
                    "---",
                    "---",
                    passwordEncoder.encode("admin"),
                    "ROLE_ADMIN",
                    true
            );
            repository.saveAll(
                    List.of(testUser, Admin)
            );
        };
    }

}
