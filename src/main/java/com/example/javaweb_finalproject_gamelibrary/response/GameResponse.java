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

    private long GameId;

    private String Title;

    private String Publisher;

    private String Description;

    //Game response
    public GameResponse (Game game){

        GameId = game.getGameId();
        Title = game.getTitle();
        Publisher = game.getPublisher();
        Description = game.getDescription();
    }
}