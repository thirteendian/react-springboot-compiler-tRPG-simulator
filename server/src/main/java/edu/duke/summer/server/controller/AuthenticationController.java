package edu.duke.summer.server.controller;

import edu.duke.summer.server.database.model.ERole;
import edu.duke.summer.server.database.model.RefreshToken;
import edu.duke.summer.server.database.model.Role;
import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.database.repository.RoleRepository;
import edu.duke.summer.server.database.repository.UserRepository;
import edu.duke.summer.server.exceptions.TokenRefreshException;
import edu.duke.summer.server.jwt.JwtUtils;
import edu.duke.summer.server.payload.request.LoginRequest;
import edu.duke.summer.server.payload.request.LogoutRequest;
import edu.duke.summer.server.payload.request.SignupRequest;
import edu.duke.summer.server.payload.request.TokenRefreshRequest;
import edu.duke.summer.server.payload.response.JwtResponse;
import edu.duke.summer.server.payload.response.MessageResponse;
import edu.duke.summer.server.payload.response.TokenRefreshResponse;
import edu.duke.summer.server.service.MyUserDetailsService;
import edu.duke.summer.server.service.impl.MyUserDetailsImpl;
import edu.duke.summer.server.service.impl.RefreshTokenService;
import edu.duke.summer.server.service.WebsocketService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handle Signup/login request & authorized requests
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
//@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    RefreshTokenService refreshTokenService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    private Boolean isSignUp = false;

    @Autowired
    private WebsocketService websocketService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * The user must use header
     * {"Authorization" : "Bearer _token_"} to access corresponding page
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("/signin")
    public ResponseEntity<?> postSignIn(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword())
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        MyUserDetailsImpl userDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        System.out.println("The Incomming SignIn User is :");
        System.out.println(userDetails.getUuid());
        String jwt = jwtUtils.generateJwtToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                .collect(Collectors.toList());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUuid());
        return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getUuid(),
                userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        //    String email,
        //    String username,
        //    String firstName,
        //    String lastName,
        //    String password,
        //    boolean active
        User user = new User(
                signUpRequest.getEmail(),
                signUpRequest.getUsername(),
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                encoder.encode(signUpRequest.getPassword()),true);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
                        "Refresh token is not in database!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@Valid @RequestBody LogoutRequest logOutRequest) {
        refreshTokenService.deleteByUserId(logOutRequest.getUuid());
        return ResponseEntity.ok(new MessageResponse("Log out successful!"));
    }

//
//    /**
//     * Page: index_before_login.html
//     *       index_after_login.html
//     *       admin_index_after_login.html
//     * Role:
//     *       index_before_login(ROLE_ALL)
//     *       index_after_login(ROLE_USER)
//     *       admin_index_after_login.html(ROLE_ADMIN)
//     */
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
//
//    /**
//     * Page: login.html
//     * Role: ROLE_ALL
//     */
//    @GetMapping("/login")
//    public String login(HttpSession httpSession) {
//        if (myUserDetailsService.isUserAuthenticated()) {
//            return "redirect:/";
//        }
//        System.out.println("Controller.login() [session:]"+httpSession.getId());
//        return "/login.html";
//    }
//
//    /**
//     * Page: signup.html
//     * Role: ROLE_ALL
//     */
//    @GetMapping("/signup")
//    public String allGetSignup(Model model) {
//        model.addAttribute("signupDto", new SignupDto());
//        return "signup";
//    }
//
//    /**
//     * Page: signup.html
//     * Role: ROLE_ALL
//     */
//    @PostMapping("/signup")
//    //@RequestParam("profile") MultipartFile multipartFile
//    public String allPostSignup(@ModelAttribute("signupDto") @Valid SignupDto signupDto, HttpServletRequest request, Errors errors) {
//        //Profile Upload
////        String filename =StringUtils.cleanPath(multipartFile.getOriginalFilename());
////        signupDto.setProfile(filename);
//        try{
//            User registered =  myUserDetailsService.signupNewUser(signupDto);
//        } catch (UserAlreadyExistException e) {
//            e.printStackTrace();
//            ModelAndView errorModelAndView = new ModelAndView("signup");
//            errorModelAndView.addObject("message","An Account for that email already exists.");
//
//            return "redirect:/signup";
//        }
//        ModelAndView modelAndView = new ModelAndView("/");
//        return "redirect:/";
//    }
//
//
//    /**
//     * Page: index_after_login.html
//     * Role: ROLE_USER
//     */
//    @GetMapping("/user/{uuid}/index_after_login")
//    public String userindexAfterLogin(HttpServletRequest request, @PathVariable String uuid, Model model) {
//        model.addAttribute("myuuid",uuid);
//        return "index_after_login";
//    }
//
//
//    /**
//     * Page: admin_index_after_login.html
//     * Role: ROLE_ADMIN
//     */
//    @GetMapping("/admin/{uuid}/index_after_login")
//    public String adminIndexAfterLogin(HttpServletRequest request, @PathVariable String uuid, Model model) {
//        model.addAttribute("uuid",uuid);
//        System.out.println("Controller.adminIndexAfterLogin() [session:]"+request.getSession().getId());
//        return "admin_index_after_login";
//    }
//
//    /**
//     * Page: admin_system_info.html
//     * Role: ROLE_ADMIN
//     */
//    @GetMapping("/admin/{uuid}/systeminfo")
//    public String adminGetSystemInfo(HttpServletRequest request, @PathVariable String uuid, Model model) {
//        request.getSession(true);
//        model.addAttribute("uuid",uuid);
//        System.out.println("Controller.adminGetSystemInfo() [session:]"+request.getSession().getId());
//        return "admin_system_info";
//    }
//
//    @GetMapping("/accountSettings")
//    public String getAccountSettings(Model model) {
//        model.addAttribute("signupDto", new SignupDto());
//        return "account_settings";
//    }
//
//    @GetMapping("/changePassword")
//    public String getChangePassword(Model model) {
//        model.addAttribute("signupDto", new SignupDto());
//        return "change_password";
//    }
}

