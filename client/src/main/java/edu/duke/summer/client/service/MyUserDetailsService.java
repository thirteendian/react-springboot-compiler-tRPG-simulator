package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.dto.SignupDto;
import edu.duke.summer.client.exceptions.UserAlreadyExistException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDetailsService extends UserDetailsService {
    boolean isUserAuthenticated();
    MyUserDtails loadMyUserDetailsOfCurrentUser();
    User signupNewUser(SignupDto signupDto) throws UserAlreadyExistException;

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
