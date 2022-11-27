package com.vero.DiningReviewAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.services.RestaurantServices;
import com.vero.DiningReviewAPI.services.dto.RestaurantInDTO;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantServices restaurantServices;

    public RestaurantController (RestaurantServices restaurantServices){
        this.restaurantServices = restaurantServices;
    }

    @GetMapping
    public List<Restaurant> findAllRestaurants(){
        return this.restaurantServices.findAllRestaurants();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Restaurant addNewRestaurant(@RequestBody RestaurantInDTO restaurant){
        return this.restaurantServices.addNewRestaurant(restaurant);
    }

   
    
    @GetMapping("/restaurants/{id}")
    public Restaurant findRestaurantById(@PathVariable("id") Long id){
        return this.restaurantServices.findRestaurantById(id);
    }

    @GetMapping("/restaurants/{zipCode}")
    public List<Restaurant> findRestaurantsByZipCode(@PathVariable("zipCode")String zipCode){
        return this.restaurantServices.findRestaurantByZipCode(zipCode);
    }
}
