package com.example.javaweb_finalproject_gamelibrary.service;


import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import com.example.javaweb_finalproject_gamelibrary.exception.ResourceNotFoundException;
import com.example.javaweb_finalproject_gamelibrary.repository.ReviewRepository;
import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReview(long reviewId){
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("REVIEW ID NOT FOUND"));
        return review;
    }

    public Review updateReview(long reviewId, ReviewRequest reviewRequest){
        if(reviewRepository.existsById(reviewId)){
            Review reviewToBeUpdated = new Review(reviewRequest);
            reviewToBeUpdated.setId(reviewId);

            return reviewRepository.save(reviewToBeUpdated);
        }
        else{
            throw new ResourceNotFoundException("REVIEW ID NOT FOUND");
        }
    }

    public void deleteReview(long reviewId){
        if(reviewRepository.existsById(reviewId)){
            reviewRepository.deleteById(reviewId);
        }
        else{
            throw new ResourceNotFoundException("REVIEW ID NOT FOUND");
        }

    }

}
