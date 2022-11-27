package com.vero.DiningReviewAPI.persistence.Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String whoSubmitted;
    private Long restaurantId;
    private String commentary;
    private int peanutScore;
    private int eggScore;
    private int dairyScore;
    private ReviewStatus status;


}
