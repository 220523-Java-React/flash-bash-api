package com.revature.service;

import com.revature.model.Flashcard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlashcardService {

    // this is creating an empty list of type flashcard
    private List<Flashcard> flashcards = new ArrayList<>();

    public FlashcardService(){
        flashcards.add(new Flashcard(
                "Question 1",
                "Answer 1"
        ));

        flashcards.add(new Flashcard(
                "Question 2",
                "Answer 2"
        ));

        flashcards.add(new Flashcard(
                "Question 3",
                "Answer 3"
        ));
    }

    public void createNewFlashcard(Flashcard flashcard){
        flashcards.add(flashcard);
    }

    public List<Flashcard> getAllFlashcards(){
        return flashcards;
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
