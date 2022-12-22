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
    private long id;

    @Column(name = "Title", nullable = false)
    private String Title;

    @Column(name = "Genre", nullable = false)
    private String Genre;

    @Column(name = "Description", nullable = true)
    private String Description;



    public Game(GameRequest gameRequest){

        id = gameRequest.getId();

        Title = gameRequest.getTitle();

        Genre = gameRequest.getGenre();

        Description = gameRequest.getDescription();
    }
}
