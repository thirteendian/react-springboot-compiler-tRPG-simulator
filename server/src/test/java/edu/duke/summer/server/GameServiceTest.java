package edu.duke.summer.server;

import edu.duke.summer.server.config.SpringConfig;
import edu.duke.summer.server.database.model.*;
import edu.duke.summer.server.database.repository.*;
import edu.duke.summer.server.dto.DiceRollingDto;
import edu.duke.summer.server.dto.Object.ObjectDto;
import edu.duke.summer.server.dto.Request.CreateObjectRequestDto;
import edu.duke.summer.server.service.GameService;
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

    @Autowired
    private ObjectArrayValueRepository objectArrayValueRepository;

    @Autowired
    private FunctionInfoRepository functionInfoRepository;

    @Autowired
    private ParamInfoRepository paramInfoRepository;

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

    @Test
    public void getAllPlayersTest() {
        Player player1 = new Player();
        player1.setGameId("test1");
        player1.setUserId("user1");
        playerRepository.save(player1);
        Player player2 = new Player();
        player2.setGameId("test2");
        player2.setUserId("user2");
        playerRepository.save(player2);
        Player player3 = new Player();
        player3.setGameId("test1");
        player3.setUserId("user3");
        playerRepository.save(player3);
        assertEquals(2, gameService.getAllPlayers("test1").size());
    }

    @Test
    public void createObjectsTest() {
//        String code_test = "{type test {\n" +
//                "    testint:int\n" +
//                "    }\n" +
//                "}";
//        gameService.createObjects("1", code_test);

        String code = "{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    };\n" +
                "type newType {\n" +
                "    a:rollwithmod,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                "}";
        gameService.initializeGame("1", code);
        //assertEquals(6, objectFieldRepository.findByGameId("1").size());
        List<ObjectField> objectFields = objectFieldRepository.findByGameId("1");
        for (ObjectField objectField : objectFields) {
            System.out.println(objectField.toString());
        }
        System.out.println();
        //assertEquals(18, objectFieldTypeRepository.findAll().size());
        List<ObjectFieldType> objectFieldTypes = objectFieldTypeRepository.findAll();
        for (ObjectFieldType objectFieldType : objectFieldTypes) {
            System.out.println(objectFieldType.toString());
        }
        ObjectDto objectDto = gameService.getObjectFields("1", "newType");
        System.out.println(objectDto.toString());
    }

    @Test
    public void createFunctionsTest() {
        String ruleStr = "{ fun int cal(int a, int option option [] x, int [][][] option y, string option [] option z){\n" +
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
                "}";
        gameService.initializeGame("5", ruleStr);
        //assertEquals(4, functionInfoRepository.findByGameId("5").size());
        List<FunctionInfo> functionInfos = functionInfoRepository.findByGameId("5");
        for (FunctionInfo functionInfo : functionInfos) {
            System.out.println(functionInfo.toString());
        }
        System.out.println();
        List<ParamInfo> paramInfos = paramInfoRepository.findAll();
        for (ParamInfo paramInfo : paramInfos) {
            System.out.println(paramInfo.toString());
        }
    }

    @Test
    public void getObjectsListTest() {
        List<String> objectsList = gameService.getObjectsList("1");
        assertEquals(2, objectsList.size());
    }

    @Test
    public void getObjectFieldsTest() {
        String code = "{type rollwithmod { \n" +
                "   numdice:int,\n" +
                "   numsides:int option option [],\n" +
                "   modifier:int [][][] option\n" +
                "};\n" +
                "type attack {\n" +
                "     basedmg: rollwithmod,\n" +
                "     attackbon: int,\n" +
                "     rerolls: int,\n" +
                "     critthreat: int,\n" +
                "     autoconfirm: bool,\n" +
                "     addoncrit : rollwithmod,\n" +
                "     addonsneak: rollwithmod,\n" +
                "     addoncritsneak:rollwithmod\n" +
                "};\n}";
        gameService.initializeGame("2", code);
        ObjectDto attackField = gameService.getObjectFields("2", "attack");
        assertEquals(8, attackField.getFieldNames().size());
        assertEquals(8, attackField.getFieldType().size());
        ObjectDto rollwithmodField = gameService.getObjectFields("2", "rollwithmod");
        assertEquals(3, rollwithmodField.getFieldNames().size());
        assertEquals(3, rollwithmodField.getFieldType().size());
        ObjectDto objectDto = gameService.getObjectFields("2", "rollwithmod");
        assertEquals("2", objectDto.getGameId());
        System.out.println(objectDto.toString());
    }

    @Test
    public void deleteAndAddObjectFieldTest() {
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
        gameService.initializeGame("3", code);
        gameService.deleteObjectField("3", "newType", "a");

        String codeAdd = "{type rollwithmod {\n" +
                "    add:int\n" +
                "    }\n" +
                "}";
        gameService.addObjectFields("3", codeAdd);

        List<ObjectField> objectFields = objectFieldRepository.findByGameId("3");
        for (ObjectField objectField : objectFields) {
            System.out.println(objectField.toString());
        }
        System.out.println();
        List<ObjectFieldType> objectFieldTypes = objectFieldTypeRepository.findAll();
        for (ObjectFieldType objectFieldType : objectFieldTypes) {
            System.out.println(objectFieldType.toString());
        }
    }

    @Test
    public void saveObjectsTest() {
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("1");
        createObjectRequestDto.setTypeName("rollwithmod");
        createObjectRequestDto.addFieldValue("2");
        createObjectRequestDto.addFieldValue("6");
        createObjectRequestDto.addFieldValue("1");
        gameService.saveObjects(createObjectRequestDto);
        assertEquals(3, objectValueRepository.findByGameId("1").size());
    }

    @Test
    public void saveArraysTest() {
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("1");
        createObjectRequestDto.setTypeName("int");
        createObjectRequestDto.addFieldValue("1");
        createObjectRequestDto.addFieldValue("4");
        createObjectRequestDto.addFieldValue("7");
        gameService.saveArrays(createObjectRequestDto);
        assertEquals(3, objectArrayValueRepository.findByGameId("1").size());
    }

    @Test
    public void getObjectValuesTest() {
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("2");
        createObjectRequestDto.setTypeName("rollwithmod");
        createObjectRequestDto.addFieldValue("2");
        createObjectRequestDto.addFieldValue("6");
        createObjectRequestDto.addFieldValue("1");
        gameService.saveObjects(createObjectRequestDto);
        assertEquals(3, objectValueRepository.findByGameId("2").size());
        CreateObjectRequestDto result = gameService.getObjectValues("2", "rollwithmod", "0");
        assertEquals(3, result.getFieldValue().size());
    }

    @Test
    public void getArrayValuesTest() {
        CreateObjectRequestDto createObjectRequestDto = new CreateObjectRequestDto();
        createObjectRequestDto.setGameId("3");
        createObjectRequestDto.setTypeName("int");
        createObjectRequestDto.addFieldValue("1");
        createObjectRequestDto.addFieldValue("4");
        createObjectRequestDto.addFieldValue("7");
        gameService.saveArrays(createObjectRequestDto);
        assertEquals(3, objectArrayValueRepository.findByGameId("3").size());
        CreateObjectRequestDto result = gameService.getArrayValues("3",  "2");
        assertEquals(3, result.getFieldValue().size());
    }

}
