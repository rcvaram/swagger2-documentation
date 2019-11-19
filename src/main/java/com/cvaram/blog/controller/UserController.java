package com.cvaram.blog.controller;

import com.cvaram.blog.beans.User;
import com.cvaram.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @PostMapping(consumes = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
