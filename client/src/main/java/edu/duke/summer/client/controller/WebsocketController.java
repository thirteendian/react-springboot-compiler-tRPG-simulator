package edu.duke.summer.client.controller;

import edu.duke.summer.client.service.WebsocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @Autowired
    private WebsocketService websocketService;

    @MessageMapping("/schedule/jvminfo")
    @Scheduled(fixedRate = 1000)//call (/1000 mils ec)
    public void getJVMInfo(){
        websocketService.sendServerJVMInfo();
    }
}
