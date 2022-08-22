package edu.duke.summer.server;

import edu.duke.summer.server.algorithm.FuncCallResult;
import edu.duke.summer.server.algorithm.value.StringValue;
import edu.duke.summer.server.algorithm.value.Value;
import edu.duke.summer.server.config.SpringConfig;
import edu.duke.summer.server.database.model.DiceRolling;
import edu.duke.summer.server.database.model.ObjectValue;
import edu.duke.summer.server.database.model.Player;
import edu.duke.summer.server.database.repository.*;
import edu.duke.summer.server.dto.DiceRollingDto;
import edu.duke.summer.server.dto.ObjectValueDto;
import edu.duke.summer.server.dto.Request.*;
import edu.duke.summer.server.dto.Response.*;
import edu.duke.summer.server.service.GameService;
import org.checkerframework.checker.units.qual.C;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class GameServiceTest {
    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ObjectFieldRepository objectFieldRepository;

    @Autowired
    private ObjectFieldTypeRepository objectFieldTypeRepository;

    @Autowired
    private ObjectValueRepository objectValueRepository;

    @Test
    public void getDiceRollingResultsTest() {
        List<String> visibles = new ArrayList<>();
        visibles.add("user1");
        visibles.add("user2");
        DiceRollingDto diceRollingDto = new DiceRollingDto("1", "user", "d4+20", visibles, true);
        DiceRolling diceRolling = gameService.getDiceRollingResults(diceRollingDto);
        String result = diceRolling.getResult();
        System.out.println("result: " + result);
    }

    @Test
    public void getPlayerResultsTest() {
        List<String> visible1 = new ArrayList<>();
        visible1.add("user3");
        List<String> visible2 = new ArrayList<>();
        visible1.add("user4");
        DiceRollingDto diceRollingDto1 = new DiceRollingDto("1", "user", "d4+20", visible1, true);
        DiceRolling diceRolling1 = gameService.getDiceRollingResults(diceRollingDto1);
        DiceRollingDto diceRollingDto2 = new DiceRollingDto("2", "user", "d4+20", visible1, true);
        DiceRolling diceRolling2 = gameService.getDiceRollingResults(diceRollingDto2);
        DiceRollingDto diceRollingDto3 = new DiceRollingDto("1", "user", "d4+20", visible2, true);
        DiceRolling diceRolling3 = gameService.getDiceRollingResults(diceRollingDto3);
        assertEquals(1, gameService.getPlayerResults("1", "user3").size());
    }

    @Test
    public void getMagicCheckDataTest() {
        List<String> visibles = new ArrayList<>();
        visibles.add("user5");
        visibles.add("user6");
        DiceRollingDto diceRollingDto1 = new DiceRollingDto("1", "user0", "d4+20", visibles, true);
        DiceRolling diceRolling1 = gameService.getDiceRollingResults(diceRollingDto1);
        DiceRollingDto diceRollingDto2 = new DiceRollingDto("1", "user0", "d4+20", visibles, false);
        DiceRolling diceRolling2 = gameService.getDiceRollingResults(diceRollingDto2);
        DiceRollingDto diceRollingDto3 = new DiceRollingDto("2", "user0", "d4+20", visibles, true);
        DiceRolling diceRolling3 = gameService.getDiceRollingResults(diceRollingDto3);
        assertEquals(1, gameService.getMagicCheckData("1", "user0").size());
    }


//    @Test
//    public void createObjectsTest() {
//        String code = "{type rollwithmod {\n" +
//                "    numdice:int,\n" +
//                "    numsides:int option option [],\n" +
//                "    modifier:int [][][] option\n" +
//                "    };\n" +
//                "type newType {\n" +
//                "    a:rollwithmod,\n" +
//                "    b:string option [] option,\n" +
//                "    c:boolean option []\n" +
//                "    }\n" +
//                "}";
//        gameService.initializeGame("1", code);
//        assertEquals(6, objectFieldRepository.findByGameId("1").size());
//        List<ObjectField> objectFields = objectFieldRepository.findByGameId("1");
//        for (ObjectField objectField : objectFields) {
//            System.out.println(objectField.toString());
//        }
//        System.out.println();
//        //assertEquals(18, objectFieldTypeRepository.findAll().size());
//        List<ObjectFieldType> objectFieldTypes = objectFieldTypeRepository.findAll();
//        for (ObjectFieldType objectFieldType : objectFieldTypes) {
//            System.out.println(objectFieldType.toString());
//        }
//        ObjectFieldDto objectFieldDto = gameService.getObjectFields("1", "newType");
//        System.out.println(objectFieldDto.toString());
//    }


//    @Test
//    public void getObjectFieldsTest() {
//        String code = "{type rollwithmod { \n" +
//                "   numdice:int,\n" +
//                "   numsides:int option option [],\n" +
//                "   modifier:int [][][] option\n" +
//                "};\n" +
//                "type attack {\n" +
//                "     basedmg: rollwithmod,\n" +
//                "     attackbon: int,\n" +
//                "     rerolls: int,\n" +
//                "     critthreat: int,\n" +
//                "     autoconfirm: bool,\n" +
//                "     addoncrit : rollwithmod,\n" +
//                "     addonsneak: rollwithmod,\n" +
//                "     addoncritsneak:rollwithmod\n" +
//                "};\n}";
//        gameService.initializeGame("2", code);
//        ObjectFieldDto attackField = gameService.getObjectFields("2", "attack");
//        assertEquals(8, attackField.getObjectField().size());
//        assertEquals(8, attackField.getFieldType().size());
//        ObjectFieldDto rollwithmodField = gameService.getObjectFields("2", "rollwithmod");
//        assertEquals(3, rollwithmodField.getObjectField().size());
//        assertEquals(3, rollwithmodField.getFieldType().size());
//        ObjectFieldDto objectFieldDto = gameService.getObjectFields("2", "rollwithmod");
//        assertEquals("2", objectFieldDto.getGameId());
//        System.out.println(objectFieldDto.toString());
//    }

//    @Test
//    public void deleteAndAddObjectFieldTest() {
        String code = "{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int [][],\n" +
                "    modifier:int []\n" +
                "    };\n" +
                "type newType {\n" +
                "    a:rollwithmod [],\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                "}";
