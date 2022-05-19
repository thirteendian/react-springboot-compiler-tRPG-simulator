package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import edu.duke.summer.client.dto.UserDto;

public interface UserService {

    User createNewUser(UserDto userDto);

    User logIn(UserDto userDto);

    void logOut (UserDto userDto);
}
