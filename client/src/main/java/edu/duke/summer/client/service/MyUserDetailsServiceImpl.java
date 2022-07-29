package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import edu.duke.summer.client.dto.SignupDto;
import edu.duke.summer.client.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDtails::new).get();
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
    public MyUserDtails loadMyUserDetailsOfCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> user = userRepository.findByEmail(username);
        return user.map(MyUserDtails::new).get();
    }

    @Override
    public User signupNewUser(SignupDto signupDto) throws UserAlreadyExistException {
        if (userRepository.findByEmail(signupDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(
                    "Your email has already been registered!");
        }
        User newUser = new User();
        newUser.setEmail(signupDto.getEmail());
        newUser.setUserName(signupDto.getUsername());
        newUser.setFirstName(signupDto.getFirstName());
        newUser.setLastName(signupDto.getLastName());
        newUser.setRoles("ROLE_USER");
        newUser.setActive(true);
        newUser.setPassword(passwordEncoder.encode(signupDto.getPassword()));
        return userRepository.save(newUser);
    }

}
