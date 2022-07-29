package edu.duke.summer.client.database.model;

import edu.duke.summer.client.annotation.ValidEmail;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A Table in Postgresql named users
 * <p>
 *     Note that it should not be named as user, or it will conflict with the original user created by spring security
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    @ValidEmail
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String roles;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = true)
    private String profile;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public User() {
    }

    public User(String email, String firstName, String lastName, String password, String roles, boolean active) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (!getClass().equals(o.getClass())) return false;
        User user = (User) o;
        return email.equals(user.getEmail());
    }
}
