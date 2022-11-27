package com.vero.DiningReviewAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.services.RestaurantServices;
import com.vero.DiningReviewAPI.services.dto.RestaurantInDTO;
import org.springframework.http.HttpStatus;



@RequestMapping("/restaurants")
@RestController
public class RestaurantController {

    private final RestaurantServices restaurantServices;

    public RestaurantController(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }

    
   

    @GetMapping
    public List<Restaurant> findAllRestaurants(){
        return this.restaurantServices.findAllRestaurants();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Restaurant addNewRestaurant(@RequestBody RestaurantInDTO restaurantInDTO){
        return this.restaurantServices.addNewRestaurant(restaurantInDTO);
    }
   
    
    @GetMapping("/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id){
        return this.restaurantServices.findRestaurantById(id);
    }

    @GetMapping("/{zipcode}")
    public List<Restaurant> findRestaurantsByZipcode(@PathVariable("zipcode")String zipcode){
        return this.restaurantServices.findRestaurantByZipcode(zipcode);
    }
}
