package com.omeraran.controller;

import com.omeraran.dto.auth.LoginRequest;
import com.omeraran.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String getAuth(@RequestBody LoginRequest loginRequest) {
        String jwtToken = authService.getJwtToken(loginRequest.getUsername(), loginRequest.getPassword());
        return jwtToken;
    }



}
