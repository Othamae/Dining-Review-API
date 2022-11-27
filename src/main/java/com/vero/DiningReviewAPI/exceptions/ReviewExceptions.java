package com.vero.DiningReviewAPI.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class ReviewExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;
   
    public ReviewExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message= message;
        this.httpStatus = httpStatus;
    }
}
