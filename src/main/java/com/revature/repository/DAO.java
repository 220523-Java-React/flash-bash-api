package com.revature.repository;


/*
        An interface for the DAO Design Pattern
            Data Access Objects
            These objects are dedicated to performing CRUD operations on behalf of a data set.

            Which CRUD operations will apply to every single repository that we create
 */

import java.sql.SQLException;
import java.util.List;

/*
        Generics: data type placeholders that allow you to provide the same implementation for different data types
        while also adhering to type safety

        List<String>
        List<Flashcard>
 */
public interface DAO<T> {

    T create(T t);

    List<T> getAll();

    T getById(int id);

    T update(T t);

    boolean deleteById(int id);
}
