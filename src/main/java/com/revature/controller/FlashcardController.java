package com.revature.controller;

import com.revature.Driver;
import com.revature.model.Flashcard;
import com.revature.service.FlashcardService;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;


public class FlashcardController {

    FlashcardService flashcardService = new FlashcardService();

    public Handler getAllFlashcards = context -> {
        // get our list of flashcards
        List<Flashcard> flashcards = flashcardService.getAllFlashcards();
        context.json(flashcards);
    };

    // intended to receive an id in the request
    public Handler getFlashcardById = context -> {
        // how do I pass more information when asking for information
        String param = context.pathParam("id");
        int id = 0;
        try{
            id = Integer.parseInt(param);
            context.json(flashcardService.getFlashcardById(id));
        } catch (NumberFormatException e){
            // i would log it
            context.result("Stop giving me words as IDS");
            context.status(400);
        } catch(NullPointerException e){
            System.out.println("Oops");
        }
        // TODO: add a null check on the getFlashcardById
    };

    public Handler setFlashcard = ctx -> {
        Flashcard flashcard = ctx.bodyAsClass(Flashcard.class);
        flashcardService.createNewFlashcard(flashcard);
    };

}
