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

  /**
   * Return all available game that: 1.not full, 2.not started, 3. I'm not joined before
   */
  GetAllAvailableGameForJoinResponseDto getAllAvailableGameForJoin(GetAllAvailableGameForJoinRequestDto getAllAvailableGameForJoinRequestDto);

  /**
   * Get All Joined Game(for Loading previous unfinished joined game)
   * Return all game that: 1.joined before, 2.not start
   */
  GetAllJoinedGameResponseDto getAllJoinedGameDto(GetAllJoinedGameRequestDto getAllJoinedGameRequestDto);

  /**
   * Quit Game(refresh player status, game status, and all other related status)
   */
  void quitGame(QuitGameRequestDto quitGameRequestDto);

  /**
   * TODO: Get Game Info(get all my owned objects, functions, List of dice rolling results, saved check, again)
   */
  GetGameInfoResponseDto getGameInfo(GetGameInfoRequestDto getGameInfoRequestDto);


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
   * @param getAllPlayersRequestDto contains gameId of the game
   * @return list of players in the game
   */
  GetAllPlayersResponseDto getAllPlayers(GetAllPlayersRequestDto getAllPlayersRequestDto);

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

  CallFunctionResponseDto callFunction(CallFunctionRequestDto callFunctionRequestDto);

  ReCallFunctionResponseDto reCallFunction(ReCallFunctionRequestDto reCallFunctionRequestDto);

}
