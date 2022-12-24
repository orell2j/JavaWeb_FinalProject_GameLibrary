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

    private String Title;

    private String Publisher;

    private String Description;

    public GameResponse (Game game){

        Title = game.getTitle();
        Publisher = game.getPublisher();
        Description = game.getDescription();
    }
}