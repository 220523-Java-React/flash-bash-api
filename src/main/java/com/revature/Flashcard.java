package com.revature;

// To contain flashcard information for individual flashcard objects


/*
                        What is a flashcard??
                        - Question
                        - Answer
                        -- How do I link them together?
                            - have some sort of variable that would link them
                            - maybe an array??

                     */

// classes define the states and behaviors
// Flashcard:
//      String question;
//      String answer;

// this type of class is called a Model -> a class design to model/represent data or information
public class Flashcard {

    String question;
    String answer;

    @Override
    public String toString() {
        return "Q: " + question + "\n" +
                "A: " + answer + "\n";
    }
}
