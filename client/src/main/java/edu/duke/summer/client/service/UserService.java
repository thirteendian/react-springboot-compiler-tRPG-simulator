package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.dto.UserDto;

public interface UserService {

    //todo: password match
    User createNewUser(UserDto registerDto);

    //todo: check password here?
    //todo: fail throw exception
    User logIn(UserDto userDto);

    //todo: fail: already log out throw exception
    void logOut (UserDto userDto);
}
