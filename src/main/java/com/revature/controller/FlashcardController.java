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

    public Handler createNewFlashcard  = context -> {
        String question = context.body().substring(0,10);
        System.out.println(question);

        String answer = context.body().substring(10);
        System.out.println(answer);

        Flashcard newFlashcard = new Flashcard();
        flashcardService.createNewFlashcard(newFlashcard);
    };

}
