package com.revature.service;

import com.revature.model.Flashcard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlashcardService {

    // this is creating an empty list of type flashcard
    private List<Flashcard> flashcards = new ArrayList<>();

    public void createNewFlashcard(Flashcard flashcard){
        flashcards.add(flashcard);
    }

    public List<Flashcard> getAllFlashcards(){
        return flashcards;
    }

    public int flashcardCount(){
        return flashcards.size();
    }
}
