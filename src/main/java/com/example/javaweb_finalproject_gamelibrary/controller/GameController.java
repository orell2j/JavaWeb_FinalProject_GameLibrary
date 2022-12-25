package com.example.javaweb_finalproject_gamelibrary.controller;


import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import com.example.javaweb_finalproject_gamelibrary.response.GameResponse;
import com.example.javaweb_finalproject_gamelibrary.response.ReviewResponse;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import com.example.javaweb_finalproject_gamelibrary.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@RequiredArgsConstructor
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    GameRepository gameRepository;


    @PostMapping("/{gameId}/reviews")
    public ReviewResponse addReview(@PathVariable long gameId,
                                    @Valid @RequestBody ReviewRequest reviewRequest){

        return new ReviewResponse(gameService.addReview(gameId, reviewRequest));

    }

    @GetMapping("{userId}/Games")
    public List<Game> getGamesByUserId(@PathVariable long userId) {
        return gameService.getGamesByUserId(userId);
    }

    @GetMapping("/{gameId}/reviews")
    public List<ReviewResponse> getAllReviews(@PathVariable long gameId){
        List<Review> reviews = gameService.getAllReviews(gameId);
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for (int i=0; i < reviews.size(); i++){
            reviewResponses.add(new ReviewResponse(reviews.get(i)));
        }
        return reviewResponses;
    }



    //get all games
    @GetMapping("/Games")
    public List<GameResponse> getAllGames(@PathVariable long gameId){
        List<Game> games = gameService.getAllGames(gameId);
        List<GameResponse> gameResponses = new ArrayList<>();
        games.forEach(game -> {
            GameResponse gameResponse = new GameResponse(game);
            gameResponses.add(gameResponse);
        });
        return gameResponses;
    }


    @GetMapping("/title/{title}")
    public List<GameResponse> getGamesByTitle(@PathVariable String title){
        List<Game> games = gameService.getGamesByTitle(title);
        List<GameResponse> gameResponses = new ArrayList<>();
        games.forEach(game->{
            GameResponse gameResponse = new GameResponse(game);
            gameResponses.add(gameResponse);
        });
        return gameResponses;
    }


    @GetMapping("/{gameId}")
    public Game getGameById(@PathVariable long gameId){

        return gameService.getGameById(gameId);
    }


    //add game post request
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse addGame(@Valid @RequestBody GameRequest gameRequest){
        Game savedGame = gameService.addGame(gameRequest);
        return new GameResponse(savedGame);
    }


    @PutMapping("/{gameId}")
    public GameResponse updateGame(@PathVariable long gameId, @Valid @RequestBody GameRequest gameRequest){
        //Validate that the game exists

        Game gameToUpdate = gameService.getGameById(gameId);
        if (gameToUpdate == null){
            throw new ResourceNotFoundException("Game with ID " + gameId + " not found");
        }

        //Update the game with new data from the request
        gameToUpdate.setTitle(gameRequest.getTitle());
        gameToUpdate.setPublisher(gameRequest.getPublisher());
        gameToUpdate.setDescription(gameRequest.getDescription());

        Game updatedGame = gameService.updateGame(gameId, gameToUpdate);

        // Return the updated game as a response
        return new GameResponse(updatedGame);
    }


    @DeleteMapping("/{gameId}")
    public void deleteGame (@PathVariable long gameId){
        gameService.deleteGame(gameId);
    }


}
