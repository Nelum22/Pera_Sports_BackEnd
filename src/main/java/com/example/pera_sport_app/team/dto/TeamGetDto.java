package com.example.pera_sport_app.team.dto;

import com.example.pera_sport_app.Enum.Status;
import lombok.Data;

@Data
public class TeamGetDto {
    private Long teamId;
    private String teamName;
    private Integer teamCount;
    private String teamYear;
    private Status teamStatus;
    private String captain;
    private String vCaptain;
}
