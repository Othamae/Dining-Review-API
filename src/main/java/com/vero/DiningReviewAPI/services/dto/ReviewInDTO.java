package com.vero.DiningReviewAPI.services.dto;

import lombok.Data;

@Data
public class ReviewInDTO {    
    private Long restaurantId;
    private String whoSubmitted;
    private String commentary;
    private int peanutScore;
    private int eggScore;
    private int dairyScore;
}
