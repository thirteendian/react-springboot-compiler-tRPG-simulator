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

import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.GameFilterDto;
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
public interface GameService {
  
  Game createNewGame(final GameDto gameDto);

  List<Game> filterGame(final GameFilterDto gameFilterDto);

  Game joinGame(final GameDto gameDto);

  boolean checkPassowrd(final Long id, final String password);
  
  void deleteGame(final Game game);
    
}
