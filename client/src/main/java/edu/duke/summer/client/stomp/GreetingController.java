package edu.duke.summer.client.stomp;

import edu.duke.summer.client.database.model.DiceRolling;
import edu.duke.summer.client.dto.DiceRollingDto;
import edu.duke.summer.client.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @Autowired
    private GameService gameService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        DiceRollingDto diceRollingDto = new DiceRollingDto();
        diceRollingDto.setPlayer("user");
        diceRollingDto.setGame("game");
        diceRollingDto.setRawData(message.getName());
        DiceRolling diceRolling = gameService.getDiceRollingResults(diceRollingDto);
        return new Greeting("Your Result of " + HtmlUtils.htmlEscape(message.getName()) + " is " + gameService.getDiceRollingResults(diceRollingDto));//"xxxx(waiting algorithm)");
    }


}
