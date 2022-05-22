package edu.duke.summer.client.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import edu.duke.summer.client.database.model.Game;

import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.maxmind.geoip2.DatabaseReader;

@Service
@Transactional
public interface GameService {

  Game createNewGame(final GameDto gameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Optional<Game> joinGame(final GameDto gameDto);

  void deleteGame(final Game game);

}
