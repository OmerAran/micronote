package com.omeraran.controller;

import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/omer")
    public String omer(){
        return "omer";
    }

    @GetMapping("/{id}")
    public User getOneUserInfo(@PathVariable Long id){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException());
        return user;
    }

    @PostMapping("/add")
    public User saveOneUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
