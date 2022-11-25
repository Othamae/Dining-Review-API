package com.vero.DiningReviewAPI.persistence.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;

public interface ReviewRepository extends CrudRepository<Review, Long>{
    public List<Review> findByStatus(ReviewStatus status);
    public List<Review> findByRestaurantIdAndStatus(Long restaurantId, ReviewStatus status);
}
