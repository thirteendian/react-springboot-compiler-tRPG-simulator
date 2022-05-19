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
    //todo
    public User createNewUser(UserDto registerDto) {
        return null;
//        if(accountExist(email)) {
//            throw new IllegalArgumentException("There is already an account under this email address.");
//        }
//        User user = new User();
//        user.setEmail(email);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setPassword(password);
//        user.setActive(true);
//        return userRepository.save(user);
    }

    public boolean accountExist(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User logIn(UserDto userDto) {
        return null;
    }

    @Override
    public void logOut(UserDto userDto) {

    }
}
