package com.example.javaweb_finalproject_gamelibrary.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.javaweb_finalproject_gamelibrary.entity.Review;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {

    private String comment;

    private int rating;

    private String username;

    private GameResponse game;

    public ReviewResponse(Review review) {
        comment = review.getComment();
        rating = review.getRating();
        username = review.getUsername();
        game = new GameResponse(review.getGame());

    }

}
