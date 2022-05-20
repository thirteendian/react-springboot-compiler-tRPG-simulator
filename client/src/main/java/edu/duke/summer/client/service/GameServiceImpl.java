package edu.duke.summer.client.service;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxmind.geoip2.DatabaseReader;

@Service
@Transactional
public class GameServiceImpl implements GameService {

  @Autowired
  private GameRepository gameRepository;

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
    Game game = gameRepository.findById(gameDto.getId()));
    return game;
  }

  @Override
  public boolean checkPassowrd(final Long id, final String password) {
    if (passowrd != null) {
      Game game = gameRepository.findById(id);
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
    
}
