package edu.duke.summer.client.service;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
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
    final Game game = new Game();
    game.setId(gameDto.getId());
    game.setCreatorEmail(gameDto.getCreatorEmail());
    game.setGameName(gameDto.getGameName());
    game.setPassword(passwordEncoder.encode(gameDto.getPassword()));
    return gameRepository.save(game);
  }

  @Override

  public List<Game> filterGame(final GameFilterDto gameFilterDto) {}
  
  @Override
  public Game joinGame(final GameDto gameJoinDto) {}

  @Override
  public boolean checkPassowrd(final String password) {}

  @Override
  public void saveGame(final Game game) {
    gameRepository.save(game);
  }

  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }
    
}
