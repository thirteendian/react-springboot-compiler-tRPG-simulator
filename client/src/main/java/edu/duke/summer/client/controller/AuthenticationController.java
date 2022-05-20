package edu.duke.summer.client.controller;

import edu.duke.summer.client.Login;
import edu.duke.summer.client.Signup;
import edu.duke.summer.client.database.ShipmentRepository;
import edu.duke.summer.client.dto.UserDto;
import edu.duke.summer.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;


@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    private Boolean isSignUp = false;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signup", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute @Valid UserDto userDto, Model model) {
        try {
            userService.createNewUser(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            //redirect to Getmapping signup
            return "redirect:/signup";
        }
        model.addAttribute("signup", userDto);
//        this.isSignUp = true;
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

