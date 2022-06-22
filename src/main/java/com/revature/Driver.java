package com.revature;

import com.revature.controller.AuthController;
import com.revature.controller.FlashcardController;
import com.revature.controller.UserController;

import com.revature.model.Role;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The purpose of the Driver class is to Drive or Launch
public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args){
        logger.error("This is an error");

        FlashcardController flashcardController = new FlashcardController();
        UserController userController = new UserController();

        Javalin app = Javalin.create().start(8080);
        app.get("/", context -> context.result("Welcome to the FlashBashAPI"));

        // Flashcard Bindings   -> URL? -> /flashcards
        // Operations?
        // GET
        // POST
        app.get("/flashcards", flashcardController.getAllFlashcards);
        // the {} are for path variable
        // /flashcards/1
        app.get("/flashcards/{id}", flashcardController.getFlashcardById);
        app.post("/flashcards", flashcardController.setFlashcard);

        app.get("/users", userController.getAllUsers);
        app.get("/users/{id}", userController.getUserById);
        app.post("/users", userController.createNewUser);
        app.put("/users", userController.updateUser);
        app.delete("/users/{id}", userController.deleteUserById);

        app.post("/authenticate", AuthController.authenticate);
        app.post("/register", userController.createNewUser);

        app.before("/users*", AuthController.withAuth);
        app.before("/users*", AuthController.test);
        app.before("/flashcards*", AuthController.withAuth);
    }
}