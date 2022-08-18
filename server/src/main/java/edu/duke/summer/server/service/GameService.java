package edu.duke.summer.server.service;

import java.util.List;

import edu.duke.summer.server.algorithm.FuncCallResult;
import edu.duke.summer.server.database.model.DiceRolling;
import edu.duke.summer.server.dto.*;
import edu.duke.summer.server.database.model.Game;
import edu.duke.summer.server.database.model.MagicCheck;
import edu.duke.summer.server.database.model.Player;
import edu.duke.summer.server.dto.Request.*;
import edu.duke.summer.server.dto.Response.*;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

  CreateGameResponseDto createNewGame(final CreateGameRequestDto createGameRequestDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  JoinGameResponseDto joinGame(final JoinGameRequestDto createGameRequestDto);

  void deleteGame(final Game game);

  GameStartResponseDto startGame(final GameStartRequestDto gameStartRequestDto);

  /**
   * Get all types of objects in the game
   *
   * @param gameId the game to get all types of objects involved in
   * @return list of object types in the game
   */
  List<String> getObjectTypes(String gameId);

  CreateObjectResponseDto createObject(final CreateObjectRequestDto createObjectRequestDto);

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
   * Check whether a new object is required to be created for this object field
   * @param type the type of this object field
   * @return TRUE if this field type is int/string/bool, FALSE otherwise
   */
  Boolean checkWhetherNewObjectRequired(String type);

  /**
   * delete user specified fields of one object
   * @param gameId specify the gameId of delete operation
   * @param objectName specify the object in the game
   * @param toDelete the field name that user wants to delete
   */
  void deleteObjectField(String gameId, String objectName, String toDelete);

  /**
   * add some other fields when the object is already exist
   * @param gameId specify the gameId of the insert operation
   * @param code the code that contains the description of the object and fields
   *             should be the same format as createObjects function
   */
  void addObjectFields(String gameId, String code);

  FuncCallResult callFunction(String gameId, String funcName);

}
