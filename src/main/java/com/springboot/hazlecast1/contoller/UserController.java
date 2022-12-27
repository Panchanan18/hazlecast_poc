package com.springboot.hazlecast1.contoller;

import com.springboot.hazlecast1.model.User;
import com.springboot.hazlecast1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("Inside the createUser method of UserController");
     User savedUser=userService.createUser(user);
     return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> findAllUser(){
        log.info("Inside the findAllUser method of UserController");

        return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id){
        log.info("Inside the findUserById method of UserController");

        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK);

    } @GetMapping("/getUserByName/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable String name){
        log.info("Inside the findUserByName method of UserController");

        return new ResponseEntity<>(userService.findUserByName(name),HttpStatus.OK);

    }


}
