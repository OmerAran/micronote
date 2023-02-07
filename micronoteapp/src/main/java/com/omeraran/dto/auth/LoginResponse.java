package com.omeraran.dto.auth;


public class LoginResponse {

    private String jwtToken;

    public LoginResponse(String token) {
        this.jwtToken = token;
    }

    public String getToken() {
        return jwtToken;
    }

    public void setToken(String token) {
        this.jwtToken = token;
    }
}
