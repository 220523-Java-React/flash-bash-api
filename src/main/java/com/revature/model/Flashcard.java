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


import java.io.Serializable;
import java.util.Objects;

// how we call a method -> Flashcard flashcard = new Flashcard();      new Flashcard("q", "a");
public class Flashcard implements Serializable {

    // a unique identifier to separate flashcards
    private int id;
    private String question;
    private String answer;
    private Topic topic;
    private User creator;


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

    public int getId() {
        return id;
    }

    public Flashcard setId(int id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Flashcard setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Flashcard setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Topic getTopic() {
        return topic;
    }

    public Flashcard setTopic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public User getCreator() {
        return creator;
    }

    public Flashcard setCreator(User creator) {
        this.creator = creator;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return id == flashcard.id && Objects.equals(question, flashcard.question) && Objects.equals(answer, flashcard.answer) && topic == flashcard.topic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, topic);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", topic=" + topic +
                '}';
    }
}
