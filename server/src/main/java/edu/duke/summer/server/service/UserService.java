package edu.duke.summer.server.service;

import edu.duke.summer.server.database.model.User;
import edu.duke.summer.server.dto.SignupDto;

//TODO:CAN BE DELETED
public interface UserService {

    User createNewUser(SignupDto signupDto);

    User logIn(SignupDto signupDto);

    void logOut (SignupDto signupDto);


    public boolean isUserAuthenticated();
}
