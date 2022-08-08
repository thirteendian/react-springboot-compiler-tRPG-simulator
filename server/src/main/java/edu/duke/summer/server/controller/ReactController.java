package edu.duke.summer.server.controller;

import edu.duke.summer.server.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReactController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @GetMapping(value = "/react")
    public String getReact(){
        System.out.println("React Page Entering");
        return "this is a react page";
    }

    @GetMapping(value = "/")
    public List<UserDetails> getUser(){
        List<UserDetails> list = new ArrayList<>();
        list.add(myUserDetailsService.loadUserByUsername("admin@duke.edu"));
        list.add(myUserDetailsService.loadUserByUsername("user@duke.edu"));
    return list;
    }
}
