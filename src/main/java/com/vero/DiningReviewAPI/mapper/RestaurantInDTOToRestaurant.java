package com.vero.DiningReviewAPI.mapper;


import org.springframework.stereotype.Component;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;
import com.vero.DiningReviewAPI.services.dto.RestaurantInDTO;

@Component
public class RestaurantInDTOToRestaurant implements IMapper<RestaurantInDTO, Restaurant>{

    @Override
    public Restaurant map(RestaurantInDTO in){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(in.getName());
        restaurant.setAddress(in.getAddress());
        restaurant.setZipCode(in.getZipCode());
        restaurant.setPhone(in.getPhone());
        restaurant.setWebsite(in.getWebsite());
        restaurant.setPeanutScore(0);
        restaurant.setEggScore(0);
        restaurant.setDairyScore(0);
        restaurant.setOverallScore(0);

        return restaurant;
    }

       

}
