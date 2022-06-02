package com.revature.controller;

import com.revature.model.Flashcard;
import com.revature.service.FlashcardService;
import io.javalin.http.Handler;

import java.util.List;


public class FlashcardController {

    FlashcardService flashcardService = new FlashcardService();


    public Handler getAllFlashcards = context -> {
        // get our list of flashcards
        context.result(flashcardService.getAllFlashcardsAsString());
    };

    public Handler setFlashcard = ctx -> {
        String question = ctx.body().split(";")[0];
        String answer = ctx.body().split(";")[1];
        Flashcard f = new Flashcard(question,answer);
        //System.out.println(f);
        flashcardService.createNewFlashcard(f);
    };

}
