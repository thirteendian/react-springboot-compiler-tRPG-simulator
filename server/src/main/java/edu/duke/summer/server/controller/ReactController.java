package edu.duke.summer.server.controller;

import edu.duke.summer.server.service.GameService;
import edu.duke.summer.server.service.MyUserDetailsService;
import edu.duke.summer.server.stomp.RespObjectCreatingField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/test/")
public class ReactController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    GameService gameService;

    @PostMapping(value = "/file")
    public String postFile(){
        String test = "{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    }\n" +
                "type test = rollwithmod;\n" +
                "type newType {\n" +
                "    a:rollwithmod,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                "}";

        return  "Success";
    }


    @GetMapping(value = "/rollwithmod")
    public RespObjectCreatingField getRollWithMod(){
        String test = "{type rollwithmod {\n" +
                "    numdice:int,\n" +
                "    numsides:int option option [],\n" +
                "    modifier:int [][][] option\n" +
                "    }\n" +
                "type test = rollwithmod;\n" +
                "type newType {\n" +
                "    a:rollwithmod,\n" +
                "    b:string option [] option,\n" +
                "    c:boolean option []\n" +
                "    }\n" +
                "}";


        return null;

    }
    //
//    @GetMapping(value = "/react")
//    public String getReact(){
//        System.out.println("React Page Entering");
//        return "this is a react page";
//    }

//    @GetMapping(value = "/")
//    public List<UserDetails> getUser(){
//        List<UserDetails> list = new ArrayList<>();
//        list.add(myUserDetailsService.loadUserByUsername("admin@duke.edu"));
//        list.add(myUserDetailsService.loadUserByUsername("user@duke.edu"));
//    return list;
//    }

//    @GetMapping("/")
//    public ResponseEntity<?> index(Model model, HttpSession httpSession) {
//        //If Authenticated
//        if (myUserDetailsService.isUserAuthenticated()) {
//            //Init User Info
//            MyUserDetailsImpl myUserDetailsImpl = myUserDetailsService.loadMyUserDetailsOfCurrentUser();
//            httpSession.setAttribute("USER_UUID", myUserDetailsImpl.getUuid());
//            model.addAttribute("uuid",httpSession.getAttribute("USER_UUID"));
//
//            //IF Admin
//            if(myUserDetailsService.isUserhasRole("ROLE_ADMIN")){
//                System.out.println("Controller./()admin [session:]"+httpSession.getId());
//                return ResponseEntity.ok().header(
//                        HttpHeaders.AUTHORIZATION,
//                        httpSession.getId()
//                ).body(
//                        myUserDetailsImpl
//                );//myUserDtails;//"redirect:/admin/"+myUserDtails.getUuid()+ "/index_after_login";
//            }
//            //IF User
//            System.out.println("Controller./()user [session:]"+httpSession.getId());
//            return ResponseEntity.ok().header(
//                    HttpHeaders.AUTHORIZATION,
//                    httpSession.getId()
//            ).body(
//                    myUserDetailsImpl
//            );//"redirect:/user/" + myUserDtails.getUuid() + "/index_after_login";
//        }
//        //If not Authenticated
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();//"index_before_login";
//    }
}
