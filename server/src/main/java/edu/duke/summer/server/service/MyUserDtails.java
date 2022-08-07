package edu.duke.summer.server.service;

import edu.duke.summer.server.database.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MyUserDtails implements UserDetails {

    private String uuid;
    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private boolean active;
    private List<GrantedAuthority> authorityList;


    public MyUserDtails(User user) {
        this.uuid = user.getId();
        this.userName = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.authorityList = Arrays.stream(user.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    public String getUuid() {
        return uuid;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
