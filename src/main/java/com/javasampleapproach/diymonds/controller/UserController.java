package com.javasampleapproach.diymonds.controller;


import com.javasampleapproach.diymonds.model.User;
import com.javasampleapproach.diymonds.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        System.out.println("Delete User with ID = " + id + "...");
        userRepository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<String> deleteAllUsers() {
        System.out.println("Delete All Users...");
        userRepository.deleteAll();
        System.out.print("");
        System.out.print("");
        System.out.print("");
        return new ResponseEntity<>("All users have been deleted!", HttpStatus.OK);
    }




    /* TODO
    findByUsername
    findByEmail
    */

}
