package com.revature.controller;

import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.http.Handler;

import java.util.List;


public class UserController {

    UserService userService;

    public UserController(){
        userService = new UserService();
    }

    public UserController(UserService userService){
        this.userService = userService;
    }

    public Handler getAllUsers = context -> {
        context.json(userService.getAllUsers());
    };

    public Handler createNewUser = context -> {
        // grab the user object from the request body
        // send that to the service, which will return a user (eventually)

        User user = context.bodyAsClass(User.class);
        userService.createUser(user);
    };
}
