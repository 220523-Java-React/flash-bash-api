package com.revature.repository;

import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    @Test
    public void testGetAllUsers(){
        UserRepository userRepository = new UserRepository();

        userRepository.getAll();
    }
}
