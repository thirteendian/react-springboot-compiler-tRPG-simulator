package edu.duke.summer.client.controller;

import edu.duke.summer.client.Login;
import edu.duke.summer.client.Signup;
import edu.duke.summer.client.database.ShipmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class AuthenticationController {
    private final ShipmentRepository repository;
    private Boolean isSignUp = false;


    public AuthenticationController(ShipmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute @Valid Signup signup, Model model) {
//        try {
//
//        }
        model.addAttribute("signup", signup);
        this.isSignUp = true;
        return "game";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String loginpost(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);
        this.isSignUp = true;
        return "game";
    }


}

