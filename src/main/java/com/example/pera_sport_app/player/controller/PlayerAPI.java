package com.example.pera_sport_app.player.controller;


import com.example.pera_sport_app.player.dto.PlayerAddDto;
import com.example.pera_sport_app.player.dto.PlayerEditDto;
import com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/player")
public class PlayerAPI {

    private final PlayerService playerService;

    @PostMapping(value = "/add")
    public ResponseDto addTransaction(@RequestBody PlayerAddDto playerAddDto) {
        log.info("Request to add player details {}", playerAddDto);
        return playerService.addTransaction(playerAddDto);
    }


    @PostMapping(value = "/edit")
    public ResponseDto editPlayer(@RequestBody PlayerEditDto playerEditDto) {
        log.info("Request to edit player details {}", playerEditDto);
        return playerService.editPlayer(playerEditDto);
    }

    @PostMapping(value = "/get-players-according-to-team")
    public List<PlayerGetDtoAccordingToTeam> getPlayersAccordingToTeam(@RequestParam ("teamName") String teamName){
        log.info("Request to get player details {}", teamName);
        return playerService.getPlayersAccordingToTeam(teamName);
    }
}
