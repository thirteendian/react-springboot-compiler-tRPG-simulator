package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.dto.SignupDto;

//TODO:CAN BE DELETED
public interface UserService {

    User createNewUser(SignupDto signupDto);

    User logIn(SignupDto signupDto);

    void logOut (SignupDto signupDto);


    public boolean isUserAuthenticated();
}
