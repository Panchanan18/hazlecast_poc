package com.springboot.hazlecast1.service;

import com.springboot.hazlecast1.model.User;
import com.springboot.hazlecast1.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        log.info("Inside the createUser method of UserService");

        return userRepository.save(user);
    }
    @Cacheable(cacheNames = {"userCache"})
    public List<User> findAllUser() {
        log.info("Inside the findAllUser method of UserService");
        log.info("Hit DB for first time");

        return userRepository.findAll();
    }

    @Cacheable(cacheNames = {"userCache"}, key = "#id", unless = "#result==null")
    public User findUserById(int id) {
        log.info("Inside the findUserById method of UserService");

        return userRepository.findById(id).get();
    }

    @Cacheable(cacheNames = {"userCache"}, key = "#name",unless = "#result==null")
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
