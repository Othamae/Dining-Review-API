package com.vero.DiningReviewAPI.persistence.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vero.DiningReviewAPI.persistence.Entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

    public Optional<User> findByName(String name);
    public User getUserByName(String name);
    
}
