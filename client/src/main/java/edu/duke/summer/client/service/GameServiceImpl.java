package edu.duke.summer.client.service;

import java.util.*;
import javax.transaction.Transactional;

import edu.duke.summer.client.algorithm.astnode.RuleInfo;
import edu.duke.summer.client.algorithm.astnode.TypeDefNode;
import edu.duke.summer.client.database.model.*;
import edu.duke.summer.client.database.repository.*;

import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.maxmind.geoip2.DatabaseReader;

import edu.duke.summer.client.algorithm.*;

@Service
public class GameServiceImpl implements GameService {
  @Autowired
  private DiceRollingRepository diceRollingRepository;

  @Autowired
  private VisibilityRepository visibilityRepository;

  @Autowired
  private PlayerRepository playerRepository;

  @Autowired
  private MagicCheckRepository magicCheckRepository;

  @Autowired
  private GameRepository gameRepository;

  @Autowired
  private ObjectFieldRepository objectFieldRepository;

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
    return gameRepository.findById(gameDto.getId());
  }


  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }

  @Override
  public DiceRolling getDiceRollingResults(DiceRollingDto diceRollingDto) {
    if (diceRollingDto.getMagicCheck()) {
      System.out.println("");
      saveMagicCheck(diceRollingDto);
    }
    return saveDiceRollingResults(diceRollingDto);
  }

  public void saveMagicCheck(DiceRollingDto diceRollingDto) {
    MagicCheck magicCheck = new MagicCheck();
    magicCheck.setGame(diceRollingDto.getGame());
    magicCheck.setPlayer(diceRollingDto.getPlayer());
    magicCheck.setData(diceRollingDto.getRawData());
    magicCheckRepository.save(magicCheck);
  }

  public void saveVisibilities(DiceRollingDto diceRollingDto, String result) {
    for (String visible : diceRollingDto.getVisibles()) {
      Visibility visibility = new Visibility();
      visibility.setGame(diceRollingDto.getGame());
      visibility.setPlayer(visible);
      visibility.setResult(result);
      visibilityRepository.save(visibility);
    }
  }

  public DiceRolling saveDiceRollingResults(DiceRollingDto diceRollingDto) {
    String rawData = diceRollingDto.getRawData();
    EvalServicempl evalService = new EvalServicempl();
    String result = evalService.EvalRoll(rawData, new HashMap<>(), new Random()).toString();
    final DiceRolling diceRolling = new DiceRolling();
    diceRolling.setGame(diceRollingDto.getGame());
    diceRolling.setPlayer(diceRollingDto.getPlayer());
    diceRolling.setResult(result);
    diceRollingRepository.save(diceRolling);
    saveVisibilities(diceRollingDto, diceRolling.getId());
    return diceRolling;
  }

  @Override
  public List<DiceRolling> getPlayerResults(String game, String player) {
    List<Visibility> visibles = visibilityRepository.findTop20RecentResults(game, player);
    List<DiceRolling> results = new ArrayList<>();
    for (Visibility visible : visibles) {
      results.add(diceRollingRepository.findById(visible.getResult()));
    }
    return results;
  }
  @Override
  public List<MagicCheck> getMagicCheckData(String game, String player) {
    return magicCheckRepository.findMagicCheckData(game, player);
  }

  @Override
  public List<Player> getAllPlayers(String game) {
    return playerRepository.findAllByGame(game);
  }

  public RuleInfo createObjects(String gameId, String code) {
    EvalServicempl evalService = new EvalServicempl();
    RuleInfo ruleInfo = evalService.SaveRules(code);
    HashMap<String, TypeDefNode> types = ruleInfo.getTypes();
    for (String type : types.keySet()) {
      TypeDefNode typeDefNode = types.get(type);
      HashMap<String, String> fields = typeDefNode.getTypeFields();
      int fieldNum = 0;
      for (String field : fields.keySet()) {
        final ObjectField objectField = new ObjectField();
        objectField.setGameId(gameId);
        objectField.setTypeName(typeDefNode.getTypeId());
        objectField.setFieldNum(String.valueOf(fieldNum++));
        objectField.setFieldName(field);
        objectField.setFieldType(fields.get(field));
        objectFieldRepository.save(objectField);
      }
    }
    return ruleInfo;
  }

}
