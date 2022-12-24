package com.example.javaweb_finalproject_gamelibrary.entity;


import com.example.javaweb_finalproject_gamelibrary.request.GameRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//see it in h2 console
@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Publisher", nullable = false)
    private String publisher;

    @Column(name = "Description", nullable = true)
    private String description;



    public Game(GameRequest gameRequest){

        title = gameRequest.getTitle();

        publisher = gameRequest.getPublisher();

        description = gameRequest.getDescription();

    }

}
