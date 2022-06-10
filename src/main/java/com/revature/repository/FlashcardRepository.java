package com.revature.repository;

import com.revature.model.Flashcard;
import com.revature.model.Topic;

import java.util.ArrayList;
import java.util.List;

/*
        Acts as our Central Source for Flashcard storage and operations that affect what is contained
 */
public class FlashcardRepository implements DAO<Flashcard> {

    private List<Flashcard> flashcards;

    public FlashcardRepository(){
        flashcards = new ArrayList<>();
    }

    public FlashcardRepository(List<Flashcard> flashcards){
        this.flashcards = flashcards;
    }

    @Override
    public Flashcard create(Flashcard flashcard) {
        if(flashcards.add(flashcard)){
            return flashcard;
        } else{
            return null;
        }
    }

    @Override
    public List<Flashcard> getAll() {
        return flashcards;
    }

    @Override
    public Flashcard getById(int id) {
        for (int i = 0; i < flashcards.size(); i++) {
            if (flashcards.get(i).getId() == id) {
                return flashcards.get(i);
            }
        }
        return null;
    }

    public List<Flashcard> getAllByTopic(Topic topic){
        List<Flashcard> filteredFlashcards = new ArrayList<>();

        for(Flashcard flashcard: flashcards){
            if(flashcard.getTopic().equals(topic)){
                filteredFlashcards.add(flashcard);
            }
        }

        return filteredFlashcards;
    }

    //TODO: implement these eventually
    @Override
    public Flashcard update(Flashcard flashcard) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
