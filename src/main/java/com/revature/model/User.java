package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

/*
        Java BEAN - a special type of model, which has private variables with public accessors. implement Serializable, override hashCode, equals, toString
        How to achieve:
            - make the fields private
            - provide public methods to interact with them (getters/setters)

 */

/*
        The Builder Design pattern, is a pattern to alleviate need for complex and unnecessary constructors for a model
        that I want to be able to decide what properties to instantiate upon creation

        Solution -> is to make the setters on the model, return the instance itself so that we can daisy chain setters
 */
public class User implements Serializable {

    // These are instance variables
    // State of the object
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role = Role.USER;

    public User(){

    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName(){
        return firstName;
    }

    public User setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}

enum Role{
    USER, ADMIN
}
