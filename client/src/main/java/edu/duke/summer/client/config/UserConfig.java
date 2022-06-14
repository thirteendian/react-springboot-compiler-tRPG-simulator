package edu.duke.summer.client.config;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            User John = new User(
                    "user1",
                    "John",
                    "Alex",
                    "pass",
                    "ROLE_USER",
                    true
            );

            User Bob = new User(
                    "user2",
                    "Bob",
                    "Dylan",
                    "pass",
                    "ROLE_USER",
                    true
            );
//
//            User Steven = new User(
//                    "Steven@gmail.com",
//                    "Steven",
//                    "Tyler",
//                    "StevenTyler"
//
//            );
//
//            User Michael = new User(
//                    "Michael@gmail.com",
//                    "Michael",
//                    "Joseph",
//                    "MichaelJoseph"
//
//            );
//
//            User Emma = new User(
//                    "Emma@gmail.com",
//                    "Emma",
//                    "Olivia",
//                    "EmmaOlivia"
//
//            );
//
//            User Charlotte = new User(
//                    "Charlotte@gmail.com",
//                    "Charlotte",
//                    "Isabella",
//                    "CharlotteIsabella"
//
//            );
//
            repository.saveAll(
                    List.of(John, Bob)
            );
        };
    }

}
