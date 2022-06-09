package com.revature;

import com.revature.controller.FlashcardController;
import com.revature.model.User;
import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import org.eclipse.jetty.http.HttpMethod;

import java.util.Iterator;
import java.util.function.Predicate;

// The purpose of the Driver class is to Drive or Launch
public class Driver {

    public static int x = 5;

    public static void main(String[] args){

        BC bc = new BC();
        bc.doSomething();
        int x = Driver.x;
        FlashcardController flashcardController = new FlashcardController();
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
    }
}

/*      Access Modifiers are labels that we can place in front of class, method, and variable declarations
                        inside of class         inside a different package (subclass)   inside of package (different class)       globally accessible
        public          x                       x                                       x                                         x
        default         x                                                               x
        protected       x                       x
        private         x
 */

abstract class AC{
    protected void doSomething(){
        System.out.println("Hi");
        User u = new User();
        // get the first name
        // u.firstName
        System.out.println(u.getFirstName());
        u.setFirstName("Bob");
        System.out.println(u.getFirstName());
        System.out.println(u.isAdmin());
    }

    abstract void doSomethingElse();
}

class BC extends AC{
    public void callSomething(){
        super.doSomething();
    }

    @Override
    protected void doSomethingElse() {

    }
}