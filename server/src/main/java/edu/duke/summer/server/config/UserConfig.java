package edu.duke.summer.server.config;

import edu.duke.summer.server.database.model.Role;
import edu.duke.summer.server.database.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static edu.duke.summer.server.database.model.ERole.*;

@Configuration
public class UserConfig {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunnerRoles(RoleRepository roleRepository) {
        return args -> {
            Role role_user = new Role(
                    ROLE_USER
            );
            Role role_moderator = new Role(
                    ROLE_MODERATOR
            );
            Role role_admin = new Role(
                    ROLE_ADMIN
            );

            roleRepository.saveAll(List.of(role_user, role_moderator, role_admin));
        };
    }
//    @Bean
//    CommandLineRunner commandLineRunnerUser(UserRepository repository){
//        return args -> {
//            User testUser = new User(
//                    "user@duke.edu",
//                    "test_username",
//                    "test_FirstName",
//                    "test_LastName",
//                    passwordEncoder.encode("pass"),
//                    "ROLE_USER",
//                    true
//            );
//
//            User Admin = new User(
//                    "admin@duke.edu",
//                    "admin",
//                    "---",
//                    "---",
//                    passwordEncoder.encode("admin"),
//                    "ROLE_ADMIN",
//                    true
//            );
//            repository.saveAll(
//                    List.of(testUser, Admin)
//            );
//        };
//    }

}
