package com.example.javaweb_finalproject_gamelibrary.service;


import com.example.javaweb_finalproject_gamelibrary.entity.User;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.request.UserRequest;
import com.example.javaweb_finalproject_gamelibrary.response.UserResponse;
import com.example.javaweb_finalproject_gamelibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(@Valid UserRequest userRequest) {
        User user = new User(userRequest.getUsername(), userRequest.getUserEmail(), userRequest.getPassword());
        return userRepository.save(user);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("USER ID NOT FOUND"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(long userId, @Valid UserRequest userRequest) {
        User userToBeUpdated = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("USER ID NOT FOUND"));
        userToBeUpdated.setUsername(userRequest.getUsername());
        userToBeUpdated.setUserEmail(userRequest.getUserEmail());
        userToBeUpdated.setPassword(userRequest.getPassword());
        return userRepository.save(userToBeUpdated);
    }

    public void deleteUser(long userId) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("USER ID NOT FOUND"));
        userRepository.deleteById(userId);

    }

}
