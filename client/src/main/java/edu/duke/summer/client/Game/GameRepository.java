package edu.duke.summer.client.Game;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface GameRepository extends JpaRepository<Game, Id> {

}
