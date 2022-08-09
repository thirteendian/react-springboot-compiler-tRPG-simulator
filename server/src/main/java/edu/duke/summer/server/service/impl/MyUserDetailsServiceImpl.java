package edu.duke.summer.server.service.impl;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.database.repository.UserRepository;
import edu.duke.summer.server.dto.SignupDto;
import edu.duke.summer.server.exceptions.UserAlreadyExistException;
import edu.duke.summer.server.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Construct UserDetails by username
     *
     * @param username the username(Email)
     * @return MyUserDetails implements UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Email Not Found with username: " + username));

        return MyUserDetailsImpl.build(user);
    }

    @Override
    public boolean isUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ANONYMOUS"))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isUserhasRole(String inputRole) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRole = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(inputRole));
        return hasRole;
    }

    @Override
    public MyUserDetailsImpl loadMyUserDetailsOfCurrentUser() {
        return null;
    }


    @Override
    public User signupNewUser(SignupDto signupDto) throws UserAlreadyExistException {
        if (userRepository.findByUsername(signupDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(
                    "Your email has already been registered!");
        }
        User newUser = new User();
        newUser.setEmail(signupDto.getEmail());
        newUser.setUsername(signupDto.getUsername());
        newUser.setFirstName(signupDto.getFirstName());
        newUser.setLastName(signupDto.getLastName());
        newUser.setActive(true);
        newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        return userRepository.save(newUser);
    }



}
