package com.javasampleapproach.diymonds.controller;


import com.javasampleapproach.diymonds.model.User;
import com.javasampleapproach.diymonds.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/users/add")
    public User addUser(@RequestBody User user) {
        System.out.println("Add new user");
        User _user = userRepository.save(new User(user.getUsername()));
        return _user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        System.out.println("Get all users");
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    /* TODO
    deleteById
    deleteAll
    findByUsername
    findByEmail
    */

}
