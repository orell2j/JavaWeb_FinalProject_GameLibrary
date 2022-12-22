package com.example.javaweb_finalproject_gamelibrary.service;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSevice {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames(){
        return (List<Game>) gameRepository.findAll();
    }

}
