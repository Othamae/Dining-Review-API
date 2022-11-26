package com.vero.DiningReviewAPI.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vero.DiningReviewAPI.persistence.Repository.RestaurantRepository;
import com.vero.DiningReviewAPI.persistence.Repository.ReviewRepository;
import com.vero.DiningReviewAPI.persistence.Repository.UserRepository;
import com.vero.DiningReviewAPI.exceptions.ReviewExceptions;
import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;
import com.vero.DiningReviewAPI.persistence.Entity.User;

import lombok.AllArgsConstructor;
import java.util.List;


@Service
@AllArgsConstructor
public class ReviewServices {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;


    public Review addNewReview(Review review){
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(review.getRestaurantId());
        if (!restaurantOptional.isPresent()){
            throw new ReviewExceptions("Restaurant not found", HttpStatus.NOT_FOUND);
        }
        return reviewRepository.save(review);
    }


    public User createNewUser(User user) {
        return null;
    }



    public User updateUserProfile(String name, User updateUser) {
        return null;
    }


    public User findUser(String name) {
        return null;
    }


    public List<Review> reviewPendingApproval() {
        return null;
    }


    public Review changeStatusReview(Long reviewId, ReviewStatus status) {
        return null;
    }


    public List<Review> approvedReviewsByRestaurant(Long restaurantId) {
        return null;
    }


    public Restaurant addNewRestaurant(Restaurant restaurant) {
        return null;
    }


    public Restaurant findRestaurantById(Long id) {
        return null;
    }


    public List<Restaurant> findRestaurantByZipCode(String zipCode) {
        return null;
    }
    

}

