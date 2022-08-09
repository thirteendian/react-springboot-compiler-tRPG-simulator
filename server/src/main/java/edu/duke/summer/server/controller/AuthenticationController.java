package edu.duke.summer.server.controller;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.service.MyUserDtails;
import edu.duke.summer.server.dto.SignupDto;
import edu.duke.summer.server.service.MyUserDetailsService;
import edu.duke.summer.server.exceptions.UserAlreadyExistException;
import edu.duke.summer.server.service.WebsocketService;
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


    /**
     * Page: index_before_login.html
     *       index_after_login.html
     *       admin_index_after_login.html
     * Role:
     *       index_before_login(ROLE_ALL)
     *       index_after_login(ROLE_USER)
     *       admin_index_after_login.html(ROLE_ADMIN)
     */
//    @GetMapping("/")
//    public MyUserDtails index(Model model, HttpSession httpSession) {
//        //If Authenticated
//        if (myUserDetailsService.isUserAuthenticated()) {
//            //Init User Info
//            MyUserDtails myUserDtails = myUserDetailsService.loadMyUserDetailsOfCurrentUser();
//            httpSession.setAttribute("USER_UUID",myUserDtails.getUuid());
//            model.addAttribute("uuid",httpSession.getAttribute("USER_UUID"));
//
//            //IF Admin
//            if(myUserDetailsService.isUserhasRole("ROLE_ADMIN")){
//                System.out.println("Controller./()admin [session:]"+httpSession.getId());
//                return myUserDtails;//"redirect:/admin/"+myUserDtails.getUuid()+ "/index_after_login";
//            }
//            //IF User
//            System.out.println("Controller./()user [session:]"+httpSession.getId());
//            return myUserDtails;//"redirect:/user/" + myUserDtails.getUuid() + "/index_after_login";
//        }
//        //If not Authenticated
//        System.out.println("Controller./() [session:]"+httpSession.getId());
//
//        User testUser = new User(
//                "user@duke.edu",
//                "test_username",
//                "test_FirstName",
//                "test_LastName",
//                "pass",
//                "ROLE_USER",
//                true
//        );
//        MyUserDtails myUserDtails = new MyUserDtails(testUser);
//
//        return myUserDtails;//"index_before_login";
//    }

    /**
     * Page: login.html
     * Role: ROLE_ALL
     */
    @GetMapping("/login")
    public String login(HttpSession httpSession) {
        if (myUserDetailsService.isUserAuthenticated()) {
            return "redirect:/";
        }
        System.out.println("Controller.login() [session:]"+httpSession.getId());
        return "/login.html";
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

    /**
     * Page: signup.html
     * Role: ROLE_ALL
     */
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


    /**
     * Page: index_after_login.html
     * Role: ROLE_USER
     */
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

    /**
     * Page: admin_system_info.html
     * Role: ROLE_ADMIN
     */
    @GetMapping("/admin/{uuid}/systeminfo")
    public String adminGetSystemInfo(HttpServletRequest request, @PathVariable String uuid, Model model) {
        request.getSession(true);
        model.addAttribute("uuid",uuid);
        System.out.println("Controller.adminGetSystemInfo() [session:]"+request.getSession().getId());
        return "admin_system_info";
    }

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

