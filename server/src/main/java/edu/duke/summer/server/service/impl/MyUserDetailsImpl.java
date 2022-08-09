package edu.duke.summer.server.service.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.duke.summer.server.database.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MyUserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String uuid;
    private String email;
    @JsonIgnore
    private String password;

    private String username;

    private String firstname;
    private String lastname;
    private boolean active;
    private Collection<? extends GrantedAuthority> authorities;


    public MyUserDetailsImpl(String uuid, String email,
                             String password,
                             String username,
                             String firstname,
                             String lastname,
                             boolean active,
                             Collection<? extends GrantedAuthority> authorities) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.active = active;
        this.authorities = authorities;
    }

    public static MyUserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new MyUserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.isActive(),
                authorities);
    }
//    public MyUserDetailsImpl(User user) {
//        this.uuid = user.getId();
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//        this.active = user.isActive();
//        this.firstname = user.getFirstName();
//        this.lastname = user.getLastName();
//        this.authorities = Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String getPassword() {
        return password;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
