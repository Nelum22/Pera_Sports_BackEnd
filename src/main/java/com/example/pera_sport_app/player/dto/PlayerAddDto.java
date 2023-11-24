package com.example.pera_sport_app.player.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PlayerAddDto {
    private String firstName;
    private String lastName;
    private String faculty;
    private String regNo;
    private LocalDate birthDay;
    private String playerRole;
    private String team;
}
