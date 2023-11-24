package com.example.pera_sport_app.player.service;

import com.example.pera_sport_app.player.dto.PlayerAddDto;
import com.example.pera_sport_app.player.dto.PlayerEditDto;
import com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam;
import com.example.pera_sport_app.player.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PlayerService {

    ResponseDto addTransaction(PlayerAddDto playerAddDto);

    ResponseDto editPlayer(PlayerEditDto playerEditDto);

    List<PlayerGetDtoAccordingToTeam> getPlayersAccordingToTeam(String teamName);
}
