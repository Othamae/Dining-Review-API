package com.vero.DiningReviewAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vero.DiningReviewAPI.persistence.Entity.User;
import com.vero.DiningReviewAPI.services.UserServices;
import java.util.List;

import org.springframework.http.HttpStatus;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserServices userServices;

    public UserController(UserServices userServices){
        this.userServices =userServices;
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return this.userServices.findAllUsers();
    }

    @PutMapping("/users/update/{name}")
    public User updateUserProfile (@PathVariable("name") String name, @RequestBody User updateUser){
        return this.userServices.updateUserProfile(name, updateUser);
    }

    @GetMapping("/users/{name}")
    public User findUser(@PathVariable("name") String name){
        return this.userServices.findUser(name);
    }

    @PostMapping("/users/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createNewUser (@RequestBody User user){
        return this.userServices.createNewUser(user);
    }
    


    
}
