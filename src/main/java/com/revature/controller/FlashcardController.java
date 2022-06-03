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

    public Handler createFlashcard = ctx -> {
        String body = ctx.body();

        String question = body.split("\n")[0];
        String answer = body.split("\n")[1];

        Flashcard flashcard = new Flashcard(question, answer);

        flashcardService.createNewFlashcard(flashcard);

        ctx.result(flashcard.toString());
        ctx.status(201);
    };

}

