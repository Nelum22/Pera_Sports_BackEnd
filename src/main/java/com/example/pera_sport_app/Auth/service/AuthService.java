package com.example.pera_sport_app.Auth.service;

import com.example.pera_sport_app.Auth.dto.LoginRequest;
import com.example.pera_sport_app.Auth.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequest loginRequest);
}
