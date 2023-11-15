package com.example.pera_sport_app.team.dto;

import com.example.pera_sport_app.Enum.Status;
import lombok.Data;

@Data
public class TeamAddRequestDto {
    private String teamName;
    private Integer teamCount;
    private String teamYear;
    private Status teamStatus;
}
