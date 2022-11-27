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
import com.vero.DiningReviewAPI.services.dto.RestaurantInDTO;
import com.vero.DiningReviewAPI.services.dto.ReviewInDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
   
    private final ReviewServices reviewServices;    
   
    public ReviewController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @GetMapping
    public List<Review> findAllReviews(){
        return this.reviewServices.findAllReviews();
    }

    @GetMapping("/restaurants")
    public List<Restaurant> findAllRestaurants(){
        return this.reviewServices.findAllRestaurants();
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return this.reviewServices.findAllUsers();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Review addNewReview (@RequestBody ReviewInDTO reviewInDTO){        
        return this.reviewServices.addNewReview(reviewInDTO);       
    }

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createNewUser (@RequestBody User user){
        return this.reviewServices.createNewUser(user);
    }

    @PostMapping("/restaurants/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Restaurant addNewRestaurant(@RequestBody RestaurantInDTO restaurant){
        return this.reviewServices.addNewRestaurant(restaurant);
    }

    @PutMapping("/users/update/{name}")
    public User updateUserProfile (@PathVariable("name") String name, @RequestBody User updateUser){
        return this.reviewServices.updateUserProfile(name, updateUser);
    }

    @GetMapping("/users/{name}")
    public User findUser(@PathVariable("name") String name){
        return this.reviewServices.findUser(name);
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

    
    @GetMapping("/restaurants/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id){
        return this.reviewServices.findRestaurantById(id);
    }

    @GetMapping("/restaurants/{zipCode}")
    public List<Restaurant> findRestaurantsByZipCode(@PathVariable("zipCode")String zipCode){
        return this.reviewServices.findRestaurantByZipCode(zipCode);
    }
}
