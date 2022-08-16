package edu.duke.summer.server.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private String uuid;
    private String username;
    private String email;
    private List<String> roles;
    private String firstname;
    private String lastname;

    public JwtResponse(String accessToken, String refreshToken, String uuid, String username, String email, List<String> roles, String firstname, String lastname) {
        this.token = accessToken;
        this.refreshToken = refreshToken;
        this.uuid = uuid;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
