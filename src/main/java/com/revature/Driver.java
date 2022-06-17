package com.revature;

import com.revature.controller.FlashcardController;
import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import org.eclipse.jetty.http.HttpMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// The purpose of the Driver class is to Drive or Launch
public class Driver {

    public static void main(String[] args){
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
        app.get("/flashcards/{id}", flashcardController.getFlashcardById);
        app.post("/flashcards", flashcardController.setFlashcard);

        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.createNewUser);
    }
}