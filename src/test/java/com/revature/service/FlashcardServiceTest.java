package com.revature.service;

import com.revature.model.Flashcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FlashcardServiceTest {

    List<Flashcard> mockList = Mockito.mock(List.class);

    @Test
    public void whenGivenFlashcardObjectCreateNewFlashcardDoesNotThrowAnException(){
        Flashcard flashcard = new Flashcard();
        FlashcardService service = new FlashcardService();

        // we've turned our service invocation into an executable that can be called by the assertion
        Assertions.assertDoesNotThrow(() -> service.createNewFlashcard(flashcard));
    }

    @Test
    public void whenGivenFlashObjectCreateNewFlashcardReturnsTrue(){
        Flashcard flashcard = new Flashcard();
        FlashcardService service = new FlashcardService();
        Mockito.when(mockList.add(flashcard)).thenReturn(true);

        boolean result = service.createNewFlashcard(flashcard);
        Assertions.assertTrue(result);
    }



    @Test
    public void whenGivenValidIdGetFlashcardByIdReturnsFlashcardWithThatId(){
        Flashcard flashcard = new Flashcard(0, "question", "answer");

        Mockito.when(mockList.get(0)).thenReturn(flashcard);
        FlashcardService service = new FlashcardService(mockList);
        Flashcard result = service.getFlashcardById(0);

        Assertions.assertEquals(flashcard.id, result.id);
        Assertions.assertEquals(flashcard.question, result.question);
        Assertions.assertEquals(flashcard.answer, result.answer);
    }
}
