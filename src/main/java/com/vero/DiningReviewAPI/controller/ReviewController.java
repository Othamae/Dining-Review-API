package com.vero.DiningReviewAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;
import com.vero.DiningReviewAPI.services.ReviewServices;
import com.vero.DiningReviewAPI.services.dto.ReviewInDTO;


@RequestMapping("/reviews")
@RestController
public class ReviewController {
   
    private final ReviewServices reviewServices;    
   
    public ReviewController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @GetMapping
    public List<Review> findAllReviews(){
        return this.reviewServices.findAllReviews();
    }

        
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Review addNewReview (@RequestBody ReviewInDTO reviewInDTO){        
        return this.reviewServices.addNewReview(reviewInDTO);       
    }

        
    @GetMapping("/pending")
    public List<Review> reviewPendingApproval(){
        return this.reviewServices.reviewPendingApproval();
    }

    @PutMapping("/status/{reviewId}")
    public Review changeStatusReview (@PathVariable("reviewId") Long reviewId, @RequestBody ReviewStatus status){
        return this.reviewServices.changeStatusReview(reviewId, status);
    }

    @GetMapping("/approved/{restaurantId}")
    public List<Review> approvedReviewsByRestaurant(@PathVariable("restaurantId") Long restaurantId){
        return this.reviewServices.approvedReviewsByRestaurant(restaurantId);
    }

}
