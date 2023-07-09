package com.omeraran.controller;

import com.omeraran.config.security.JWTResponse;
import com.omeraran.dto.auth.LoginRequest;
import com.omeraran.exception.UserNotFoundException;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public JWTResponse login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Username not found : " + loginRequest.getUsername()));

    }
}
