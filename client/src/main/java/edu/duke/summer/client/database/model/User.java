package edu.duke.summer.client.database.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(unique = true, nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private String password;

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

    @Override
    public boolean equals(Object o) {
        if(!getClass().equals(o.getClass())) return false;
        User user = (User) o;
        return email.equals(user.getEmail());
    }
}
