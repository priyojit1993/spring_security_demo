package com.example.springSecurityDemo.repository;

import com.example.springSecurityDemo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByName(String userName);
}
