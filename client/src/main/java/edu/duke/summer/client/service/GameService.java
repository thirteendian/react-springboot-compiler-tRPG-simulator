package edu.duke.summer.client.service;

import java.util.List;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;

import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface GameService {
  
  Game createNewGame(final GameDto gameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Game joinGame(final GameDto gameDto);

  boolean checkPassowrd(final Long id, final String password);
  
  void deleteGame(final Game game);
    
}
