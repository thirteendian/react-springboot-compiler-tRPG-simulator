package edu.duke.summer.server.service;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.dto.SignupDto;
import edu.duke.summer.server.exceptions.UserAlreadyExistException;
import edu.duke.summer.server.service.impl.MyUserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface MyUserDetailsService extends UserDetailsService {

    boolean isUserAuthenticated();
    boolean isUserhasRole(String inputRole);
    MyUserDetailsImpl loadMyUserDetailsOfCurrentUser();
    User signupNewUser(SignupDto signupDto) throws UserAlreadyExistException;
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
