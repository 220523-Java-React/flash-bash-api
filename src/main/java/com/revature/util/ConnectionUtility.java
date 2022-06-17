package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *      Problem: We are creating a connection each time -> this is bad
 *      Solution: Create the first connection, and then each time we need it, we return that specific connection
 *      Implementation: Leverage a new Design Pattern: Singleton Design Pattern -> a pattern to ensure only one instance can exist
 *      1- make sure I can't create ConnectionUtility objects -> make a private constructor
 *      2- a private reference to an instance of the singleton within the class itself
 *      3- we need to check if the instance exists when we try to getInstance()
 *              if it doesnt exist -> create it and assign to the local instance reference
 *              if it does exist (instance != null) return that perfectly valid instance
 */

public class ConnectionUtility {

    private static Connection instance;
    private static Properties properties;


    /**
            JDBC API
            Java DataBase Connectivity
            Has all the interfaces and objects that we need in our app to work with a database

            We will bring in a Postgres driver that will satisfy the implementation
     */
    public static Connection getConnection() throws SQLException{

        if(properties == null){
            // make sure the properties gets load
            properties = loadProperties();
        }

        if(instance == null || instance.isClosed()){ // we have not yet created a connection

//            Class.forName("org.postgresql.Driver");
            instance = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password"));
        }
        return instance;
    }

    public static Properties loadProperties(){
        Properties properties = new Properties();
        try{
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/db-config.properties");
            properties.load(fileInputStream);
        } catch(IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    private ConnectionUtility(){

    }
}
