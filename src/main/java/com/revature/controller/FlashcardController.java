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
        String question = context.body().substring(0,context.body().indexOf("\n"));
        System.out.print(question);
        String answer = context.body().substring(context.body().indexOf("\n"));
        System.out.println(answer);

        Flashcard newFlashcard = new Flashcard(question,answer);
        flashcardService.createNewFlashcard(newFlashcard);
    };

}
