package com.example.javaweb_finalproject_gamelibrary.service;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import com.example.javaweb_finalproject_gamelibrary.repository.ReviewRepository;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSevice {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public Review addReview(long id, ReviewRequest reviewRequest){
        Game game = gameRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Game id not found"));
        Review reviewToBeSaved = new Review(reviewRequest);
        reviewToBeSaved.setGame(game);
        return reviewRepository.save(reviewToBeSaved);
    }

    public List<Review> getAllReviews(long id){
        return reviewRepository.findAllByGameId(id);
    }

    //get all game Records
    //public List<Game> getAllGames(long GameId){return (List<Game>) gameRepository.findAll();}

    public List<Game> getAllGames(String title){
        return (List<Game>) gameRepository.findAll();
    }

    public Game getGameById(long GameId){

        return gameRepository.findById(GameId).orElse(null);
    }

    //add game method that takes the request and use JPA to save method to save Game object to the table
    public Game addGame(GameRequest gameRequest){
        Game game = new Game(gameRequest);
        return gameRepository.save(game);
    }

    public Game updateGame(long GameId, GameRequest gameRequest){
        gameRepository.findById(GameId).orElseThrow( ()->new ResourceNotFoundException("ID IS NOT FOUND"));
        Game gameToUpdate = new Game(gameRequest);
        gameToUpdate.setId(GameId);

        return gameRepository.save(gameToUpdate);
    }

    public void deleteGame(long GameId){
    /*
        if(gameRepository.existsById(GameId)){
            gameRepository.deleteById(GameId);
        }
        else{
            throw new ResourceNotFoundException("GAME NOT FOUND");
        }
    */
        gameRepository.findById(GameId).orElseThrow(()->new ResourceNotFoundException("GAME ID NOT FOUND"));
        gameRepository.deleteById(GameId);
    }

}
