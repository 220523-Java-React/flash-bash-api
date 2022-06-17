package com.revature.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtilityTest {

    @Test
    public void whenGivenValidCredentialsGetConnectionReturnsValidConnection() throws SQLException {
        Connection connection = ConnectionUtility.getConnection();

        Assertions.assertNotNull(connection);
    }

    @Test
    public void whenLoadPropertiesIsCalledLoadsValidProperties(){
        String url="jdbc:postgresql://localhost:5432/postgres?currentSchema=flash_bash";
        String user="postgres";
        String password="1324Pass!";
        Properties properties = ConnectionUtility.loadProperties();

        Assertions.assertEquals(url, properties.getProperty("url"));
        Assertions.assertEquals(user, properties.getProperty("user"));
        Assertions.assertEquals(password, properties.getProperty("password"));

    }
}
