package com.revature.service;

import com.revature.model.Flashcard;
import com.revature.model.Topic;
import com.revature.repository.FlashcardRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlashcardService {

    private FlashcardRepository flashcardRepository;

    public FlashcardService() {
        flashcardRepository = new FlashcardRepository();
    }



    // Dependency Injection is to decouple code
    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    // focus on creating a new flashcard in isolation
    //           pass in a flashcard
    //           we don't want to be dependent on the add method working


    // Mocking -> Fake Object
    //      Example
    //      Std List Add : Take input and add to the list
    //      Mock List    : We can explicitly state what should do and when it should it
    public Flashcard createNewFlashcard(Flashcard flashcard) {
       return flashcardRepository.create(flashcard);
    }

    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.getAll();
    }

    public List<Flashcard> getAllFlashcardsByTopic(Topic topic){
        return flashcardRepository.getAllByTopic(topic);
    }

    public Flashcard getFlashcardById(int id) {
        return flashcardRepository.getById(id);
    }

    public int something(){
        return 0;
    }

    public void printSomething(){
        System.out.println(something());
    }
}
