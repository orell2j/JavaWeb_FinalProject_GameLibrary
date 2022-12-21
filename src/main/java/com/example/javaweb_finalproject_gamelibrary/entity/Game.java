package com.example.javaweb_finalproject_gamelibrary.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter

public class Game {

    private long Id;

    private String Title;

    private String Genre;

    private String Description;

    //request
    public Game(){

    }
}
