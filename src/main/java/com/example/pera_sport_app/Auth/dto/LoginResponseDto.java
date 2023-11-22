package com.example.pera_sport_app.Auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String responseCode;
    private String responseMessage;
    private String teamName;
}
