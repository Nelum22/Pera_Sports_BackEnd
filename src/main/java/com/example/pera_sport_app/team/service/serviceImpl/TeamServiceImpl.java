package com.example.pera_sport_app.team.service.serviceImpl;

import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.Enum.Status;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.repository.PlayerRepository;
import com.example.pera_sport_app.repository.TeamRepository;
import com.example.pera_sport_app.team.dto.TeamAddRequestDto;
import com.example.pera_sport_app.team.dto.TeamGetDto;
import com.example.pera_sport_app.team.dto.TeamUpdateRequestDto;
import com.example.pera_sport_app.team.service.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    private final PlayerRepository playerRepository;

    @Override
    public ResponseDto addTeam(TeamAddRequestDto teamAddRequestDto){
        try{
            Team team = mapper.map(teamAddRequestDto,Team.class);
            team.setCreatedDate(LocalDateTime.now());
            team.setTeamStatus(Status.ACTIVE);
            teamRepository.save(team);
            return new ResponseDto("01","Added successfully");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("00","System Error");
        }
    }

    @Override
    public List<TeamGetDto> getTeam(String teamName){
        try{
            List<Team> teams = new ArrayList<>();
            if(!(teamName.isEmpty())){
                teams = teamRepository.findTeamsByName(teamName);
            }else {
                teams = teamRepository.findTeams();
            }
            List<TeamGetDto> teamGetDtos = new ArrayList<>();
            for(Team team : teams){
                TeamGetDto teamGetDto = mapper.map(team,TeamGetDto.class);
                Player captain = playerRepository.findCaptainAndVCaptainByRoleAndName(team.getTeamName(),1L);
                Player vCaptain = playerRepository.findCaptainAndVCaptainByRoleAndName(team.getTeamName(),2L);
                teamGetDto.setCaptain(captain == null? " " :captain.getFirstName()+" "+captain.getLastName());
                teamGetDto.setVCaptain(captain == null? " " :vCaptain.getFirstName()+" "+vCaptain.getLastName());
                teamGetDtos.add(teamGetDto);
            }

            return teamGetDtos;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseDto updateTeam(TeamUpdateRequestDto teamUpdateRequestDto){
        try{
            Team team = teamRepository.findByTeamId(teamUpdateRequestDto.getTeamId());
            team.setUpdatedDate(LocalDateTime.now());
            team.setTeamName(teamUpdateRequestDto.getTeamName());
            team.setTeamCount(teamUpdateRequestDto.getTeamCount());
            team.setTeamYear(teamUpdateRequestDto.getTeamYear());
            team.setTeamStatus(teamUpdateRequestDto.getTeamStatus());
            teamRepository.save(team);
            return new ResponseDto("01","Data updated");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("00","System Error");
        }
    }

    @Override
    public ResponseDto deleteTeam(Long teamId){
        try{
            Team team = teamRepository.findByTeamId(teamId);
            teamRepository.deleteById(teamId);
            return new ResponseDto("01","Team Deleted");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("00","System Error");
        }
    }
}
