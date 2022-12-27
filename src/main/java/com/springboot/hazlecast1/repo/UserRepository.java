package com.springboot.hazlecast1.repo;

import com.springboot.hazlecast1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {
    User findByName(String name);
}
