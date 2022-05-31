package edu.duke.summer.client.service;

import java.util.*;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.repository.DiceRollingRepository;
import edu.duke.summer.client.database.model.Visibility;
import edu.duke.summer.client.database.repository.VisibilityRepository;
import edu.duke.summer.client.database.model.MagicCheck;
import edu.duke.summer.client.database.repository.MagicCheckRepository;

import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.maxmind.geoip2.DatabaseReader;

import edu.duke.summer.client.algorithm.*;

@Service
@Transactional
public class GameServiceImpl implements GameService {

  private DiceRollingRepository diceRollingRepository;

  private VisibilityRepository visibilityRepository;


  private MagicCheckRepository magicCheckRepository;

  @Autowired
  private GameRepository gameRepository;

  private EvalServicempl evalService;

  @Override
  public Game createNewGame(final GameDto gameDto) {
    if (gameRepository.existsById(gameDto.getId())) {
      throw new IllegalArgumentException("Game ID already exists!");
    }
    final Game game = new Game();
    game.setId(gameDto.getId());
    game.setCreatorEmail(gameDto.getCreatorEmail());
    game.setGameName(gameDto.getGameName());
    game.setPlayerNum(gameDto.getPlayerNum());
    return gameRepository.save(game);
  }

  @Override
  public List<Game> filterGame(final GameFilterDto gameFilterDto) {
    List<Game> gameFilterById = new ArrayList<>();
    List<Game> gameFilterByEmail = new ArrayList<>();
    List<Game> gameFilterByName = new ArrayList<>();
    if (gameFilterDto.getId() != null) {
      gameFilterById = gameRepository.findByIdStartsWith(gameFilterDto.getId());
      if (gameFilterById.isEmpty()) {
        return null;
      }
    }
    if (gameFilterDto.getCreatorEmail() != null) {
      gameFilterByEmail = gameRepository.findByCreatorEmailStartsWith(gameFilterDto.getCreatorEmail());
      if (gameFilterByEmail.isEmpty()) {
        return null;
      }
    }
    if (gameFilterDto.getGameName() != null) {
      gameFilterByName = gameRepository.findByGameNameStartsWith(gameFilterDto.getGameName());
      if (gameFilterByName.isEmpty()) {
        return null;
      }
    }
    List<Game> gameList = new ArrayList<>();
    if (!gameFilterById.isEmpty()) {
      gameList = gameFilterById;
    }
    if (!gameFilterByEmail.isEmpty()) {
      if (gameList.isEmpty()) {
        gameList = gameFilterByEmail;
      }
      else {
        gameList.retainAll(gameFilterByEmail);
      }
    }
    if (!gameFilterByName.isEmpty()) {
      if (gameList.isEmpty()) {
        gameList = gameFilterByName;
      }
      else {
        gameList.retainAll(gameFilterByName);
      }
    }
    return gameList;
  }

  @Override
  public Game joinGame(final GameDto gameDto) {
    if (!gameRepository.existsById(gameDto.getId())) {
      throw new IllegalArgumentException("Game does not exists!");
    }
    Game game = gameRepository.findById(gameDto.getId());
    return game;
  }


  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }
  @Override
  public DiceRolling getDiceRollingResults(DiceRollingDto diceRollingDto) {
    MagicCheck magicCheck = new MagicCheck();
    magicCheck.setId(diceRollingDto.getId());
    magicCheck.setGame(diceRollingDto.getGame());
    magicCheck.setUserEmail(diceRollingDto.getUserEmail());
    magicCheck.setData(diceRollingDto.getRawData());
    magicCheckRepository.save(magicCheck);
    for (String visible : diceRollingDto.getVisibles()) {
      Visibility visibility = new Visibility();
      visibility.setGameId(diceRollingDto.getGame());
      visibility.setPlayerId(visible);
      visibility.setResultId(diceRollingDto.getId());
      visibilityRepository.save(visibility);
    }
    String rawData = diceRollingDto.getRawData();
    String result = evalService.EvalRoll(rawData, new HashMap<>(), new Random()).toString();
    final DiceRolling diceRolling = new DiceRolling();
    diceRolling.setId(diceRollingDto.getId());
    diceRolling.setGame(diceRollingDto.getGame());
    diceRolling.setUserEmail(diceRollingDto.getUserEmail());
    diceRolling.setResult(result);
    return diceRollingRepository.save(diceRolling);
  }

  @Override
  public List<DiceRolling> getPlayerResults(String game, String player) {
    List<Visibility> visibles = visibilityRepository.findTop20RecentResults(game, player);
    List<DiceRolling> results = new ArrayList<>();
    for (Visibility visible : visibles) {
      results.add(diceRollingRepository.findById(visible.getResultId()));
    }
    return results;
  }

  public MagicCheck getMagicCheckData(String id) {
    MagicCheck magicCheck = magicCheckRepository.findById(id);
    return magicCheck;
  }

}
