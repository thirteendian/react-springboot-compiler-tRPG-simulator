package edu.duke.summer.server.service.impl;

import java.util.*;

import edu.duke.summer.server.algorithm.*;
import edu.duke.summer.server.algorithm.absyn.FieldList;
import edu.duke.summer.server.algorithm.absyn.Ty;
import edu.duke.summer.server.database.model.*;
import edu.duke.summer.server.database.model.UserDefinedObject;
import edu.duke.summer.server.database.repository.*;
import edu.duke.summer.server.dto.*;
import edu.duke.summer.server.dto.Function.*;
import edu.duke.summer.server.dto.Object.*;
import edu.duke.summer.server.dto.Request.*;
import edu.duke.summer.server.dto.Response.*;
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
  private UserDefinedObjectRepository userDefinedObjectRepository;

  @Autowired
  private ObjectFieldRepository objectFieldRepository;

  @Autowired
  private ObjectFieldTypeRepository objectFieldTypeRepository;

  @Autowired
  private UserDefinedFunctionRepository userDefinedFunctionRepository;
  @Autowired
  private ParameterRepository parameterRepository;

  @Autowired
  private ParamInfoRepository paramInfoRepository;

  @Autowired
  private ObjectValueRepository objectValueRepository;

  @Override
  public CreateGameResponseDto createNewGame(final CreateGameRequestDto createGameRequestDto) {
    Game game = new Game();
    game.setHostUuid(createGameRequestDto.getHostUuid());
    game.setGameName(createGameRequestDto.getGameName());
    game.setPlayerNum(createGameRequestDto.getPlayerNum());
    game.setCurNum(1);
    game.setStatus("preparing");
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
  public GetAllAvailableGameForJoinResponseDto getAllAvailableGameForJoin(GetAllAvailableGameForJoinRequestDto getAllAvailableGameForJoinRequestDto) {
    GetAllAvailableGameForJoinResponseDto getAllAvailableGameForJoinResponseDto = new GetAllAvailableGameForJoinResponseDto();
    String playerId = getAllAvailableGameForJoinRequestDto.getPlayerId();
    List<Game> gameList = gameRepository.findAvailableGames();
    List<AvaliableGameDto> availableGameList = new ArrayList<>();
    for (Game game : gameList) {
      if (playerRepository.findPlayer(game.getId(), playerId) == null) {
        AvaliableGameDto avaliableGameDto = new AvaliableGameDto();
        avaliableGameDto.setGameID(game.getId());
        avaliableGameDto.setGameName(game.getGameName());
        avaliableGameDto.setCreator(game.getHostUuid());
        avaliableGameDto.setNumOfPlayer(game.getPlayerNum());
        avaliableGameDto.setCurrNumOfPlayer(game.getCurNum());
        availableGameList.add(avaliableGameDto);
      }
    }
    getAllAvailableGameForJoinResponseDto.setListOfAvailableGame(availableGameList);
    return getAllAvailableGameForJoinResponseDto;
  }

  @Override
  public GetAllJoinedGameResponseDto getAllJoinedGameDto() {
    return null;
  }

  @Override
  public void quitGame(QuitGameRequestDto quitGameRequestDto) {

  }

  @Override
  public GetGameInfoResponseDto getGameInfo(GetGameInfoRequestDto getGameInfoRequestDto) {
    return null;
  }

  public void initializeGame(String gameId, String code) {
    EvalServicempl evalService = new EvalServicempl();
    RuleInfo ruleInfo = evalService.saveRules(code);
    initializeObjects(gameId, ruleInfo.getTypes());
    initializeFunctions(gameId, ruleInfo.getFuncs());
  }

  public void initializeObjects(String gameId, HashMap<String, TypeInfo> types) {
    for (String type : types.keySet()) {
      if (!type.equals("int") && !type.equals("boolean") && !type.equals("string") && !type.equals("void")) {
        UserDefinedObject userObject = new UserDefinedObject();
        userObject.setGameId(gameId);
        userObject.setObjectName(type);
        userDefinedObjectRepository.save(userObject);
        TypeInfo typeDefNode = types.get(type);
        FieldList fields = typeDefNode.getFields();
        traverseFields(gameId, type, 0, fields);
      }
    }
  }

  public void traverseFields(String gameId, String objectName, int fieldNum, FieldList fields) {
    if (fields != null) {
      Ty ty  =fields.getType();
      String fieldType = traverseFieldTypes(ty);
      ObjectField objectField = new ObjectField();
      objectField.setGameId(gameId);
      objectField.setObjectName(objectName);
      objectField.setFieldNum(Integer.toString(fieldNum++));
      objectField.setFieldName(fields.getName().toString());
      objectField.setFieldType(fieldType);
      objectFieldRepository.save(objectField);
      traverseFields(gameId, objectName, fieldNum, fields.getTail());
    }
  }

  public String traverseFieldTypes(Ty ty) {
    ObjectFieldType objectFieldType = new ObjectFieldType();
    objectFieldType.setK(ty.getKey());
    if (ty.getName() != null) {
      objectFieldType.setName(ty.getName());
      objectFieldTypeRepository.save(objectFieldType);
    }
    else {
      Ty elem = ty.getElem();
      String elemId = traverseFieldTypes(elem);
      objectFieldType.setElem(elemId);
      objectFieldTypeRepository.save(objectFieldType);
    }
    return objectFieldType.getId();
  }

  public void initializeFunctions(String gameId, HashMap<String, FuncInfo> functions) {
    for (String func : functions.keySet()) {
      FuncInfo funcInfo = functions.get(func);
      String funcName = funcInfo.getFuncName();
      if (!funcName.equals("output") && !funcName.equals("roll") && !funcName.equals("oneUserOption") && !funcName.equals("userOption")) {
        UserDefinedFunction userDefinedFunction = new UserDefinedFunction();
        userDefinedFunction.setGameId(gameId);
        userDefinedFunction.setFunctionName(funcName);
        userDefinedFunctionRepository.save(userDefinedFunction);
        FieldList params = funcInfo.getParams();
        traverseParams(gameId, funcName, 0, params);
      }
    }
  }

  public void traverseParams(String gameId, String funcName, int fieldNum, FieldList params) {
    if (params != null) {
      Ty ty  =params.getType();
      String paramType = traverseParamTypes(ty);
      Parameter parameter = new Parameter();
      parameter.setGameId(gameId);
      parameter.setFuncName(funcName);
      parameter.setParamNum(Integer.toString(fieldNum++));
      parameter.setParamName(params.getName().toString());
      parameter.setParamType(paramType);
      parameterRepository.save(parameter);
      traverseParams(gameId, funcName, fieldNum, params.getTail());
    }
  }

  public String traverseParamTypes(Ty ty) {
    ParamInfo paramInfo = new ParamInfo();
    paramInfo.setK(ty.getKey());
    if (ty.getName() != null) {
      paramInfo.setName(ty.getName());
      paramInfoRepository.save(paramInfo);
    }
    else {
      Ty elem = ty.getElem();
      String elemId = traverseParamTypes(elem);
      paramInfo.setElem(elemId);
      paramInfoRepository.save(paramInfo);
    }
    return paramInfo.getId();
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
      gameFilterByEmail = gameRepository.findByHostUuidStartsWith(gameFilterDto.getCreatorEmail());
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
    gameRepository.addPlayer(game.getId());
    return joinGameResponseDto;
  }

  @Override
  public void deleteGame(final Game game) {
    gameRepository.delete(game);
  }

  @Override
  public GameStartResponseDto startGame(GameStartRequestDto gameStartRequestDto) {
    String gameId = gameStartRequestDto.getGameId();
    List<ObjectDto> objects = new ArrayList<>();
    List<UserDefinedObject> userObjectList = userDefinedObjectRepository.findByGameId(gameId);
    for (UserDefinedObject userObject : userObjectList) {
      ObjectDto objectDto = getObjectDto(gameId, userObject);
      objects.add(objectDto);
    }
    List<FunctionDto> functions = new ArrayList<>();
    List<UserDefinedFunction> userFunctionList = userDefinedFunctionRepository.findByGameId(gameId);
    for (UserDefinedFunction userFunction : userFunctionList) {
      FunctionDto functionDto = getFunctionDto(gameId, userFunction);
      functions.add(functionDto);
    }
    return new GameStartResponseDto(objects, functions);
  }

  public ObjectDto getObjectDto(String gameId, UserDefinedObject userObject) {
    ObjectDto objectDto = new ObjectDto();
    objectDto.setId(userObject.getId());
    String objectName = userObject.getObjectName();
    objectDto.setObjectName(objectName);
    List<ObjectField> objectFields = objectFieldRepository.findObjectFields(gameId, objectName);
    for (ObjectField objectField : objectFields) {
      ObjectFieldDto objectFieldDto = getObjectFieldDto(objectField);
      objectDto.addFields(objectFieldDto);
    }
    return objectDto;
  }

  public ObjectFieldDto getObjectFieldDto(ObjectField objectField) {
    ObjectFieldDto objectFieldDto = new ObjectFieldDto();
    objectFieldDto.setId(objectField.getId());
    objectFieldDto.setFieldName(objectField.getFieldName());
    ObjectFieldTypeDto objectFieldTypeDto = getObjectFieldTypeDto(objectFieldTypeRepository.findById(objectField.getFieldType()));
    objectFieldDto.setObjectFieldTypeDto(objectFieldTypeDto);
    return objectFieldDto;
  }

  public ObjectFieldTypeDto getObjectFieldTypeDto(ObjectFieldType objectFieldType) {
    ObjectFieldTypeDto objectFieldTypeDto = new ObjectFieldTypeDto();
    objectFieldTypeDto.setId(objectFieldType.getId());
    objectFieldTypeDto.setK(objectFieldType.getK());
    if (objectFieldType.getName() != null) {
      objectFieldTypeDto.setName(objectFieldType.getName());
    }
    else {
      String nextId = objectFieldType.getElem();
      objectFieldTypeDto.setElem(getObjectFieldTypeDto(objectFieldTypeRepository.findById(nextId)));
    }
    return objectFieldTypeDto;
  }

  public FunctionDto getFunctionDto(String gameId, UserDefinedFunction userFunction) {
    FunctionDto functionDto = new FunctionDto();
    functionDto.setId(userFunction.getId());
    String functionName = userFunction.getFunctionName();
    functionDto.setFunctionName(functionName);
    List<Parameter> parameters = parameterRepository.findParameters(gameId, functionName);
    for (Parameter parameter : parameters) {
      ParamDto paramDto = getParamDto(parameter);
      functionDto.addParams(paramDto);
    }
    return functionDto;
  }

  public ParamDto getParamDto(Parameter parameter) {
    ParamDto paramDto = new ParamDto();
    paramDto.setId(parameter.getId());
    paramDto.setParamName(parameter.getParamName());
    ParamInfoDto paramInfoDto = getParamInfo(paramInfoRepository.findById(parameter.getParamType()));
    paramDto.setParamInfoDto(paramInfoDto);
    return paramDto;
  }

  public ParamInfoDto getParamInfo(ParamInfo paramInfo) {
    ParamInfoDto paramInfoDto = new ParamInfoDto();
    paramInfoDto.setId(paramInfo.getId());
    paramInfoDto.setK(paramInfo.getK());
    if (paramInfo.getName() != null) {
      paramInfoDto.setName(paramInfo.getName());
    }
    else {
      String nextId = paramInfo.getElem();
      paramInfoDto.setElem(getParamInfo(paramInfoRepository.findById(nextId)));
    }
    return paramInfoDto;
  }

  public List<String> getObjectTypes(String gameId) {
    List<UserDefinedObject> userObjects = userDefinedObjectRepository.findByGameId(gameId);
    List<String> objectList = new ArrayList<>();
    for (UserDefinedObject userObject : userObjects) {
      objectList.add(userObject.getObjectName());
    }
    return objectList;
  }

  public CreateObjectResponseDto createObject(final CreateObjectRequestDto createObjectRequestDto) {
    ObjectValue objectValue = new ObjectValue();
    objectValue.setGameId(createObjectRequestDto.getGameId());
    objectValue.setPlayerUuid(createObjectRequestDto.getPlayerUuid());
    objectValue.setObjectName(createObjectRequestDto.getObjectName());
    objectValue.setObjectValue(createObjectRequestDto.getObjectValue());
    objectValueRepository.save(objectValue);
    StringBuilder myObjectList = new StringBuilder();
    myObjectList.append('[');
    List<ObjectValue> objects = objectValueRepository.findMyObjects(createObjectRequestDto.getGameId(), createObjectRequestDto.getPlayerUuid());
    for (ObjectValue object : objects) {
      StringBuilder myObject = new StringBuilder();
      myObject.append('{');
      myObject.append("\"uuid\":\"").append(object.getId()).append("\",");
      myObject.append("\"name\":\"").append(object.getObjectName()).append("\",");
      myObject.append("\"value\":").append(object.getObjectValue());
      myObject.append("}, ");
      myObjectList.append(myObject.toString());
    }
    myObjectList.setCharAt(myObjectList.length() - 2, ']');
    return new CreateObjectResponseDto(myObjectList.substring(0, myObjectList.length() - 2));
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
    return playerRepository.findAllByGameId(game);
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
    List<ObjectField> objectFields = objectFieldRepository.findObjectFields(gameId, objectName);
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
        List<ObjectField> objectFields = objectFieldRepository.findObjectFields(gameId, objectName);
        ObjectField lastObjectField = objectFields.get(objectFields.size()-1);
        int lastIndex = Integer.parseInt(lastObjectField.getFieldNum());
        traverseFields(gameId, objectName, lastIndex+1, fields);
      }
    }
  }

  public FuncCallResult callFunction(String gameId, String funcName) {
    String code = gameRepository.findById(gameId).getCode();
    EvalServicempl evalService = new EvalServicempl();
    FuncCallResult result = evalService.getFunResult(code, funcName, new HashMap<>(), new StateInfo());
    return result;
  }


}
