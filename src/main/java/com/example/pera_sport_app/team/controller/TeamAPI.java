package com.example.pera_sport_app.team.controller;

import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.team.dto.TeamAddRequestDto;
import com.example.pera_sport_app.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/team")
public class TeamAPI {
    private final TeamService teamService;

    @PostMapping(value = "/add")
    public ResponseDto addTeam(@RequestBody TeamAddRequestDto teamAddRequestDto) {
        log.info("Request to add team {}", teamAddRequestDto);
        return teamService.addTeam(teamAddRequestDto);
    }

//    @PostMapping(value = "/get-teams")
//    public List<Team> getTeam(@RequestParam ("teamName") String teamName) {
//        log.info("Request to get team {}", teamName);
//        return teamService.getTeam(teamName);
//    }
}