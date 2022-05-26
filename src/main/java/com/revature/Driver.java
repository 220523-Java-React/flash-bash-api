package com.revature;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        System.out.println("Application started.\n"); // \n prints a new line
        // class to receive user input
        // what is this statement???
        Scanner scanner = new Scanner(System.in);
        // object initialization
        // objects are runtime entities that contain states (variables) and behaviors (methods)
        // classes are blueprints for objects
        System.out.println("Welcome to FlashBash!!");
        System.out.println("What would you like to do?");
        System.out.println("1) Create a Flashcard");
        System.out.println("2) View all Flashcards");
        System.out.println("0) Exit\n");

        int flag;
        // it will execute the code once, and then loop if the flag is not 1.
        do {
            System.out.println("Please enter a menu option.");
            String input = scanner.nextLine();
            switch(input) { // only gets evaluated once
               case "1":
                   System.out.println("Create a flashcard");
                   flag = 1;
                   break;
               case "2":
                   System.out.println("View all flashcards");
                   flag = 1;
                   break;
               case "0":
                   System.out.println("Exiting the application");
                   flag = 1;
                   break;
               default:
                   flag = 0;
           }
        } while (flag != 1);

    }
}
