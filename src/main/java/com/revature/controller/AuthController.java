package com.revature.controller;


import com.auth0.jwt.exceptions.JWTVerificationException;
import com.revature.model.User;
import com.revature.service.AuthService;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.Handler;

public class AuthController {

    public static Handler authenticate = context -> {

        User user = context.bodyAsClass(User.class);
        String token = AuthService.authenticateUser(user);

        if(token != null){
            context.status(200).result("Bearer " + token);
        } else{
            context.status(401).result("Bad credentials.");
        }
    };

    // design the handler so that every other handler must first go through this one
    public static Handler withAuth = context -> {
        // check for the authorization header

        try{
            String token = context.header("Authorization").replace("Bearer ", "");
            // I need a way to verify that the token is valid
            AuthService.isValidToken(token);

        } catch(NullPointerException | JWTVerificationException e){
            throw new ForbiddenResponse("You must add a valid Bearer token");
        }
    };


    public static Handler test = context -> {
        System.out.println("Did this work???");
    };


}
