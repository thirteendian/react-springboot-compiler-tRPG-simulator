package edu.duke.summer.client.service;

import java.util.List;
import java.util.ArrayList;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.repository.DiceRollingRepository;

import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GameServiceImpl implements GameService {


  private GameRepository gameRepository;

  private DiceRollingRepository diceRollingRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public Game createNewGame(final GameDto gameDto) {
    if (gameRepository.existsById(gameDto.getId())) {
      throw new IllegalArgumentException("Game ID already exists!");
    }
    final Game game = new Game();
    game.setId(gameDto.getId());
    game.setCreatorEmail(gameDto.getCreatorEmail());
    game.setGameName(gameDto.getGameName());
    game.setPassword(passwordEncoder.encode(gameDto.getPassword()));
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
    Game game = gameRepository.findByid(gameDto.getId());
    return game;
  }

  @Override
  public boolean checkPassowrd(final Long id, final String password) {
    if (password != null) {
      Game game = gameRepository.findByid(id);
      if (!passwordEncoder.matches(password, game.getPassword())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }

  @Override
  public List<String> getDiceRollingResults(String game, String user) {
    List<String> results = diceRollingRepository.findTop20RecentResults(game, user);
    return results;
  }
    
}
