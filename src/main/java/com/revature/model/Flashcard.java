package com.revature.model;

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


// how we call a method -> Flashcard flashcard = new Flashcard();      new Flashcard("q", "a");
public class Flashcard {

    // a unique identifier to separate flashcards
    public int id;
    public String question;
    public String answer;


    public Flashcard(){

    }

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Flashcard(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Q: " + question + "\n" +
                "A: " + answer + "\n";
    }
}
