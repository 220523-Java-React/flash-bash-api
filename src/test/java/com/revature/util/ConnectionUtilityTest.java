package com.revature.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionUtilityTest {

    @Test
    public void whenGivenValidCredentialsGetConnectionReturnsValidConnection(){
        Connection connection = ConnectionUtility.getConnection();

        Assertions.assertNotNull(connection);
    }
}
