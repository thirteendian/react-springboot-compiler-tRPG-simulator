package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import edu.duke.summer.client.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//TODO:CAN BE DELETED
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    @Override
    public User createNewUser(SignupDto signupDto) {
        return null;
    }

    @Override
    public User logIn(SignupDto signupDto) {
        return null;
    }

    @Override
    public void logOut(SignupDto signupDto) {

    }
    @Override
    public boolean isUserAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null&& authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("USER"))|| authentication.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ADMIN"))){
            return true;
        }
        else{
            return false;
        }
    }

    //    @Override
//    public User createNewUser(UserDto userDto) {
//        if(accountExist(userDto.getEmail())) {
//            throw new IllegalArgumentException("There is already an account under this email address.");
//        }
//        User user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        //password will be a length of 60 encrypted string with salt
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setActive(true);
//
////        //Set authentication
////        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
////        Authentication authentication = (Authentication) authenticationManager.authenticate(authReq);
////        SecurityContext securityContext = SecurityContextHolder.getContext();
////        securityContext.setAuthentication((org.springframework.security.core.Authentication) authentication);
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User logIn(UserDto userDto) {
//        //check account exist
//        if(!accountExist(userDto.getEmail())) {
//            throw new IllegalArgumentException("Email address doesn't exist, please sign up first.");
//        }
//        //check password correct
//        if(!passwordCorrect(userDto.getEmail(), userDto.getPassword())) {
//            throw new IllegalArgumentException("The password is incorrect.");
//        }
//        //login, active account
//        User user = userRepository.findByEmail(passwordEncoder.encode(userDto.getEmail()));
//        user.setActive(true);
//        return user;
//    }
//
//    @Override
//    public void logOut(UserDto userDto) {
//        //check account exist
//        if(!accountExist(userDto.getEmail())) {
//            throw new IllegalArgumentException("Email address doesn't exist, please sign up first.");
//        }
//        //check current status is login
//        if(!isActive(userDto.getEmail())) {
//            throw new IllegalArgumentException("You have not logged in yet");
//        }
//        userRepository.findByEmail(userDto.getEmail()).setActive(false);
//    }
//
//
//    /**
//     * utilities
//     */
//    public boolean accountExist(String email) {
//        return userRepository.existsUserByEmail(email);
//    }
//
//    public boolean passwordCorrect(String email, String providedPassword) {
//        return userRepository.findByEmail(email).getPassword().equals(providedPassword);
//    }
//
//    public boolean isActive(String email) {
//        return userRepository.findByEmail(email).isActive();
//    }
}
