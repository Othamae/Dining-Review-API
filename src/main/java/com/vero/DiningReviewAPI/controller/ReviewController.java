package com.vero.DiningReviewAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ReviewController {
    @RequestMapping("/")
    public String home(){
        return "Prueba";
    }

    @RequestMapping("/api/prueba")
	public String sayHello() {
		return "Swagger Hello World";
	}
}
