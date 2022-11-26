package com.vero.DiningReviewAPI.mapper;

import org.springframework.stereotype.Component;

import com.vero.DiningReviewAPI.persistence.Entity.Review;
import com.vero.DiningReviewAPI.persistence.Entity.ReviewStatus;
import com.vero.DiningReviewAPI.services.dto.ReviewInDTO;

@Component
public class ReviewInDTOToReview implements IMapper<ReviewInDTO, Review>{
    
    @Override
    public Review map(ReviewInDTO in){
        Review review = new Review();
        review.setWhoSubmitted(in.getWhoSubmitted());
        review.setRestaurantId(in.getRestaurantId());
        review.setCommentary(in.getCommentary());
        review.setPeanutScore(in.getPeanutScore());
        review.setEggScore(in.getEggScore());
        review.setDairyScore(in.getDairyScore());
        review.setStatus(ReviewStatus.PENDING);
        return review;
    }
    
}
    

