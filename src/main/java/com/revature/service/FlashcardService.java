package com.revature.service;

import com.revature.model.Flashcard;
import com.revature.model.Topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlashcardService {

    // this is creating an empty list of type flashcard
    private List<Flashcard> flashcards;

    public FlashcardService() {
        flashcards = new ArrayList<>();
    }

    // Dependency Injection is to decouple code
    public FlashcardService(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    // focus on creating a new flashcard in isolation
    //           pass in a flashcard
    //           we don't want to be dependent on the add method working


    // Mocking -> Fake Object
    //      Example
    //      Std List Add : Take input and add to the list
    //      Mock List    : We can explicitly state what should do and when it should it
    public boolean createNewFlashcard(Flashcard flashcard) {
        return flashcards.add(flashcard);
    }

    public List<Flashcard> getAllFlashcards() {
        return flashcards;
    }

    public List<Flashcard> getAllFlashcardsByTopic(Topic topic){
        List<Flashcard> filteredFlashcards = new ArrayList<>();

        for(Flashcard flashcard: flashcards){
            if(flashcard.getTopic().equals(topic)){
                filteredFlashcards.add(flashcard);
            }
        }

        return filteredFlashcards;
    }

    public Flashcard getFlashcardById(int id) {
        // some sort of logic to traverse through the list and find the flashcard with an id that matches
        for (int i = 0; i < flashcards.size(); i++) {
            if (flashcards.get(i).getId() == id) {
                return flashcards.get(i);
            }
        }
        return null;
    }
}
