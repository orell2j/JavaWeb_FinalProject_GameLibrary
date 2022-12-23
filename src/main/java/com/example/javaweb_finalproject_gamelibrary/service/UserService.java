package com.example.javaweb_finalproject_gamelibrary.service;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.entity.User;
import com.example.javaweb_finalproject_gamelibrary.repository.UserRepository;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

}
