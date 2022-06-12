package edu.duke.summer.client.controller;

import edu.duke.summer.client.Login;
import edu.duke.summer.client.Signup;
import edu.duke.summer.client.database.ShipmentRepository;
import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.dto.UserDto;
import edu.duke.summer.client.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@RestController
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
        UserDto loggedUser = new UserDto();
        try {
            User user = userService.createNewUser(userDto);
            loggedUser.setEmail(user.getEmail());
            model.addAttribute("loggedinformation",loggedUser);
        } catch (Exception e) {
            e.printStackTrace();
            //redirect to Getmapping signup
            return "redirect:/signup";
        }
        model.addAttribute("signup", userDto);
//        this.isSignUp = true;
        return "game";
    }

//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("login", new UserDto());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String loginpost(HttpServletRequest httpServletRequest, @ModelAttribute UserDto userDto, Model model) {
//        UserDto loggedUser = new UserDto();
//        model.addAttribute("login", userDto);
//        try {
//            User user = userService.logIn(userDto);
////            //if successfully loggedin, create a session
////            HttpSession session = httpServletRequest.getSession(true);
////            SecurityContext securityContext = SecurityContextHolder.getContext();
////            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,securityContext);
////
////            System.out.println(user.getEmail());
////            loggedUser.setEmail(user.getEmail());
//            model.addAttribute("loggedinformation",loggedUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "game";//   /(userID)/game
//    }

//    @GetMapping("/")
//    public String home(){
//        return ("<h1> Welcome </h1>");
//    }

    @GetMapping("/user")
    public String user(Principal principal){
        return "<h1>Welcome name: "+ principal.getName()+"</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin</h1>");
    }


}

