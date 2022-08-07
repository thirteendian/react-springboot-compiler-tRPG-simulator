package edu.duke.summer.server;

import com.sun.istack.NotNull;
import edu.duke.summer.server.annotation.PasswordMatches;
import edu.duke.summer.server.annotation.ValidEmail;

import javax.validation.constraints.NotEmpty;

@PasswordMatches
public class Signup {
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
