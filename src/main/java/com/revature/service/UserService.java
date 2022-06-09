package com.revature.service;

import com.revature.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> users;

    public UserService(){
        users = new ArrayList<>();
    }

    public UserService(List<User> users){
        this.users = users;
    }

    public boolean createUser(User user){
        return users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(int id){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == id){
                return users.get(i);
            }
        }

        return null;
    }

    public boolean deleteUserById(int id){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == id){
                users.remove(i);
                return true;
            }
        }

        return false;
    }
}
