package com.omeraran.controller;

import com.omeraran.dto.UserDto;
import com.omeraran.dto.auth.LoginRequest;
import com.omeraran.dto.auth.UserResponse;
import com.omeraran.model.User;
import com.omeraran.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.save(user));
    }

    @PostMapping("/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody LoginRequest userRequest) {
        return ResponseEntity.ok(authenticationService.auth(userRequest));
    }
}
