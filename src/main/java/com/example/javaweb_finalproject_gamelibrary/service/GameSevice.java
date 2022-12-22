package com.example.javaweb_finalproject_gamelibrary.service;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSevice {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames(long id){
        return (List<Game>) gameRepository.findAll();
    }

    public Game getGameById(long id){
        return gameRepository.findById(id).orElse(null);
    }

    public Game addGame(GameRequest gameRequest){
        Game game = new Game(gameRequest);
        return gameRepository.save(game);
    }

    public Game updateGame(long id, GameRequest gameRequest){
        gameRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("ID IS NOT FOUND"));
        Game gameToUpdate = new Game(gameRequest);
        gameToUpdate.setId(id);

        return gameRepository.save(gameToUpdate);
    }

    public void deleteGame(long id){
        if(gameRepository.existsById(id)){
            gameRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("GAME NOT FOUND");
        }
    }

}
