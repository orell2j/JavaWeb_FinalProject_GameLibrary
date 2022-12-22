package com.example.javaweb_finalproject_gamelibrary.entity;

import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long GameId;

    @Column(name = "Title", nullable = false)
    private String Title;

    @Column(name = "Publisher", nullable = false)
    private String Publisher;

    @Column(name = "Description", nullable = true)
    private String Description;



    public Game(GameRequest gameRequest){

        GameId = gameRequest.getGameId();

        Title = gameRequest.getTitle();

        Publisher = gameRequest.getPublisher();

        Description = gameRequest.getDescription();
    }
}
