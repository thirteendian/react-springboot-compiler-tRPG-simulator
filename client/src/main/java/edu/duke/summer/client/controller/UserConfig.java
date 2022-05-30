package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            User John = new User(
                    "John@gmail.com",
                    "John",
                    "Alex",
                    "JohnAlex"

            );

            User Bob = new User(
                    "Bob@gmail.com",
                    "Bob",
                    "Dylan",
                    "BobDylan"

            );

            User Steven = new User(
                    "Steven@gmail.com",
                    "Steven",
                    "Tyler",
                    "StevenTyler"

            );

            User Michael = new User(
                    "Michael@gmail.com",
                    "Michael",
                    "Joseph",
                    "MichaelJoseph"

            );

            User Emma = new User(
                    "Emma@gmail.com",
                    "Emma",
                    "Olivia",
                    "EmmaOlivia"

            );

            User Charlotte = new User(
                    "Charlotte@gmail.com",
                    "Charlotte",
                    "Isabella",
                    "CharlotteIsabella"

            );

            repository.saveAll(
                    List.of(John, Bob, Steven, Michael, Emma, Charlotte)
            );
        };
    }

}
