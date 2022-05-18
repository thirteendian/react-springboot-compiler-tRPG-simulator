package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(String email, String firstName, String lastName, String password) {
        if(accountExist(email)) {
            throw new IllegalArgumentException("There is already an account under this email address.");
        }
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public boolean accountExist(String email) {
        return userRepository.existsByEmail(email);
    }
}
