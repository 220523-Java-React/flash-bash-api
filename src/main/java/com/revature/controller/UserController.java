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

    public Handler getUserById = context -> {
          String param = context.pathParam("id");

          try{
              // hopefully is not null
              User user = userService.getUserById(
                      Integer.parseInt(param)
              );
              if(user != null){
                  // valid user, return it
                  context.json(user);
              } else {
                  // couldn't find the user, return a 404
                  context.result("User not found").status(404);
              }
          } catch(NumberFormatException e){
              context.result("Please enter only valid integers as an id");
              context.status(400);
          }
    };

    public Handler createNewUser = context -> {
        // grab the user object from the request body
        // send that to the service, which will return a user (eventually)

        User user = context.bodyAsClass(User.class);
        user = userService.createUser(user);

        if(user != null){
            // valid user, return it
            context.json(user);
        } else {
            // some issue with the request
            context.result("User not created").status(400);
        }
    };
}
