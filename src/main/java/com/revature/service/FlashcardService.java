package com.revature.service;

import com.revature.model.Flashcard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlashcardService {

    // this is creating an empty list of type flashcard
    private List<Flashcard> flashcards;

    public FlashcardService(){
        flashcards = new ArrayList<>();
    }

    // Dependency Injection is to decouple code
    public FlashcardService(List<Flashcard> flashcards){
        this.flashcards = flashcards;
    }

    // focus on creating a new flashcard in isolation
    //           pass in a flashcard
    //           we don't want to be dependent on the add method working


    // Mocking -> Fake Object
    //      Example
    //      Std List Add : Take input and add to the list
    //      Mock List    : We can explicitly state what should do and when it should it
    public boolean createNewFlashcard(Flashcard flashcard){
        return flashcards.add(flashcard);
    }

    public List<Flashcard> getAllFlashcards(){
        return flashcards;
    }

    public Flashcard getFlashcardById(int id){
        // some sort of logic to traverse through the list and find the flashcard with an id that matches
        for(int i = 0; i < flashcards.size(); i++){
            if(flashcards.get(i).id == id){
                return flashcards.get(i);
            }
        }

        return null;
    }

    // this method will take all of our flashcards and convert the list to a string
    public String getAllFlashcardsAsString(){
        List<Flashcard> flashcards = getAllFlashcards();
        StringBuilder builder = new StringBuilder();
        // the goal is to iterate through each element of the list, and add its values to the string


        // for each individual flashcard in flashcards, add its question to the string, then its answer to the string
        // then create a new line to separate for the next flashcard

        // String Pool
        // hello
        // hello there


        String x = "hello"; // already in the string pool
        String y = "hello"; // immutability?? cannot be changed
        x += " there"; // what happens, is a new string is created in the pool



        /*
                    String Pool
           ->
           ->     Question 1
           ->     Question 1\n
           ->     Question 1\nAnswer1
           ->     Question 1\nAnswer1\n\n
         */

        for (Flashcard flashcard : flashcards) {
            builder
                    .append(flashcard.question).append("\n")
                    .append(flashcard.answer).append("\n\n");
        }

        return builder.toString();
    }

    public int flashcardCount(){
        return flashcards.size();
    }


}
