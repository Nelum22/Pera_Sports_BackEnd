package com.example.pera_sport_app.Auth.controller;

import com.example.pera_sport_app.Auth.dto.LoginRequest;
import com.example.pera_sport_app.Auth.dto.LoginResponseDto;
import com.example.pera_sport_app.Auth.service.AuthService;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.team.dto.TeamAddRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthAPI {

    private final AuthService authService;


    @PostMapping(value = "/login")
    public LoginResponseDto login(@RequestBody LoginRequest loginRequest) {
        log.info("Request log {}", loginRequest);
        return authService.login(loginRequest);
    }
}
