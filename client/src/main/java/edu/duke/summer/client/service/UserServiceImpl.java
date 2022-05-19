package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import edu.duke.summer.client.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(UserDto userDto) {
        if(accountExist(userDto.getEmail())) {
            throw new IllegalArgumentException("There is already an account under this email address.");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public User logIn(UserDto userDto) {
        //check account exist
        if(!accountExist(userDto.getEmail())) {
            throw new IllegalArgumentException("Email address doesn't exist, please sign up first.");
        }
        //check password correct
        if(!passwordCorrect(userDto.getEmail(), userDto.getPassword())) {
            throw new IllegalArgumentException("The password is incorrect.");
        }
        //login, active account
        User user = userRepository.findByEmail(userDto.getEmail());
        user.setActive(true);
        return user;
    }

    @Override
    public void logOut(UserDto userDto) {
        //check account exist
        if(!accountExist(userDto.getEmail())) {
            throw new IllegalArgumentException("Email address doesn't exist, please sign up first.");
        }
        //check current status is login
        if(!isActive(userDto.getEmail())) {
            throw new IllegalArgumentException("You have not logged in yet");
        }
        userRepository.findByEmail(userDto.getEmail()).setActive(false);
    }


    /**
     * utilities
     */
    public boolean accountExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean passwordCorrect(String email, String providedPassword) {
        return userRepository.findByEmail(email).getPassword().equals(providedPassword);
    }

    public boolean isActive(String email) {
        return userRepository.findByEmail(email).isActive();
    }
}
