package com.revature.model;

public enum Topic {
    JAVA("JAVA"),
    SQL("SQL"),
    JAVALIN("JAVALIN"),
    HTML("HTML"),
    CSS("CSS"),
    JAVASCRIPT("JAVASCRIPT");

    public final String value;

    Topic(String value){
        this.value = value;
    }
}
