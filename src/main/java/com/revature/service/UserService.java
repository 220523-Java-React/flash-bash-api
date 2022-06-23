package com.revature.service;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.create(user);
    }

    public List<User> getAllUsers(){
        return userRepository.getAll();
    }

    public List<User> getAllUsersByRole(Role role){
        return userRepository.getAllByRole(role);
    }

    public User getUserByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public User getUserById(int id){
        return userRepository.getById(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }

    public boolean deleteUserById(int id){
        return userRepository.deleteById(id);
    }
}
