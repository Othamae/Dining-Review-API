package com.vero.DiningReviewAPI.services;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vero.DiningReviewAPI.persistence.Repository.UserRepository;


import com.vero.DiningReviewAPI.exceptions.ReviewExceptions;
import com.vero.DiningReviewAPI.persistence.Entity.User;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServices {

    private final UserRepository userRepository;
  
    public List<User> findAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    public User createNewUser(User user) {
        Optional<User> userToCreate = this.userRepository.findByName(user.getName());
        if (userToCreate.isPresent()){
            throw new ReviewExceptions("User already exist", HttpStatus.BAD_REQUEST);
        }
        return this.userRepository.save(user);
    }
    
   
    
    
    public User updateUserProfile(String name, User updateUser) {
        Optional<User> userToUpdateOptional = this.userRepository.findByName(name);
        if (!userToUpdateOptional.isPresent()){
            throw new ReviewExceptions("User not found", HttpStatus.NOT_FOUND);
        }
        User userToUpdate = userToUpdateOptional.get();
        if (userToUpdate.getCity()!=updateUser.getCity()){
            userToUpdate.setCity(updateUser.getCity());
        }
        if (userToUpdate.getState()!=updateUser.getState()){
            userToUpdate.setState(updateUser.getState());
        }
        if (userToUpdate.getZipcode()!=updateUser.getZipcode()){
            userToUpdate.setZipcode(updateUser.getZipcode());
        }
        if (userToUpdate.getPeanutAllergies()!=updateUser.getPeanutAllergies()){
            userToUpdate.setPeanutAllergies(updateUser.getPeanutAllergies());
        }
        if (userToUpdate.getEggAllergies()!=updateUser.getEggAllergies()){
            userToUpdate.setEggAllergies(updateUser.getEggAllergies());
        }
        if (userToUpdate.getDairyAllergies()!=updateUser.getDairyAllergies()){
            userToUpdate.setDairyAllergies(updateUser.getDairyAllergies());
        }
        this.userRepository.save(userToUpdate);
        return userToUpdate;
    }



    public User findUser(String name) {
        Optional<User> userOptional =  this.userRepository.findByName(name);
        if (!userOptional.isPresent()){
            throw new ReviewExceptions("User not found", HttpStatus.NOT_FOUND);
        }
        User userfound = userOptional.get();
        return userfound;        
    }

    
}
