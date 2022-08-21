package edu.duke.summer.server.controller;

import edu.duke.summer.server.jwt.JwtUtils;
import edu.duke.summer.server.service.WebsocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebsocketController {

    @Autowired
    private WebsocketService websocketService;


    @MessageMapping("/schedule/jvminfo")
    @Scheduled(fixedRate = 1000)//call (/1000 mils ec)
    public void getJVMInfo(){
        websocketService.sendServerJVMInfo();
    }

    @MessageMapping("/gameAction")
    public void getGameAction(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        websocketService.sendGameResponse(userDetails);
    }
}
