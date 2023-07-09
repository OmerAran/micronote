package com.omeraran.service;

import com.omeraran.dto.auth.LoginRequest;
import com.omeraran.dto.auth.UserResponse;
import com.omeraran.model.User;
import com.omeraran.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public UserResponse save(User loginUser) {
        User user = User.builder()
                .username(loginUser.getUsername())
                .password(passwordEncoder.encode(loginUser.getPassword()))
                .role(loginUser.getRole()).build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();

    }

    public UserResponse auth(LoginRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();
    }
}
