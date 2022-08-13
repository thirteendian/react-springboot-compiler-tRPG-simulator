package edu.duke.summer.server.config;


import edu.duke.summer.server.database.model.Game;
import edu.duke.summer.server.database.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GameConfig {

    @Bean
    CommandLineRunner commandLineRunnerGame(GameRepository repository){
//        return args -> {
//            Game marianGame = new Game(
//                    "Marian@gmail.com",
//                    4,
//                    "Marian's Game"
//            );
//
//            Game alexGame = new Game(
//                    "alex@gmail.com",
//                    5,
//                    "Mariam's Game"
//            );
//
//            repository.saveAll(
//                    List.of(marianGame, alexGame)
//            );
//        };
        return null;
    }
}
