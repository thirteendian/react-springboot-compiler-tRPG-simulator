package edu.duke.summer.client.stomp;

import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.dto.ObjectFieldDto;
import edu.duke.summer.client.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DiceRollingController {
    @Autowired
    private GameService gameService;


    /**
     * Receive diceRolling raw input string, broadcast output to SendTo
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/dicerolling_result")
    @SendTo("/dicerolling/result")
    public RespDiceRollingResult getDiceRollingResult(Principal principal,ReqDiceRollingString message) throws Exception {
        DiceRollingDto diceRollingDto = new DiceRollingDto();
        diceRollingDto.setPlayer(principal.getName());
        diceRollingDto.setGame("game");
        List<String> visibles = new ArrayList<>();
        visibles.add("user1");
        visibles.add("user2");
        diceRollingDto.setVisibles(visibles);
        diceRollingDto.setMagicCheck(message.getMagicCheck());
        diceRollingDto.setRawData(message.getRawString());
        System.out.println("The Magic Check is "+ gameService.getMagicCheckData("game",principal.getName()));
        return new RespDiceRollingResult(HtmlUtils.htmlEscape(message.getRawString()),gameService.getDiceRollingResults(diceRollingDto).getResult(),gameService.getMagicCheckData("game",principal.getName()));
    }

    @MessageMapping("/createobject_name")
    @SendTo("/objectcreate/field")
    public RespObjectCreatingField getObjectCreatingField(ReqObjectCreatingName reqObjectCreatingName){
        System.out.println("ObjectName:" + reqObjectCreatingName.getObjectName());
        ObjectFieldDto objectFieldDto = gameService.getObjectFields("1",reqObjectCreatingName.getObjectName());
        RespObjectCreatingField respObjectCreatingField = new RespObjectCreatingField();
        //List of field(Order)
        respObjectCreatingField.setObjectField(objectFieldDto.getObjectField());
        //Hashmap of Type(Self FK)
        respObjectCreatingField.setFieldType(objectFieldDto.getFieldType());
        return respObjectCreatingField;
    }


}
