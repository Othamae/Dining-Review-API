package com.vero.DiningReviewAPI.services.dto;
import lombok.Data;

@Data
public class RestaurantInDTO {    
    private String name;
    private String address;
    private String zipCode;
    private String phone;
    private String website;

}
