package com.revature;

import com.revature.controller.FlashcardController;
import com.revature.model.User;
import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import org.eclipse.jetty.http.HttpMethod;

import java.util.Iterator;
import java.util.function.Predicate;

// The purpose of the Driver class is to Drive or Launch
public class Driver {

    public static void main(String[] args){
        FlashcardController flashcardController = new FlashcardController();
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
    }
}