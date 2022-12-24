package com.example.javaweb_finalproject_gamelibrary.controller;


import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import com.example.javaweb_finalproject_gamelibrary.response.ReviewResponse;
import com.example.javaweb_finalproject_gamelibrary.service.GameService;
import com.example.javaweb_finalproject_gamelibrary.service.ReviewService;
import com.example.javaweb_finalproject_gamelibrary.repository.GameRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/games/{gameId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;


    @GetMapping("/{reviewId}")
    public ReviewResponse getReview(@PathVariable long reviewId){
        Review review = reviewService.getReview(reviewId);
        return new ReviewResponse(review);
    }


    @PutMapping("/{reviewId}")
    public ReviewResponse updateReview(@PathVariable long reviewId, @Valid @RequestBody ReviewRequest reviewRequest){
        Review reviewToBeUpdated = reviewService.updateReview(reviewId, reviewRequest);
        return new ReviewResponse(reviewToBeUpdated);
    }


    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable long reviewId){
        reviewService.deleteReview(reviewId);
    }


}
