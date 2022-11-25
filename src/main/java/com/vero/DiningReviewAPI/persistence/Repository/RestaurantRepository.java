package com.vero.DiningReviewAPI.persistence.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    public Restaurant findByNameAndZipCode(String name, String zipCode);
    public Optional<Restaurant> findById(Long id);
    public List<Restaurant> findByZipCodeOrderByOverallScoreDesc(String zipCode);
}
