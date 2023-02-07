package com.omeraran.service;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthService {

    public String getJwtToken(String username, String password) {
        String url = "http://localhost:8080/api/v1/auth/authenticate";
        RestTemplate restTemplate = new RestTemplate();
        // Create a map of request parameters
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        // Make the post request to the server
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // Extract the JWT token from the response
        String jwtToken = response.getBody();

        return jwtToken;
    }
}
