package edu.duke.summer.client.service;

import edu.duke.summer.client.database.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDtails implements UserDetails {

    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private boolean active;
    private List<GrantedAuthority> authorityList;


    public MyUserDtails(User user) {
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

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
