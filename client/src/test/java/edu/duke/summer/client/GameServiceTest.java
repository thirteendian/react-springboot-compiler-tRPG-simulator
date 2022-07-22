package edu.duke.summer.client;

import edu.duke.summer.client.algorithm.EvalServicempl;
import edu.duke.summer.client.algorithm.RuleInfo;
import edu.duke.summer.client.algorithm.absyn.TypeDec;
import edu.duke.summer.client.config.SpringConfig;
import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.database.model.ObjectField;
import edu.duke.summer.client.database.model.ObjectFieldType;
import edu.duke.summer.client.database.model.Player;
import edu.duke.summer.client.database.repository.*;
import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.ObjectFieldDto;
import edu.duke.summer.client.dto.ObjectValueDto;
import edu.duke.summer.client.service.GameService;
import edu.duke.summer.client.service.GameServiceImpl;
import edu.duke.summer.client.service.SeqNumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
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
        player1.setGame("test1");
        player1.setUserId("user1");
        playerRepository.save(player1);
        Player player2 = new Player();
        player2.setGame("test2");
        player2.setUserId("user2");
        playerRepository.save(player2);
        Player player3 = new Player();
        player3.setGame("test1");
        player3.setUserId("user3");
        playerRepository.save(player3);
        assertEquals(2, gameService.getAllPlayers("test1").size());
    }

    @Test
    public void createObjectsTest() {
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
        gameService.createObjects("1", code);
        assertEquals(6, objectFieldRepository.findByGameId("1").size());
        List<ObjectField> objectFields = objectFieldRepository.findByGameId("1");
        for (ObjectField objectField : objectFields) {
            System.out.println(objectField.toString());
        }
        System.out.println();
        assertEquals(18, objectFieldTypeRepository.findAll().size());
        List<ObjectFieldType> objectFieldTypes = objectFieldTypeRepository.findAll();
        for (ObjectFieldType objectFieldType : objectFieldTypes) {
            System.out.println(objectFieldType.toString());
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
                "   numsides:int,\n" +
                "   modifier:int\n" +
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
        gameService.createObjects("1", code);
        ObjectFieldDto attackField = gameService.getObjectFields("1", "attack");
        assertEquals(8, attackField.getObjectField().size());
        assertEquals(8, attackField.getFieldType().size());
        ObjectFieldDto rollwithmodField = gameService.getObjectFields("1", "rollwithmod");
        assertEquals(3, rollwithmodField.getObjectField().size());
        assertEquals(3, rollwithmodField.getFieldType().size());
    }

    @Test
    public void saveObjectsTest() {
        ObjectValueDto objectValueDto = new ObjectValueDto();
        objectValueDto.setGameId("1");
        objectValueDto.setTypeName("rollwithmod");
        objectValueDto.addFieldValue("2");
        objectValueDto.addFieldValue("6");
        objectValueDto.addFieldValue("1");
        gameService.saveObjects(objectValueDto);
        assertEquals(3, objectValueRepository.findByGameId("1").size());
    }

    @Test
    public void saveArraysTest() {
        ObjectValueDto objectValueDto = new ObjectValueDto();
        objectValueDto.setGameId("1");
        objectValueDto.setTypeName("int");
        objectValueDto.addFieldValue("1");
        objectValueDto.addFieldValue("4");
        objectValueDto.addFieldValue("7");
        gameService.saveArrays(objectValueDto);
        assertEquals(3, objectArrayValueRepository.findByGameId("1").size());
    }

    @Test
    public void getObjectValuesTest() {
        ObjectValueDto objectValueDto = new ObjectValueDto();
        objectValueDto.setGameId("2");
        objectValueDto.setTypeName("rollwithmod");
        objectValueDto.addFieldValue("2");
        objectValueDto.addFieldValue("6");
        objectValueDto.addFieldValue("1");
        gameService.saveObjects(objectValueDto);
        assertEquals(3, objectValueRepository.findByGameId("2").size());
        ObjectValueDto result = gameService.getObjectValues("2", "rollwithmod", "0");
        assertEquals(3, result.getFieldValue().size());
    }

    @Test
    public void getArrayValuesTest() {
        ObjectValueDto objectValueDto = new ObjectValueDto();
        objectValueDto.setGameId("3");
        objectValueDto.setTypeName("int");
        objectValueDto.addFieldValue("1");
        objectValueDto.addFieldValue("4");
        objectValueDto.addFieldValue("7");
        gameService.saveArrays(objectValueDto);
        assertEquals(3, objectArrayValueRepository.findByGameId("3").size());
        ObjectValueDto result = gameService.getArrayValues("3",  "2");
        assertEquals(3, result.getFieldValue().size());
    }
}
