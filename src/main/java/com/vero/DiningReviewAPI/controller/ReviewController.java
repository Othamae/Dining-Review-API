package com.vero.DiningReviewAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;
import com.vero.DiningReviewAPI.persistence.Entity.User;
import com.vero.DiningReviewAPI.services.ReviewServices;

import java.util.List;

import org.springframework.http.HttpStatus;


@RequestMapping("/reviews")
@RestController
public class ReviewController {
   
    private final ReviewServices reviewServices;    
   
    public ReviewController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }


    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createNewUser (@RequestBody User user){
        return this.reviewServices.createNewUser(user);
    }

    @PutMapping("/users/update/{name}")
    public User updateUserProfile (@PathVariable("name") String name, @RequestBody User updateUser){
        return this.reviewServices.updateUserProfile(name, updateUser);
    }

    @GetMapping("/users/{name}")
    public User findUser(@PathVariable("name") String name){
        return this.reviewServices.findUser(name);
    }

    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Review addNewReview (@RequestBody Review review){        
        return this.reviewServices.addNewReview(review);       
    }

    @GetMapping("/pending")
    public List<Review> reviewPendingApproval(){
        return this.reviewServices.reviewPendingApproval();
    }

    @PostMapping("/status/{reviewId}")
    public Review changeStatusReview (@PathVariable("reviewId") Long reviewId, @RequestBody ReviewStatus status){
        return this.reviewServices.changeStatusReview(reviewId, status);
    }

    @GetMapping("/approved/{restaurantId}")
    public List<Review> approvedReviewsByRestaurant(@PathVariable("restaurantId") Long restaurantId){
        return this.reviewServices.approvedReviewsByRestaurant(restaurantId);
    }

    @PostMapping("/restaurants/new")
    public Restaurant addNewRestaurant(@RequestBody Restaurant restaurant){
        return this.reviewServices.addNewRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id){
        return this.reviewServices.findRestaurantById(id);
    }

    @GetMapping("/restaurants/{zipCode}")
    public List<Restaurant> findRestaurantsByZipCode(@PathVariable("zipCode")String zipCode){
        return this.reviewServices.findRestaurantByZipCode(zipCode);
    }
}
