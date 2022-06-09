package com.revature.controller;

import com.revature.Driver;
import com.revature.model.Flashcard;
import com.revature.model.Topic;
import com.revature.service.FlashcardService;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.*;


public class FlashcardController {

    FlashcardService flashcardService = new FlashcardService();

    public Handler getAllFlashcards = context -> {
        // get our list of flashcards
        List<Flashcard> flashcards = new ArrayList<>();
        // check to see if there are any arguments, if so, filter by those arguments and return the result
        // if not, return all flashcards
        String topicParam = context.queryParam("topic"); // this could be null


        // if topic is null, get all flashcards
        if(topicParam == null){
            flashcards = flashcardService.getAllFlashcards();
        }
        // if topic is not null, get all flashcards by topic
        else {
            try{
                Topic topic = Topic.valueOf(topicParam.toUpperCase(Locale.ROOT));
                flashcards = flashcardService.getAllFlashcardsByTopic(topic);
            }catch(IllegalArgumentException e){

                String failureMessage = "{\"success\":false, \"message\":\"" +
                        "Please only use the following topic values: " + Arrays.toString(Topic.values())
                        + "\"}";

                context.status(400).json(failureMessage);
                return;
            }
        }
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
            context.status(HttpStatus.BAD_REQUEST_400);
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
