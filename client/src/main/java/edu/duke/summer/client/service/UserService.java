package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;

public interface UserService {

    User createNewUser(String email, String firstName, String lastName, String password);

    boolean accountExist(String email);
}
