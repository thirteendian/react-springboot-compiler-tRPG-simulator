package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.service.MyUserDtails;
import edu.duke.summer.client.dto.SignupDto;
import edu.duke.summer.client.service.MyUserDetailsService;
import edu.duke.summer.client.exceptions.UserAlreadyExistException;
import edu.duke.summer.client.service.StorageService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * Note that use Controller will enable return value to be the HTML's name
 * Rather than RestController that will only return the String
 */
@Controller
public class AuthenticationController {


    @Autowired
    private MyUserDetailsService myUserDetailsService;
    private Boolean isSignUp = false;
    private StorageService storageService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/")
    public String index(Model model) {
        if (myUserDetailsService.isUserAuthenticated()) {
            MyUserDtails myUserDtails = myUserDetailsService.loadMyUserDetailsOfCurrentUser();
            if(!model.containsAttribute("loggedInMyUserDtails")){
                model.addAttribute("loggedInMyUserDtails",myUserDtails);
            }
            return "redirect:/user/" + myUserDtails.getUuid() + "/index_after_login";
        }
        return "index_before_login";
    }

    @GetMapping("/login")
    public String login() {
        if (myUserDetailsService.isUserAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/user/{uuid}/index_after_login")
    public String indexAfterLogin(HttpServletRequest request, @PathVariable String uuid) {
//        System.out.println(request.getRequestURL().toString());
//        + "?" + request.getQueryString();
        return "index_after_login";
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }


    @PostMapping("/signup")
    //@RequestParam("profile") MultipartFile multipartFile
    public String postSignup(@ModelAttribute("signupDto") @Valid SignupDto signupDto, HttpServletRequest request, Errors errors) {
        //Profile Upload
//        String filename =StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        signupDto.setProfile(filename);
        try{
            User registered =  myUserDetailsService.signupNewUser(signupDto);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            ModelAndView errorModelAndView = new ModelAndView("/signup");
            errorModelAndView.addObject("message","An Account for that email already exists.");

            return "redirect:/signup";
        }
        ModelAndView modelAndView = new ModelAndView("/");
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "<h1>Welcome name: " + principal.getName() + "</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }


}

