package edu.duke.summer.server.controller;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.service.MyUserDetailsService;
import edu.duke.summer.server.service.MyUserDtails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

//    @GetMapping(value = "/")
//    public List<UserDetails> getUser(){
//        List<UserDetails> list = new ArrayList<>();
//        list.add(myUserDetailsService.loadUserByUsername("admin@duke.edu"));
//        list.add(myUserDetailsService.loadUserByUsername("user@duke.edu"));
//    return list;
//    }

    @GetMapping("/")
    public ResponseEntity<?> index(Model model, HttpSession httpSession) {
        //If Authenticated
        if (myUserDetailsService.isUserAuthenticated()) {
            //Init User Info
            MyUserDtails myUserDtails = myUserDetailsService.loadMyUserDetailsOfCurrentUser();
            httpSession.setAttribute("USER_UUID",myUserDtails.getUuid());
            model.addAttribute("uuid",httpSession.getAttribute("USER_UUID"));

            //IF Admin
            if(myUserDetailsService.isUserhasRole("ROLE_ADMIN")){
                System.out.println("Controller./()admin [session:]"+httpSession.getId());
                return ResponseEntity.ok().header(
                        HttpHeaders.AUTHORIZATION,
                        httpSession.getId()
                ).body(
                        myUserDtails
                );//myUserDtails;//"redirect:/admin/"+myUserDtails.getUuid()+ "/index_after_login";
            }
            //IF User
            System.out.println("Controller./()user [session:]"+httpSession.getId());
            return ResponseEntity.ok().header(
                    HttpHeaders.AUTHORIZATION,
                    httpSession.getId()
            ).body(
                    myUserDtails
            );//"redirect:/user/" + myUserDtails.getUuid() + "/index_after_login";
        }
        //If not Authenticated

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();//"index_before_login";
    }
}
