package com.example.javaweb_finalproject_gamelibrary.controller;

import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import com.example.javaweb_finalproject_gamelibrary.response.GameResponse;
import com.example.javaweb_finalproject_gamelibrary.service.GameSevice;
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

    @GetMapping("/{GameId}")
    public Game getGameById(@PathVariable long GameId){
        return gameService.getGameById(GameId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public GameResponse addGame(@Valid @RequestBody GameRequest gameRequest){
        Game savedGame = gameService.addGame(gameRequest);
        return new GameResponse(savedGame);
    }

    @PutMapping("/{GameId}")
    public GameResponse updateGame(@PathVariable long GameId, @Valid @RequestBody GameRequest gameRequest){
        Game updateGame = gameService.updateGame(GameId, gameRequest);
        return new GameResponse(updateGame);
    }

    @DeleteMapping("/{GameId}")
    public void deleteGame (@PathVariable long GameId){
        gameService.deleteGame(GameId);
    }

}
