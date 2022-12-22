package com.example.javaweb_finalproject_gamelibrary.response;


import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import com.example.javaweb_finalproject_gamelibrary.entity.Game;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {

    private long id;

    private String Title;

    private String Genre;

    private String Description;

    //entity
    public GameResponse (Game game){

        id = game.getId();
        Title = game.getTitle();
        Genre = game.getGenre();
        Description = game.getDescription();
    }
}