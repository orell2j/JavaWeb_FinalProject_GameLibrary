package com.example.javaweb_finalproject_gamelibrary.controller;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import com.example.javaweb_finalproject_gamelibrary.response.GameResponse;
import com.example.javaweb_finalproject_gamelibrary.response.ReviewResponse;
import com.example.javaweb_finalproject_gamelibrary.service.GameSevice;
import com.example.javaweb_finalproject_gamelibrary.service.ReviewService;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/Games/")
@RequiredArgsConstructor

public class GameController {

    @Autowired
    GameSevice gameService;

    @Autowired
    GameRepository gameRepository;

    @PostMapping("/{GameId}/Reviews")
    public ReviewResponse addReview(@PathVariable long GameId,
                                    @Valid @RequestBody ReviewRequest reviewRequest){

        return new ReviewResponse(gameService.addReview(GameId, reviewRequest));

    }

    @GetMapping("/{GameId}/Reviews")
    public List<ReviewResponse> getAllReviews(@PathVariable long GameId){
        List<Review> reviews = gameService.getAllReviews(GameId);
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for (int i=0; i < reviews.size(); i++){
            reviewResponses.add(new ReviewResponse(reviews.get(i)));
        }
        return reviewResponses;
    }

    //get all games
    /*
    @GetMapping
    public List<GameResponse> getAllGames(@PathVariable long GameId){
        List<Game> games = gameService.getAllGames(GameId);
        List<GameResponse> gameResponses = new ArrayList<>();
        games.forEach(game -> {
            GameResponse gameResponse = new GameResponse(game);
            gameResponses.add(gameResponse);
        });
        return gameResponses;
    }
    */

    @GetMapping
    public List<GameResponse> getAllGames(@RequestParam(required = false) String Title){

        List<Game> games = gameService.getAllGames(Title);

        List<GameResponse> gamesResponse = new ArrayList<>();
        games.forEach(game -> {
            gamesResponse.add(new GameResponse(game));
        });

        return gamesResponse;

    }

    @GetMapping("/{GameId}")
    public Game getGameById(@PathVariable long GameId){
        return gameService.getGameById(GameId);
    }

    //add game post request
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse addGame(@Valid @RequestBody GameRequest gameRequest){
        Game savedGame = gameService.addGame(gameRequest);
        return new GameResponse(savedGame);
    }

    @PutMapping("/{GameId}")
    public GameResponse updateGame(@PathVariable long GameId, @Valid @RequestBody GameRequest gameRequest){
        Game gameToBeUpdated = gameService.updateGame(GameId, gameRequest);
        return new GameResponse(gameToBeUpdated);
    }

    @DeleteMapping("/{GameId}")
    public void deleteGame (@PathVariable long GameId){
        gameService.deleteGame(GameId);
    }

}
