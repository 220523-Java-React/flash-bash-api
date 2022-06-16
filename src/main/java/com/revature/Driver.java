package com.revature;

import com.revature.controller.FlashcardController;
import com.revature.controller.UserController;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import org.eclipse.jetty.http.HttpMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// The purpose of the Driver class is to Drive or Launch
public class Driver {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();




        int x = 1;
        Integer wrapInt = x; // autobox -> automatically wrap a primitive in its Class equivalent

        intList.add(x);
        int y = intList.get(0); // unbox -> automatically unwrap a wrapper class into its primitive

        // Wrapper Class?
        /*  Serve as wrappers to convert a primitive type into it's Object equivalent
            byte            Byte
            short           Short
            int             Integer
            long            Long
            float           Float
            double          Double
            char            Character
            boolean         Boolean
         */


        FlashcardController flashcardController = new FlashcardController();
        UserController userController = new UserController();
        Javalin app = Javalin.create().start(8080);
        app.get("/", context -> context.result("Welcome to the FlashBashAPI"));

        // Flashcard Bindings   -> URL? -> /flashcards
        // Operations?
        // GET
        // POST
        app.get("/flashcards", flashcardController.getAllFlashcards);
        // the {} are for path variable
        app.get("/flashcards/{id}", flashcardController.getFlashcardById);
        app.post("/flashcards", flashcardController.setFlashcard);

        app.get("/users", userController.getAllUsers);
        app.post("/users", userController.createNewUser);
    }
}