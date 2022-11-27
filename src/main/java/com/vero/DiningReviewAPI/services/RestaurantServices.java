package com.vero.DiningReviewAPI.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vero.DiningReviewAPI.persistence.Repository.RestaurantRepository;
import com.vero.DiningReviewAPI.services.dto.RestaurantInDTO;
import com.vero.DiningReviewAPI.exceptions.ReviewExceptions;
import com.vero.DiningReviewAPI.mapper.RestaurantInDTOToRestaurant;
import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import lombok.AllArgsConstructor;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServices {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantInDTOToRestaurant mapper;


    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) this.restaurantRepository.findAll();
    }

    public Restaurant addNewRestaurant(RestaurantInDTO restaurantInDTO) {
        Restaurant restaurant = mapper.map(restaurantInDTO);
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findByNameAndZipcode(restaurant.getName(), restaurant.getZipcode());
        if (restaurantOptional.isPresent()){
            throw new ReviewExceptions("Restaurant already exist", HttpStatus.BAD_REQUEST);
        }  
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant findRestaurantById(Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);
        if (!restaurantOptional.isPresent()){
            throw new ReviewExceptions("Restaurant not found", HttpStatus.NOT_FOUND);
        }
        Restaurant restaurantfound = restaurantOptional.get();
        return restaurantfound;
    }


    public List<Restaurant> findRestaurantByZipcode(String zipcode) {
        return this.restaurantRepository.findAllByZipcode(zipcode);
    }

}
