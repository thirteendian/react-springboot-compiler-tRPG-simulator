package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


public interface GameRepository extends JpaRepository<Game, Long> {

  Optional<Game> findById(Long id);

  boolean existsById(Long id);

  List<Game> findByIdStartsWith(Long id);

  List<Game> findByCreatorEmailStartsWith(String creatorEmail);

  List<Game> findByGameNameStartsWith(String gameName);

  void delete(Game game);


}
