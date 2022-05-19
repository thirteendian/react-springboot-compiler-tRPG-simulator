package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface GameRepository extends JpaRepository<Game, Long> {

  Game findById(Long id); 

  List<Game> findByCreatorEmail(String creatorEmail);

  List<Game> findByGameName(String gameName);

  @Override
  void delete(Game game);

}