//        gameService.initializeGame("3", code);
//        gameService.deleteObjectField("3", "newType", "a");
//
//        String codeAdd = "{type rollwithmod {\n" +
//                "    add:int\n" +
//                "    }\n" +
//                "}";
//        gameService.addObjectFields("3", codeAdd);
//
//        List<ObjectField> objectFields = objectFieldRepository.findByGameId("3");
//        for (ObjectField objectField : objectFields) {
//            System.out.println(objectField.toString());
//        }
//        System.out.println();
//        List<ObjectFieldType> objectFieldTypes = objectFieldTypeRepository.findAll();
//        for (ObjectFieldType objectFieldType : objectFieldTypes) {
//            System.out.println(objectFieldType.toString());
//        }
//    }

    @Test
    public void createObjectTest() {
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("2");
        createObjectRequestDto.setPlayerUuid("002");
        createObjectRequestDto.setObjectName("dragon");
        createObjectRequestDto.setObjectValue("[height: 2m, weight: 10t]");
        CreateObjectResponseDto createObjectResponseDto = gameService.createObject(createObjectRequestDto);
        System.out.println(createObjectResponseDto.getMyObjectList());
    }

    @Test
    public void startGameTest() {
        // 1. Create game
        CreateGameRequestDto createGameRequestDto = new CreateGameRequestDto();
        createGameRequestDto.setHostUuid("0001");
        createGameRequestDto.setGameName("RISK");
        createGameRequestDto.setPlayerNum(6);
        createGameRequestDto.setCode("{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    }\n" +
                " type test = rollwithmod;\n" +
                " type newType {\n" +
                "    a:test,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                " fun int cal(int a, int x, int y, int z){\n" +
                "    var b = 0;\n" +
                "    var anArray:int [] = {1};\n" +
                "    var sum = 0;\n" +
                "    var opti: int option;\n" +
                "    var userTest : newType;\n" +
                "    userTest.a.numdice = 5;\n" +
                "    opti = SOME(1);\n" +
                "    opti = NONE;\n" +
                "    anArray = {1,2,3,7,10};\n" +
                "    anArray[3] = 10;\n" +
                "    output(a);\n" +
                "    for(i : anArray){\n" +
                "        sum = sum + i;\n" +
                "        if (sum > 10) then { break;}\n" +
                "    }\n" +
                "    a = 1;\n" +
                "    output(a);\n" +
                "    return sum;\n" +
                "    }\n" +
                "   \n" +
                "    fun int test(int i){\n" +
                "        i = 1;\n" +
                "        while(i < 10){\n" +
                "            i = i + 1;\n" +
                "        }\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testCallExp(){\n" +
                "        var i = test(20);\n" +
                "        return i;\n" +
                "    }\n" +
                "    fun int testRoll(){\n" +
                "        var i = roll(\"d100\");\n" +
                "        if(userOption(\"Reroll?\")) then{\n" +
                "            var i = 1;\n" +
                "            output(i);\n" +
                "        }\n" +
                "        if(i > 1) then {\n" +
                "            output(\"roll:\" + roll(\"3d4\"));\n" +
                "        }else{\n" +
                "            var i = roll(\"d100\");   \n" +
                "            output(i);\n" +
                "        }\n" +
                "        output(\"force reroll\");\n" +
                "        return i;\n" +
                "   }\n" +
                "}");
        CreateGameResponseDto createGameResponseDto = gameService.createNewGame(createGameRequestDto);

        // 2. Join game
        JoinGameRequestDto joinGameRequestDto = new JoinGameRequestDto();
        joinGameRequestDto.setGameId("1");
        joinGameRequestDto.setPlayerUuid("0002");
        try {
            JoinGameResponseDto joinGameResponseDto = gameService.joinGame(joinGameRequestDto);
        }
        catch (Exception e){
            System.out.print(e);
        }
        // 3. start game
        GameStartRequestDto gameStartRequestDto = new GameStartRequestDto();
        gameStartRequestDto.setGameId("1");
        try {
            GameStartResponseDto gameStartResponseDto = gameService.startGame(gameStartRequestDto);
        }
        catch (Exception e){
            System.out.println(e);
        }

        // 4. create object
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("1");
        createObjectRequestDto.setPlayerUuid("0001");
        createObjectRequestDto.setObjectName("dragon");
        String value = "power: 100dmg";
        createObjectRequestDto.setObjectValue(value);
        CreateObjectResponseDto createObjectResponseDto = gameService.createObject(createObjectRequestDto);

        // 5. call function (maybe need a Dto after we finish introducing params and states)
        String gameId = "1";
        String funcName = "cal";
        try {
            CallFunctionRequestDto callFunctionRequestDto = new CallFunctionRequestDto();
            CallFunctionResponseDto result = gameService.callFunction(callFunctionRequestDto);
        }
        catch (Exception e) {
            System.out.println("Game does not exists!");
        }
    }

}
