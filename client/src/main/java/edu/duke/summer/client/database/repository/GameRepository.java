package edu.duke.summer.client.database.repository;

import edu.duke.summer.client.database.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

  Game findById(Long id); 

  boolean existsById(Long id);

  List<Game> findByCreatorEmail(String creatorEmail);

  List<Game> findByGameName(String gameName);

  void delete(Game game);

}
