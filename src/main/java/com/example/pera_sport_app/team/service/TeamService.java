package com.example.pera_sport_app.team.service;

import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.team.dto.TeamAddRequestDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeamService {

    ResponseDto addTeam(TeamAddRequestDto teamAddRequestDto);

    List<Team> getTeam(String teamName);
}
