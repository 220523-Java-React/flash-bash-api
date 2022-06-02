package com.revature.model;


public class User {

    // These are instance variables
    // State of the object
    public String firstName;
    public String lastName;
    public String username;
    public String password;

    public User(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
