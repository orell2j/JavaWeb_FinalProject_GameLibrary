package com.example.javaweb_finalproject_gamelibrary.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import com.example.javaweb_finalproject_gamelibrary.entity.Game;

@Getter
@Setter
@AllArgsConstructor
public class GameResponse {

    private long Id;

    private String Title;

    private String Genre;

    private String Description;

    //entity
    public GameResponse (Game gm){

        Id = gm.getId();
        Title = gm.getTitle();
        Genre = gm.getGenre();
        Description = gm.getDescription();
    }
}
