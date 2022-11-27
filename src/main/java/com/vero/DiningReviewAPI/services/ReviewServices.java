package com.vero.DiningReviewAPI.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vero.DiningReviewAPI.persistence.Repository.RestaurantRepository;
import com.vero.DiningReviewAPI.persistence.Repository.ReviewRepository;
import com.vero.DiningReviewAPI.services.dto.ReviewInDTO;
import com.vero.DiningReviewAPI.exceptions.ReviewExceptions;
import com.vero.DiningReviewAPI.mapper.ReviewInDTOToReview;
import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;
import lombok.AllArgsConstructor;
import java.util.List;


@Service
@AllArgsConstructor
public class ReviewServices {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final ReviewInDTOToReview mapper;
    
    public List<Review> findAllReviews() {
        return (List<Review>) this.reviewRepository.findAll();
    }

    
    public Review addNewReview(ReviewInDTO reviewInDTO){
        Review review = mapper.map(reviewInDTO);
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(review.getRestaurantId());
        if (!restaurantOptional.isPresent()){
            throw new ReviewExceptions("Restaurant not found", HttpStatus.NOT_FOUND);
        }        
        return reviewRepository.save(review);
    }

    
    public List<Review> reviewPendingApproval() {
        return this.reviewRepository.findByStatus(ReviewStatus.PENDING);       
    }


    // public Review changeStatusReview(Long reviewId, ReviewStatus status) {
    //     if(status!= ReviewStatus.ACCEPTED && status!= ReviewStatus.REJECTED){
    //         throw new ReviewExceptions("Incorrect Status. It should be ACCEPTED or REJECTED", HttpStatus.BAD_REQUEST);
    //     }
    //     Optional<Review> reviewOptional = this.reviewRepository.findById(reviewId);
    //     if (!reviewOptional.isPresent()){
    //         throw new ReviewExceptions("Review not found", HttpStatus.NOT_FOUND);
    //     }
    //     Review reviewToChange = reviewOptional.get();
    //     if (reviewToChange.getStatus() == ReviewStatus.ACCEPTED || reviewToChange.getStatus() == ReviewStatus.REJECTED){
    //         throw new ReviewExceptions("Review was already Accepted or Rejected, not possible to change it.", HttpStatus.BAD_REQUEST);
    //     }        
    //     reviewToChange.setStatus(status);      
    //     return this.reviewRepository.save(reviewToChange);
    // }
    @Transactional
    public Review changeStatusReview(Long reviewId, ReviewStatus status) {        
        Optional<Review> reviewOptional = this.reviewRepository.findById(reviewId);
        if (!reviewOptional.isPresent()){
            throw new ReviewExceptions("Review not found", HttpStatus.NOT_FOUND);
        }
        Review reviewToChange = reviewOptional.get();
        Boolean accepted = true;
        if (status!=ReviewStatus.ACCEPTED){
            accepted = false;
        }
        if(accepted){
            reviewToChange.setStatus(ReviewStatus.ACCEPTED);
        } else {
            reviewToChange.setStatus(ReviewStatus.REJECTED);
        }
        Review reviewChanged = this.reviewRepository.save(reviewToChange);
        return reviewChanged;
    }


    public List<Review> approvedReviewsByRestaurant(Long restaurantId) {
        return this.reviewRepository.findByRestaurantIdAndStatus(restaurantId, ReviewStatus.ACCEPTED);

    }


    

    
    

   
    

}

