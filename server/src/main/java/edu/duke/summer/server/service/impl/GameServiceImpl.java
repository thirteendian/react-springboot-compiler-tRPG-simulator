package edu.duke.summer.server.service.impl;

import java.util.*;

import edu.duke.summer.server.algorithm.EvalServicempl;
import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.algorithm.TypeInfo;
import edu.duke.summer.server.algorithm.absyn.FieldList;
import edu.duke.summer.server.algorithm.absyn.Ty;
import edu.duke.summer.server.database.model.*;
import edu.duke.summer.server.database.repository.*;
import edu.duke.summer.server.dto.*;
import edu.duke.summer.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  private ObjectFieldTypeRepository objectFieldTypeRepository;

  @Autowired
  private ObjectValueRepository objectValueRepository;

  @Autowired
  private ObjectArrayValueRepository objectArrayValueRepository;

  @Override
  public Game createNewGame(final CreateGameDto createGameDto) {
    if (gameRepository.existsById(createGameDto.getId())) {
      throw new IllegalArgumentException("Game ID already exists!");
    }
    final Game game = new Game();
    game.setId(createGameDto.getId());
    game.setCreatorEmail("0");
    game.setGameName(createGameDto.getGameName());
    game.setPlayerNum(createGameDto.getPlayerNum());
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
  public Game joinGame(final CreateGameDto createGameDto) {
    if (!gameRepository.existsById(createGameDto.getId())) {
      throw new IllegalArgumentException("Game does not exists!");
    }
    return gameRepository.findById(createGameDto.getId());
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
        //System.out.println(type);
        TypeInfo typeDefNode = types.get(type);
        FieldList fields = typeDefNode.getFields();
        traverseFields(gameId, type, 0, fields);
        //System.out.println();
      }
    }
  }

  public void traverseFields(String gameId, String typeName, int fieldNum, FieldList fields) {
    if (fields != null) {
      //System.out.println("fieldName: " + fields.getName().toString());
//      Ty ty  =fields.getType();
//      String fieldType = traverseTypes(ty);
//      ObjectField objectField = new ObjectField();
//      objectField.setGameId(gameId);
//      objectField.setTypeName(typeName);
//      objectField.setFieldNum(Integer.toString(fieldNum++));
//      objectField.setFieldName(fields.getName().toString());
//      objectField.setFieldType(fieldType);
//      objectFieldRepository.save(objectField);
//      traverseFields(gameId, typeName, fieldNum, fields.getTail());
    }
  }

  public String traverseTypes(Ty ty) {
    //System.out.println("k: " + ty.getKey());
    ObjectFieldType objectFieldType = new ObjectFieldType();
    objectFieldType.setK(ty.getKey());
    if (ty.getName() != null) {
      //System.out.println("name: " + ty.getName());
      objectFieldType.setName(ty.getName());
      objectFieldTypeRepository.save(objectFieldType);
    }
    else {
      //System.out.println("elem: ");
      Ty elem = ty.getElem();
      String elemId = traverseTypes(elem);
      objectFieldType.setElem(elemId);
      objectFieldTypeRepository.save(objectFieldType);
    }
    return objectFieldType.getId();
  }

  public List<String> getObjectsList(String gameId) {
    List<String> objectsList = objectFieldRepository.getAllTypeName(gameId);
    return objectsList;
  }

  public ObjectFieldDto getObjectFields(String gameId, String typeName) {
    ObjectFieldDto objectFieldDto = new ObjectFieldDto();
    objectFieldDto.setGameId(gameId);
    objectFieldDto.setTypeName(typeName);
    List<String> objectIdList = objectValueRepository.findIdList(gameId, typeName);
    if (!objectIdList.isEmpty()) {
      objectFieldDto.addObjectIdList(typeName, objectIdList);
    }
    List<ObjectField> objectFields = objectFieldRepository.findObjectFieldList(gameId, typeName);
    for (ObjectField objectField : objectFields) {
      objectFieldDto.addObjectField(objectField.getFieldName());
      String fieldTypeId = objectField.getFieldType();
      ObjectFieldType objectFieldType = objectFieldTypeRepository.findById(fieldTypeId);
      ObjectFieldTypeDto objectFieldTypeDto = saveObjectFieldTypeToDto(objectFieldType);
      objectFieldDto.addFieldType(objectField.getFieldName(), objectFieldTypeDto);
    }
    return objectFieldDto;
  }

  private ObjectFieldTypeDto saveObjectFieldTypeToDto(ObjectFieldType objectFieldType) {
    ObjectFieldTypeDto objectFieldTypeDto = new ObjectFieldTypeDto();
    objectFieldTypeDto.setId(objectFieldType.getId());
    objectFieldTypeDto.setK(objectFieldType.getK());
    if(!objectFieldType.getName().equals("null")) {
      objectFieldTypeDto.setName(objectFieldType.getName());
    }
    else {
      String fieldElemId = objectFieldType.getElem();
      ObjectFieldType elem = objectFieldTypeRepository.findById(fieldElemId);
      ObjectFieldTypeDto fieldElem= saveObjectFieldTypeToDto(elem);
      objectFieldTypeDto.setElem(fieldElem);
    }
    return objectFieldTypeDto;
  }

  public Boolean checkWhetherNewObjectRequired(String type) {
    if (type.equals("int") || type.equals("string") || type.equals("bool")) {
      return true;
    }
    return false;
  }

  public void deleteObjectField(String gameId, String objectName, String toDelete){
    ObjectField objectField = objectFieldRepository.findObjectField(gameId, objectName, toDelete);
    String fieldTypeId = objectField.getFieldType();
    String fieldNum = objectField.getFieldNum();
    int fieldNumInt = Integer.parseInt(fieldNum);
    ObjectFieldType objectFieldType = objectFieldTypeRepository.findById(fieldTypeId);
    while(!objectFieldType.getElem().equals("null")) {
      String elem = objectFieldType.getElem();
      objectFieldTypeRepository.delete(objectFieldType);
      objectFieldType = objectFieldTypeRepository.findById(elem);
    }
    objectFieldTypeRepository.delete(objectFieldType);
    objectFieldRepository.delete(objectField);
    List<ObjectField> objectFields = objectFieldRepository.findObjectFieldList(gameId, objectName);
    for (ObjectField field: objectFields) {
      int currFieldNum = Integer.parseInt(field.getFieldNum());
      if(currFieldNum<fieldNumInt) continue;
      ObjectField newObjectField = new ObjectField(gameId, objectName,
              Integer.toString(currFieldNum-1), field.getFieldName(), field.getFieldType());
      objectFieldRepository.delete(field);
      objectFieldRepository.save(newObjectField);
    }
    //todo delete values
  }

  public void addObjectFields(String gameId, String code){
    EvalServicempl evalService = new EvalServicempl();
    RuleInfo ruleInfo = evalService.saveRules(code);
    HashMap<String, TypeInfo> objects = ruleInfo.getTypes();
    for(String objectName: objects.keySet()) {
      if(!objectName.equals("int") && !objectName.equals("boolean") && !objectName.equals("string")) {
        TypeInfo typeDefNode = objects.get(objectName);
        FieldList fields = typeDefNode.getFields();
        List<ObjectField> objectFields = objectFieldRepository.findObjectFieldList(gameId, objectName);
        ObjectField lastObjectField = objectFields.get(objectFields.size()-1);
        int lastIndex = Integer.parseInt(lastObjectField.getFieldNum());
        traverseFields(gameId, objectName, lastIndex+1, fields);
      }
    }
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
