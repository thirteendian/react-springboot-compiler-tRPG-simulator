package edu.duke.summer.server.config;

import edu.duke.summer.server.database.model.Player;
import edu.duke.summer.server.database.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunnerPlayer(PlayerRepository repository){
        return args -> {
            Player John = new Player(
                    "1",
                    "40289f10810caba101810caba5160000"

            );

            Player Bob = new Player(
                    "1",
                    "40289f10810caba101810caba5170001"


            );

            Player Steven = new Player(
                    "1",
                    "40289f10810caba101810caba5170002"

            );

            Player Michael = new Player(
                    "2",
                    "40289f10810caba101810caba5170003"

            );

            Player Emma = new Player(
                    "2",
                    "40289f10810caba101810caba5170004"
            );

            Player Charlotte = new Player(
                    "2",
                    "40289f10810caba101810caba5170005"

            );

            repository.saveAll(
                    List.of(John, Bob, Steven, Michael, Emma, Charlotte)
            );
        };
    }

}
