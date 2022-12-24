package com.example.javaweb_finalproject_gamelibrary.controller;


import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import com.example.javaweb_finalproject_gamelibrary.response.ReviewResponse;
import com.example.javaweb_finalproject_gamelibrary.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{ReviewId}")
    public ReviewResponse getReview(@PathVariable long ReviewId){
        return new ReviewResponse(reviewService.getReview(ReviewId));
    }

    @GetMapping("/{ReviewId}")
    public ReviewResponse updateReview(@PathVariable long ReviewId, @Valid @RequestBody ReviewRequest reviewRequest){
        return new ReviewResponse(reviewService.updateReview(ReviewId, reviewRequest));
    }

    @DeleteMapping("/{ReviewId}")
    public void deleteCourse(@PathVariable long ReviewId){
        reviewService.deleteReview(ReviewId);
    }
}
