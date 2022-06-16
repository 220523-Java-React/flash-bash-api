package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {


    private final static String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=flash_bash";
    private final static String user = "postgres";
    private final static String password = "1324Pass!";

    /**
            JDBC API
            Java DataBase Connectivity
            Has all the interfaces and objects that we need in our app to work with a database

            We will bring in a Postgres driver that will satisfy the implementation
     */
    public static Connection getConnection(){
        try{
//            Class.forName("org.postgresql.Driver");    <- only add if you can't solve the No Suitable Driver Found exception
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
