package edu.duke.summer.server.service.impl;

import java.util.*;

import edu.duke.summer.server.algorithm.RuleInfo;
import edu.duke.summer.server.database.model.*;
import edu.duke.summer.server.database.repository.*;

import edu.duke.summer.server.dto.*;
import edu.duke.summer.server.dto.Object.ObjectDto;
import edu.duke.summer.server.dto.Object.ObjectFieldTypeDto;
import edu.duke.summer.server.dto.Request.CreateGameRequestDto;
import edu.duke.summer.server.dto.Request.GameStartRequestDto;
import edu.duke.summer.server.dto.Request.JoinGameRequestDto;
import edu.duke.summer.server.dto.Request.CreateObjectRequestDto;
import edu.duke.summer.server.dto.Response.CreateGameResponseDto;
import edu.duke.summer.server.dto.Response.CreateObjectResponseDto;
import edu.duke.summer.server.dto.Response.GameStartResponseDto;
import edu.duke.summer.server.dto.Response.JoinGameResponseDto;
import edu.duke.summer.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.duke.summer.server.algorithm.*;
import edu.duke.summer.server.algorithm.absyn.*;

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
  private GameCodeRepository gameCodeRepository;

  @Autowired
  private ObjectFieldRepository objectFieldRepository;

  @Autowired
  private ObjectFieldTypeRepository objectFieldTypeRepository;

  @Autowired
  private ObjectValueRepository objectValueRepository;

  @Autowired
  private ObjectArrayValueRepository objectArrayValueRepository;

  @Autowired
  private FunctionInfoRepository functionInfoRepository;

  @Autowired
  private ParamInfoRepository paramInfoRepository;

  @Override
  public CreateGameResponseDto createNewGame(final CreateGameRequestDto createGameRequestDto) {
    Game game = new Game();
    game.setHostUuid(createGameRequestDto.getHostUuid());
    game.setGameName(createGameRequestDto.getGameName());
    game.setPlayerNum(createGameRequestDto.getPlayerNum());
    game.setCode(createGameRequestDto.getCode());
    gameRepository.save(game);
    initializeGame(game.getId(), game.getCode());
    CreateGameResponseDto createGameResponseDto = new CreateGameResponseDto();
    createGameResponseDto.setGameId(game.getId());
    createGameResponseDto.setGameName(createGameRequestDto.getGameName());
    createGameResponseDto.setPlayerNum(createGameRequestDto.getPlayerNum());
    return createGameResponseDto;
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
  public JoinGameResponseDto joinGame(JoinGameRequestDto joinGameRequestDto) {
    if (!gameRepository.existsById(joinGameRequestDto.getGameId())) {
      throw new IllegalArgumentException("Game does not exists!");
    }
    Game game = gameRepository.findById(joinGameRequestDto.getGameId());
    JoinGameResponseDto joinGameResponseDto = new JoinGameResponseDto();
    joinGameResponseDto.setGameName(game.getGameName());
    joinGameResponseDto.setPlayerNum(game.getPlayerNum());
    Player player = new Player();
    player.setGameId(game.getId());
    player.setUserId(joinGameRequestDto.getPlayerUuid());
    playerRepository.save(player);
    return joinGameResponseDto;
  }

  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }

  @Override
  public GameStartResponseDto startGame(GameStartRequestDto gameStartRequestDto) {
    return null;
  }

  @Override
  public CreateObjectResponseDto createObject(CreateObjectRequestDto createObjectRequestDto) {
    return null;
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
  public List<Player> getAllPlayers(String gameId) {
    return playerRepository.findAllByGame(gameId);
  }

  public void initializeGame(String gameId, String code) {
    EvalServicempl evalService = new EvalServicempl();
    RuleInfo ruleInfo = evalService.saveRules(code);
    createObjects(gameId, ruleInfo.getTypes());
    createFunctions(gameId, ruleInfo.getFuncs());
    GameCode gameCode = new GameCode();
    gameCode.setGameId(gameId);
    gameCode.setCode(code);
    gameCodeRepository.save(gameCode);
  }

  public void createObjects(String gameId, HashMap<String, TypeInfo> types) {
    for (String type : types.keySet()) {
      if (!type.equals("int") && !type.equals("boolean") && !type.equals("string") && !type.equals("void")) {
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
      System.out.println("fieldName: " + fields.getName().toString());
      Ty ty  =fields.getType();
      String fieldType = traverseFieldTypes(ty);
      ObjectField objectField = new ObjectField();
      objectField.setGameId(gameId);
      objectField.setTypeName(typeName);
      objectField.setFieldNum(Integer.toString(fieldNum++));
      objectField.setFieldName(fields.getName().toString());
      objectField.setFieldType(fieldType);
      objectFieldRepository.save(objectField);
      traverseFields(gameId, typeName, fieldNum, fields.getTail());
    }
  }

  public String traverseFieldTypes(Ty ty) {
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
      String elemId = traverseFieldTypes(elem);
      objectFieldType.setElem(elemId);
      objectFieldTypeRepository.save(objectFieldType);
    }
    return objectFieldType.getId();
  }

  public void createFunctions(String gameId, HashMap<String, FuncInfo> functions) {
    for (String func : functions.keySet()) {
      FuncInfo funcInfo = functions.get(func);
      String funcName = funcInfo.getFuncName();
      if (!funcName.equals("output") && !funcName.equals("roll") && !funcName.equals("oneUserOption") && !funcName.equals("userOption")) {
        //System.out.println("function name: " + funcInfo.getFuncName());
        FieldList param = funcInfo.getParams();
        traverseParams(gameId, funcName, 0, param);
      }
    }
  }

  public void traverseParams(String gameId, String funcName, int fieldNum, FieldList param) {
    if (param != null) {
      Ty ty  =param.getType();
      String paramType = traverseParamTypes(ty);
      FunctionInfo funcInfo = new FunctionInfo();
      funcInfo.setGameId(gameId);
      funcInfo.setFuncName(funcName);
      funcInfo.setParamNum(Integer.toString(fieldNum++));
      funcInfo.setParamName(param.getName().toString());
      funcInfo.setParamType(paramType);
      functionInfoRepository.save(funcInfo);
      traverseParams(gameId, funcName, fieldNum, param.getTail());
    }
  }

  public String traverseParamTypes(Ty ty) {
    //System.out.println("k: " + ty.getKey());
    ParamInfo paramInfo = new ParamInfo();
    paramInfo.setK(ty.getKey());
    if (ty.getName() != null) {
      //System.out.println("name: " + ty.getName());
      paramInfo.setName(ty.getName());
      paramInfoRepository.save(paramInfo);
    }
    else {
      //System.out.println("elem: ");
      Ty elem = ty.getElem();
      String elemId = traverseParamTypes(elem);
      paramInfo.setElem(elemId);
      paramInfoRepository.save(paramInfo);
    }
    return paramInfo.getId();
  }

  public List<String> getObjectsList(String gameId) {
    List<String> objectsList = objectFieldRepository.getAllTypeName(gameId);
    return objectsList;
  }

  @Override
  public ObjectDto getObjectFields(String gameId, String typeName) {
    return null;
  }

//  public ObjectDto getObjectFields(String gameId, String typeName) {
//    ObjectDto objectDto = new ObjectDto();
//    objectDto.setGameId(gameId);
//    objectDto.setTypeName(typeName);
//    List<String> objectIdList = objectValueRepository.findIdList(gameId, typeName);
//    if (!objectIdList.isEmpty()) {
//      objectDto.addObjectIdList(typeName, objectIdList);
//    }
//    List<ObjectField> objectFields = objectFieldRepository.findObjectFieldList(gameId, typeName);
//    for (ObjectField objectField : objectFields) {
//      objectDto.addObjectField(objectField.getFieldName());
//      String fieldTypeId = objectField.getFieldType();
//      ObjectFieldType objectFieldType = objectFieldTypeRepository.findById(fieldTypeId);
//      ObjectFieldTypeDto objectFieldTypeDto = saveObjectFieldTypeToDto(objectFieldType);
//      objectDto.addFieldType(objectField.getFieldName(), objectFieldTypeDto);
//    }
//    return objectDto;
//  }

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

  @Override
  public String saveObjects(CreateObjectRequestDto createObjectRequestDto) {
    return null;
  }

  @Override
  public String saveArrays(CreateObjectRequestDto createObjectRequestDto) {
    return null;
  }

  @Override
  public CreateObjectRequestDto getObjectValues(String gameId, String typeName, String valueNum) {
    return null;
  }

  @Override
  public CreateObjectRequestDto getArrayValues(String gameId, String valueNum) {
    return null;
  }

//  public String saveObjects(CreateObjectRequestDto createObjectRequestDto) {
//    List<String> fieldValues = createObjectRequestDto.getFieldValue();
//    int fieldNum = 0;
//    for (String value : fieldValues) {
//      final ObjectValue objectValue = new ObjectValue();
//      objectValue.setGameId(createObjectRequestDto.getGameId());
//      objectValue.setTypeName(createObjectRequestDto.getTypeName());
//      objectValue.setValueNum(createObjectRequestDto.getValueNum());
//      objectValue.setFieldNum(String.valueOf(fieldNum++));
//      if (value.equals("true") || value.equals("false")) {
//        objectValue.setBoolVal(value);
//      }
//      else {
//        try {
//          int val = Integer.parseInt(value);
//          objectValue.setIntVal(value);
//        } catch (NumberFormatException nfe) {
//          objectValue.setStringVal(value);
//        }
//      }
//      objectValueRepository.save(objectValue);
//    }
//    return createObjectRequestDto.getValueNum();
//  }

//  public String saveArrays(CreateObjectRequestDto createObjectRequestDto) {
//    List<String> fieldValues = createObjectRequestDto.getFieldValue();
//    int index = 0;
//    for (String value : fieldValues) {
//      final ObjectArrayValue objectArrayValue = new ObjectArrayValue();
//      objectArrayValue.setGameId(createObjectRequestDto.getGameId());
//      objectArrayValue.setEltType(createObjectRequestDto.getTypeName());
//      objectArrayValue.setValueNum(createObjectRequestDto.getValueNum());
//      objectArrayValue.setIndex(String.valueOf(index++));
//      if (value.equals("true") || value.equals("false")) {
//        objectArrayValue.setBoolVal(value);
//      }
//      else {
//        try {
//          int val = Integer.parseInt(value);
//          objectArrayValue.setIntVal(value);
//        } catch (NumberFormatException nfe) {
//          objectArrayValue.setStringVal(value);
//        }
//      }
//      objectArrayValueRepository.save(objectArrayValue);
//    }
//    return createObjectRequestDto.getValueNum();
//  }

//  public CreateObjectRequestDto getObjectValues(String gameId, String typeName, String valueNum) {
//    List<ObjectValue> objectValues = objectValueRepository.findObjectValue(gameId, typeName, valueNum);
//    if (objectValues.isEmpty()) {
//      return null;
//    }
//    CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
//    createObjectRequestDto.setGameId(objectValues.get(0).getGameId());
//    createObjectRequestDto.setTypeName(objectValues.get(0).getTypeName());
//    createObjectRequestDto.setValueNum(objectValues.get(0).getValueNum());
//    for(ObjectValue objectValue : objectValues) {
//      if (!objectValue.getIntVal().equals("null")) {
//        createObjectRequestDto.addFieldValue(objectValue.getIntVal());
//      }
//      else if (!objectValue.getStringVal().equals("null")) {
//        createObjectRequestDto.addFieldValue(objectValue.getStringVal());
//      }
//      else {
//        createObjectRequestDto.addFieldValue(objectValue.getBoolVal());
//      }
//    }
//    return createObjectRequestDto;
//  }

//  public CreateObjectRequestDto getArrayValues(String gameId, String valueNum) {
//    List<ObjectArrayValue> arrayValues = objectArrayValueRepository.findArrayValue(gameId, valueNum);
//    if (arrayValues.isEmpty()) {
//      return null;
//    }
//    CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
//    createObjectRequestDto.setGameId(arrayValues.get(0).getGameId());
//    createObjectRequestDto.setTypeName(arrayValues.get(0).getEltType());
//    createObjectRequestDto.setValueNum(arrayValues.get(0).getValueNum());
//    for(ObjectArrayValue arrayValue : arrayValues) {
//      if (!arrayValue.getIntVal().equals("null")) {
//        createObjectRequestDto.addFieldValue(arrayValue.getIntVal());
//      }
//      else if (!arrayValue.getStringVal().equals("null")) {
//        createObjectRequestDto.addFieldValue(arrayValue.getStringVal());
//      }
//      else {
//        createObjectRequestDto.addFieldValue(arrayValue.getBoolVal());
//      }
//    }
//    return createObjectRequestDto;
//  }

  public void callFunction(String gameId, String funcName) {
    String code = null;
    EvalServicempl evalService = new EvalServicempl();
    FuncCallResult result = evalService.getFunResult(code, funcName, new HashMap<>(), new StateInfo());
  }

  public void callFunction(String gameId, String funcName) {
    String code= gameCodeRepository.findByGameId(gameId).getCode();
    EvalServicempl evalService = new EvalServicempl();
    FuncCallResult result = evalService.getFunResult(code, funcName, new HashMap<>(), new StateInfo());
  }

  public void callFunction(String gameId, String funcName) {
    String code= gameCodeRepository.findByGameId(gameId).getCode();
    EvalServicempl evalService = new EvalServicempl();
    FuncCallResult result = evalService.getFunResult(code, funcName, new HashMap<>(), new StateInfo());
  }
}

