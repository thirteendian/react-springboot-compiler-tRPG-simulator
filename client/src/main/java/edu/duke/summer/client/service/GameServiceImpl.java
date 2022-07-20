package edu.duke.summer.client.service;

import java.util.*;
import javax.transaction.Transactional;

import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.absyn.TypeDec;
import edu.duke.summer.client.database.model.*;
import edu.duke.summer.client.database.repository.*;

import edu.duke.summer.client.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.duke.summer.client.algorithm.*;
import edu.duke.summer.client.algorithm.absyn.*;

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

  @Autowired
  private ObjectValueRepository objectValueRepository;

  @Autowired
  private ObjectArrayValueRepository objectArrayValueRepository;

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
    String result = evalService.evalRoll(rawData, new HashMap<>(), new Random()).toString();
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

  public void createObjects(String gameId, String code) {
    EvalServicempl evalService = new EvalServicempl();
    RuleInfo ruleInfo = evalService.saveRules(code);
    HashMap<String, TypeInfo> types = ruleInfo.getTypes();
    for (String type : types.keySet()) {
      if (!type.equals("int") && !type.equals("boolean") && !type.equals("string")) {
        System.out.println(type);
        TypeInfo typeDefNode = types.get(type);
        //Ty ty = typeDefNode.getTy();
        //FieldList fieldList = ((FieldsTy)ty).getFieldList();
        //System.out.println(fieldList.getName().toString());
        //System.out.println(fieldList.getTyp().toString());
        //if (fieldList.getTail() != null) {
          //FieldList tail = fieldList.getTail();
          //System.out.println(tail.getName().toString());
          //System.out.println(tail.getTyp().toString());
        //}
        System.out.println();
      }
      break;
    }
  }

  public List<String> getObjectsList(String gameId) {
    List<String> objectsList = objectFieldRepository.findObjectType(gameId);
    return objectsList;
  }

  public ObjectFieldDto getObjectFields(String gameId, String typeName) {
    ObjectFieldDto objectFieldDto = new ObjectFieldDto();
    objectFieldDto.setTypeName(typeName);
    List<ObjectField> objectFields = objectFieldRepository.findObjectField(gameId, typeName);
    for (ObjectField objectField : objectFields) {
      objectFieldDto.addObjectField(objectField.getFieldName());
      objectFieldDto.addFieldType(objectField.getFieldName(), objectField.getFieldType());
    }
    return objectFieldDto;
  }

  public Boolean checkWhetherNewObjectRequired(String type) {
    if (type.equals("int") || type.equals("string") || type.equals("bool")) {
      return true;
    }
    return false;
  }

  public String saveObjects(ObjectValueDto objectValueDto) {
    List<String> fieldValues = objectValueDto.getFieldValue();
    int fieldNum = 0;
    for (String value : fieldValues) {
      final ObjectValue objectValue = new ObjectValue();
      objectValue.setGameId(objectValueDto.getGameId());
      objectValue.setTypeName(objectValueDto.getTypeName());
      objectValue.setValueNum(objectValueDto.getValueNum());
      objectValue.setFieldNum(String.valueOf(fieldNum++));
      if (value.equals("true") || value.equals("false")) {
        objectValue.setBoolVal(value);
      }
      else {
        try {
          int val = Integer.parseInt(value);
          objectValue.setIntVal(value);
        } catch (NumberFormatException nfe) {
          objectValue.setStringVal(value);
        }
      }
      objectValueRepository.save(objectValue);
    }
    return objectValueDto.getValueNum();
  }

  public String saveArrays(ObjectValueDto objectValueDto) {
    List<String> fieldValues = objectValueDto.getFieldValue();
    int index = 0;
    for (String value : fieldValues) {
      final ObjectArrayValue objectArrayValue = new ObjectArrayValue();
      objectArrayValue.setGameId(objectValueDto.getGameId());
      objectArrayValue.setEltType(objectValueDto.getTypeName());
      objectArrayValue.setValueNum(objectValueDto.getValueNum());
      objectArrayValue.setIndex(String.valueOf(index++));
      if (value.equals("true") || value.equals("false")) {
        objectArrayValue.setBoolVal(value);
      }
      else {
        try {
          int val = Integer.parseInt(value);
          objectArrayValue.setIntVal(value);
        } catch (NumberFormatException nfe) {
          objectArrayValue.setStringVal(value);
        }
      }
      objectArrayValueRepository.save(objectArrayValue);
    }
    return objectValueDto.getValueNum();
  }

  public ObjectValueDto getObjectValues(String gameId, String typeName, String valueNum) {
    List<ObjectValue> objectValues = objectValueRepository.findObjectValue(gameId, typeName, valueNum);
    if (objectValues.isEmpty()) {
      return null;
    }
    ObjectValueDto objectValueDto = new ObjectValueDto();
    objectValueDto.setGameId(objectValues.get(0).getGameId());
    objectValueDto.setTypeName(objectValues.get(0).getTypeName());
    objectValueDto.setValueNum(objectValues.get(0).getValueNum());
    for(ObjectValue objectValue : objectValues) {
      if (!objectValue.getIntVal().equals("null")) {
        objectValueDto.addFieldValue(objectValue.getIntVal());
      }
      else if (!objectValue.getStringVal().equals("null")) {
        objectValueDto.addFieldValue(objectValue.getStringVal());
      }
      else {
        objectValueDto.addFieldValue(objectValue.getBoolVal());
      }
    }
    return objectValueDto;
  }

  public ObjectValueDto getArrayValues(String gameId, String valueNum) {
    List<ObjectArrayValue> arrayValues = objectArrayValueRepository.findArrayValue(gameId, valueNum);
    if (arrayValues.isEmpty()) {
      return null;
    }
    ObjectValueDto objectValueDto = new ObjectValueDto();
    objectValueDto.setGameId(arrayValues.get(0).getGameId());
    objectValueDto.setTypeName(arrayValues.get(0).getEltType());
    objectValueDto.setValueNum(arrayValues.get(0).getValueNum());
    for(ObjectArrayValue arrayValue : arrayValues) {
      if (!arrayValue.getIntVal().equals("null")) {
        objectValueDto.addFieldValue(arrayValue.getIntVal());
      }
      else if (!arrayValue.getStringVal().equals("null")) {
        objectValueDto.addFieldValue(arrayValue.getStringVal());
      }
      else {
        objectValueDto.addFieldValue(arrayValue.getBoolVal());
      }
    }
    return objectValueDto;
  }
}
