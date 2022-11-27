package com.vero.DiningReviewAPI.persistence.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String zipcode;
    private String phone;
    private String website;
    private int peanutScore;
    private int eggScore;
    private int dairyScore;
    private int overallScore;

    public Restaurant(String name, String address, String zipcode, String phone, String website) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
        this.website = website;
        this.peanutScore =0;
        this.eggScore=0;
        this.dairyScore=0;
        this.overallScore=0;
    }
    
    
}
