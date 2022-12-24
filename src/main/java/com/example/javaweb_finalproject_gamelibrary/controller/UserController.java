package com.example.javaweb_finalproject_gamelibrary.controller;

import com.example.javaweb_finalproject_gamelibrary.entity.User;
import com.example.javaweb_finalproject_gamelibrary.request.UserRequest;
import com.example.javaweb_finalproject_gamelibrary.response.UserResponse;
import com.example.javaweb_finalproject_gamelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("")
@RequestMapping("/api/Users/")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    UserService userService;


    //register a new user
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(@Valid @RequestBody UserRequest userRequest){
        User savedUser = userService.addUser(userRequest);
        return new UserResponse(savedUser);
    }


    //get all users
    @GetMapping
    public List<UserResponse> getAllUsers(){
        List<User> users = userService.getAllUsers();
        List<UserResponse> userResponses = new ArrayList<>();
        users.forEach(user -> {
            UserResponse userResponse = new UserResponse(user);
            userResponses.add(userResponse);
        });
        return userResponses;
    }


    //get user by userId
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }


    //update user by userId
    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable long userId, @Valid @RequestBody UserRequest userRequest){
        User userToBeUpdated = userService.updateUser(userId, userRequest);
        return new UserResponse(userToBeUpdated);
    }


    //delete user by userId
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId){

        userService.deleteUser(userId);

    }

}