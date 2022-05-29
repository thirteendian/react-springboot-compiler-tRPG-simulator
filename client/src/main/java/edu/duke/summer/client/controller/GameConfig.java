package edu.duke.summer.client.controller;


import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameConfig {

    @Bean
    CommandLineRunner commandLineRunnerGame(GameRepository repository){
        return args -> {
            Game marianGame = new Game(
                    "Marian@gmail.com",
                    3,
                    "Marian's Game"
            );

            Game alexGame = new Game(
                    "alex@gmail.com",
                    3,
                    "alex's Game"
            );

            repository.saveAll(
                    List.of(marianGame, alexGame)
            );
        };
    }
}
