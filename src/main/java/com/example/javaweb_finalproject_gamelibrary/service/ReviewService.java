package com.example.javaweb_finalproject_gamelibrary.service;

import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.repository.ReviewRepository;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReview(long ReviewId){
        Review review = reviewRepository.findById(ReviewId).orElseThrow(()->new ResourceNotFoundException("Review id not found"));
        return review;
    }

    public Review updateReview(long ReviewId, ReviewRequest reviewRequest){
        if(reviewRepository.existsById(ReviewId)){
            Review reviewToBeUpdated = new Review(reviewRequest);
            reviewToBeUpdated.setId(ReviewId);

            return reviewRepository.save(reviewToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("REVIEW ID NOT FOUND");
        }
    }

    public void deleteReview(long ReviewId){
        if(reviewRepository.existsById(ReviewId)){
            reviewRepository.deleteById(ReviewId);
        }
        else{
            throw new ResourceNotFoundException("Review id not found");
        }
    }

}
