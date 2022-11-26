package com.vero.DiningReviewAPI.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vero.DiningReviewAPI.persistence.Repository.RestaurantRepository;
import com.vero.DiningReviewAPI.persistence.Repository.ReviewRepository;
import com.vero.DiningReviewAPI.persistence.Repository.UserRepository;
import com.vero.DiningReviewAPI.services.dto.ReviewInDTO;
import com.vero.DiningReviewAPI.exceptions.ReviewExceptions;
import com.vero.DiningReviewAPI.mapper.ReviewInDTOToReview;
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
    private final ReviewInDTOToReview mapper;


    public Review addNewReview(ReviewInDTO reviewInDTO){
        Review review = mapper.map(reviewInDTO);
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(review.getRestaurantId());
        if (!restaurantOptional.isPresent()){
            throw new ReviewExceptions("Restaurant not found", HttpStatus.NOT_FOUND);
        }
        
        return reviewRepository.save(review);
    }


    public User createNewUser(User user) {
        Optional<User> userToCreate = this.userRepository.findByName(user.getName());
        if (userToCreate.isPresent()){
            throw new ReviewExceptions("User already exist", HttpStatus.BAD_REQUEST);
        }
        return this.userRepository.save(user);
    }



    public User updateUserProfile(String name, User updateUser) {
        Optional<User> userToUpdateOptional = this.userRepository.findByName(name);
        if (!userToUpdateOptional.isPresent()){
            throw new ReviewExceptions("User not found", HttpStatus.NOT_FOUND);
        }
        User userToUpdate = userToUpdateOptional.get();
        if (userToUpdate.getCity()!=updateUser.getCity()){
            userToUpdate.setCity(updateUser.getCity());
        }
        if (userToUpdate.getState()!=updateUser.getState()){
            userToUpdate.setState(updateUser.getState());
        }
        if (userToUpdate.getZipcode()!=updateUser.getZipcode()){
            userToUpdate.setZipcode(updateUser.getZipcode());
        }
        if (userToUpdate.getPeanutAllergies()!=updateUser.getPeanutAllergies()){
            userToUpdate.setPeanutAllergies(updateUser.getPeanutAllergies());
        }
        if (userToUpdate.getEggAllergies()!=updateUser.getEggAllergies()){
            userToUpdate.setEggAllergies(updateUser.getEggAllergies());
        }
        if (userToUpdate.getDairyAllergies()!=updateUser.getDairyAllergies()){
            userToUpdate.setDairyAllergies(updateUser.getDairyAllergies());
        }
        this.userRepository.save(userToUpdate);
        return userToUpdate;
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

