package com.example.pera_sport_app.player.dto;

import com.example.pera_sport_app.Enum.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PlayerEditDto {
    private Long playerId;
    private String firstName;
    private String lastName;
    private String faculty;
    private String regNo;
    private LocalDate birthDay;
    private String role;
    private Status status;
}
