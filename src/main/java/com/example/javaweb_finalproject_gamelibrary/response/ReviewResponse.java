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

    private long ReviewId;

    private String Comment;

    private int Rating;

    private GameResponse game;

    public ReviewResponse(Review review) {
        ReviewId = review.getReviewId();
        Comment = review.getComment();
        Rating = review.getRating();
        game = new GameResponse(review.getGame());
    }
}
