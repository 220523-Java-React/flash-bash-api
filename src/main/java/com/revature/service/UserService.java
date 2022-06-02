package com.revature.service;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

// CRUD
public class UserService {
    private List<User> users = new ArrayList<>();

    // CREATE
    public void createNewUser(User user){
        users.add(user);
    }

    // READ
    public List<User> getAllUsers(){
        return users;
    }
}
