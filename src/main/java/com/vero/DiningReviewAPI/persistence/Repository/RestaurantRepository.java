package com.vero.DiningReviewAPI.persistence.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vero.DiningReviewAPI.persistence.Entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{
    public Optional<Restaurant> findByNameAndZipcode(String name, String zipcode);
    public Optional<Restaurant> findById(Long id);
    public List<Restaurant> findByZipcodeOrderByOverallScoreDesc(String zipcode);
    public List<Restaurant> findAllByZipcode(String zipcode);
}
