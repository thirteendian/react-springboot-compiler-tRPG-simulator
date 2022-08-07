package edu.duke.summer.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactController {
    @GetMapping(value = "/react")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getReact(){
        System.out.println("React Page Entering");
        return "this is a react page";
    }
}
