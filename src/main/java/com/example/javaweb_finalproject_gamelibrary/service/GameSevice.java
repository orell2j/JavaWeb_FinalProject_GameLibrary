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

    public List<Game> getAllGames(long GameId){
        return (List<Game>) gameRepository.findAll();
    }

    public Game getGameById(long GameId){
        return gameRepository.findById(GameId).orElse(null);
    }

    public Game addGame(GameRequest gameRequest){
        Game game = new Game(gameRequest);
        return gameRepository.save(game);
    }

    public Game updateGame(long GameId, GameRequest gameRequest){
        gameRepository.findById(GameId).orElseThrow( ()->new ResourceNotFoundException("ID IS NOT FOUND"));
        Game gameToUpdate = new Game(gameRequest);
        gameToUpdate.setGameId(GameId);

        return gameRepository.save(gameToUpdate);
    }

    public void deleteGame(long GameId){
        if(gameRepository.existsById(GameId)){
            gameRepository.deleteById(GameId);
        }
        else{
            throw new ResourceNotFoundException("GAME NOT FOUND");
        }
    }

}
