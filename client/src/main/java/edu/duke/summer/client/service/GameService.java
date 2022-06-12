package edu.duke.summer.client.service;

import java.util.List;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.MagicCheck;
import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface GameService {
  
  Game createNewGame(final GameDto gameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Game joinGame(final GameDto gameDto);

  void deleteGame(final Game game);

  /**
   * @param diceRollingDto
   * @return
   */
  DiceRolling getDiceRollingResults(DiceRollingDto diceRollingDto);

  List<DiceRolling> getPlayerResults(String game, String userEmail);

  MagicCheck getMagicCheckData(String id);
    
}
