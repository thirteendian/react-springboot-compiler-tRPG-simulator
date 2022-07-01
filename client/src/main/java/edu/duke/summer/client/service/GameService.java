package edu.duke.summer.client.service;

import java.util.List;
import javax.transaction.Transactional;

import edu.duke.summer.client.algorithm.astnode.RuleInfo;
import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.MagicCheck;
import edu.duke.summer.client.database.model.Player;
import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
  
  Game createNewGame(final GameDto gameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Game joinGame(final GameDto gameDto);

  void deleteGame(final Game game);

  /**
   * Get result of the dice-rolling
   *
   * @param diceRollingDto the diceRollingDto contains information of player, game and raw string with visibilities and the choice of magicCheck
   *        diceRollingDto {
   *          game: the game that the player is involved in
   *          player: the player who did this dice-rolling
   *          rawData: the raw string of this dice-rolling
   *          visibles: which players could view this dice-rolling result
   *          magicCheck: whether this dice-rolling would conduct magicCheck or not
   *        }
   * @return result of dice-rolling after parsing
   */
  DiceRolling getDiceRollingResults(DiceRollingDto diceRollingDto);


  /**
   * Get the recent 20 visible dice-rolling results of one player in the game
   *
   * @param game the game that the player is involved in
   * @param player the player that seek for recent 20 visible dice-rolling results
   * @return recent 20 visible dice-rolling results
   */
  List<DiceRolling> getPlayerResults(String game, String player);

  /**
   * Get the magic check of one player in the game
   *
   * @param game the game that the player is involved in
   * @param player the player that seek for magic check
   * @return list of magic check
   */
  List<MagicCheck> getMagicCheckData(String game, String player);

  /**
   * Get all players that are involved in the game
   *
   * @param game the game that the player is involved in
   * @return list of players in the game
   */
  List<Player> getAllPlayers(String game);

  /**
   * Create and store objects through the code provided by the game creator
   *
   * @param gameId the game that the creator is involved in
   * @param code the code that contains the description of objects
   */
  RuleInfo createObjects(String gameId, String code);

}
