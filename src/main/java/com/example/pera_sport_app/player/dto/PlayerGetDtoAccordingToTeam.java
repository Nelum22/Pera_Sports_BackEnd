package com.example.pera_sport_app.player.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PlayerGetDtoAccordingToTeam{
    private Long playerId;
    private String firstName;
    private String lastName;
    private String faculty;
    private String regNo;
    private LocalDate birthDay;
    private String roleName;
}
