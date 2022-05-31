package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  Game findByGameId(Long id);

  boolean existsById(Long id);

  List<Game> findByIdStartsWith(Long id);

  List<Game> findByCreatorEmailStartsWith(String creatorEmail);

  List<Game> findByGameNameStartsWith(String gameName);

  void delete(Game game);


}
