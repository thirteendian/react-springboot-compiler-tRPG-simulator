package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.service.MyUserDtails;
import edu.duke.summer.client.dto.SignupDto;
import edu.duke.summer.client.service.MyUserDetailsService;
import edu.duke.summer.client.exceptions.UserAlreadyExistException;
import edu.duke.summer.client.service.WebsocketService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private WebsocketService websocketService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping("/")
    public String index(Model model, HttpSession httpSession) {
        //If Authenticated
        if (myUserDetailsService.isUserAuthenticated()) {
            //Init User Info
            MyUserDtails myUserDtails = myUserDetailsService.loadMyUserDetailsOfCurrentUser();
            httpSession.setAttribute("USER_UUID",myUserDtails.getUuid());
            model.addAttribute("uuid",httpSession.getAttribute("USER_UUID"));

            //IF Admin
            if(myUserDetailsService.isUserhasRole("ROLE_ADMIN")){
                System.out.println("Controller./()admin [session:]"+httpSession.getId());
                return"redirect:/admin/"+myUserDtails.getUuid()+ "/index_after_login";
            }
            //IF User
            System.out.println("Controller./()user [session:]"+httpSession.getId());
            return "redirect:/user/" + myUserDtails.getUuid() + "/index_after_login";
        }
        //If not Authenticated
        System.out.println("Controller./() [session:]"+httpSession.getId());
        return "index_before_login";
    }

    @GetMapping("/login")
    public String login(HttpSession httpSession) {
        if (myUserDetailsService.isUserAuthenticated()) {
            return "redirect:/";
        }
        System.out.println("Controller.login() [session:]"+httpSession.getId());
        return "login";
    }

    @GetMapping("/user/{uuid}/index_after_login")
    public String userindexAfterLogin(HttpServletRequest request, @PathVariable String uuid, Model model) {
        model.addAttribute("myuuid",uuid);
        return "index_after_login";
    }


    /**
     * Page: admin_index_after_login.html
     * Role: ROLE_ADMIN
     */
    @GetMapping("/admin/{uuid}/index_after_login")
    public String adminIndexAfterLogin(HttpServletRequest request, @PathVariable String uuid, Model model) {
        model.addAttribute("uuid",uuid);
        System.out.println("Controller.adminIndexAfterLogin() [session:]"+request.getSession().getId());
        return "admin_index_after_login";
    }

    @GetMapping("/admin/{uuid}/systeminfo")
    public String adminGetSystemInfo(HttpServletRequest request, @PathVariable String uuid, Model model) {
        request.getSession(true);
        model.addAttribute("uuid",uuid);
        System.out.println("Controller.adminGetSystemInfo() [session:]"+request.getSession().getId());
        return "admin_system_info";
    }


    /**
     * Page: signup.html
     * Role: ROLE_ALL
     */
    @GetMapping("/signup")
    public String allGetSignup(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }

    @PostMapping("/signup")
    //@RequestParam("profile") MultipartFile multipartFile
    public String allPostSignup(@ModelAttribute("signupDto") @Valid SignupDto signupDto, HttpServletRequest request, Errors errors) {
        //Profile Upload
//        String filename =StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        signupDto.setProfile(filename);
        try{
            User registered =  myUserDetailsService.signupNewUser(signupDto);
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            ModelAndView errorModelAndView = new ModelAndView("signup");
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

    /*
    html Frame work
     */
    @GetMapping("/accountSettings")
    public String getAccountSettings(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "account_settings";
    }

    @GetMapping("/changePassword")
    public String getChangePassword(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "change_password";
    }
}

