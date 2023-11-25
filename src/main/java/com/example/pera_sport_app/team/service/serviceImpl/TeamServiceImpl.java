package com.example.pera_sport_app.team.service.serviceImpl;

import com.example.pera_sport_app.Entity.MasterData;
import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.Enum.Status;
import com.example.pera_sport_app.Mail.EmailService;
import com.example.pera_sport_app.Mail.dto.MailData;
import com.example.pera_sport_app.Mail.dto.MailRequest;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.repository.MasterDateRepository;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.pera_sport_app.Constants.ADMIN_EMAIL_ADDRESS;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    private final EmailService emailService;

    private final MasterDateRepository masterDateRepository;

    private final PlayerRepository playerRepository;

    @Override
    public ResponseDto addTeam(TeamAddRequestDto teamAddRequestDto){
        try{
            if(!(teamRepository.existsByTeamNameAndTeamYear(teamAddRequestDto.getTeamName(),teamAddRequestDto.getTeamYear()))) {
                Team team = mapper.map(teamAddRequestDto, Team.class);
                team.setCreatedDate(LocalDateTime.now());
                team.setTeamStatus(Status.ACTIVE);
                Team savedTeam = teamRepository.save(team);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                List<MasterData> masterData = masterDateRepository.findAllDataByType("ADMIN");

                for(MasterData masterData1 : masterData) {

                    // Send Email
                    MailRequest mailRequest = new MailRequest();
                    mailRequest.setTo(masterData1.getEmail());
                    mailRequest.setSubject("New Team Added Successfully To Pera Sport Information Website");
                    MailData mailData = new MailData();
                    String[] details = {"Team Details :"};
                    String[] detailsDescription1 = {"Team Name - " + savedTeam.getTeamName(), "Team Count - " + savedTeam.getTeamCount(), "Year - " + savedTeam.getTeamYear(),
                            "Status - " + savedTeam.getTeamStatus(), "Created Date - " + formatter.format(savedTeam.getCreatedDate())};
                    String[] detailsDescription2 = {};
                    String[] detailsDescription3 = {};
                    String[] detailsDescription4 = {};
                    mailData.setHeader("Pera Sport Information Website");
                    mailData.setHeaderDescription("New Player Added Successfully To "+savedTeam.getTeamName()+" Team");
                    mailData.setDescription("");
                    mailData.setDetails(details);
                    mailData.setDetailsDescription1(detailsDescription1);
                    mailData.setDetailsDescription2(detailsDescription2);
                    mailData.setDetailsDescription3(detailsDescription3);
                    mailData.setDetailsDescription4(detailsDescription4);

                    emailService.sendEmailWithHtmlContent(mailRequest, mailData);
                }
                return new ResponseDto("01", "Added successfully");
            }else{
                return new ResponseDto("02", "Team Already Exists");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("00","System Error");
        }
    }

    @Override
    public List<TeamGetDto> getTeam(String teamName,String teamYear){
        try{
            List<Team> teams = new ArrayList<>();
            if(!(teamName.isEmpty())){
                teams = teamRepository.findTeamsByName(teamName,teamYear);
            }else {
                teams = teamRepository.findTeams(teamYear);
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
            Team savedTeam = teamRepository.findByTeamId(teamId);
            teamRepository.deleteById(teamId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            List<MasterData> masterData = masterDateRepository.findAllDataByType("ADMIN");

            for(MasterData masterData1 : masterData) {

                // Send Email
                MailRequest mailRequest = new MailRequest();
                mailRequest.setTo(masterData1.getEmail());
                mailRequest.setSubject(savedTeam.getTeamName()+" Team Deleted From Pera Sport Information Website");
                MailData mailData = new MailData();
                String[] details = {"Team Details :"};
                String[] detailsDescription1 = {"Team Name - " + savedTeam.getTeamName(), "Team Count - " + savedTeam.getTeamCount(), "Year - " + savedTeam.getTeamYear(),
                        "Status - " + savedTeam.getTeamStatus(), "Created Date - " + formatter.format(savedTeam.getCreatedDate())};
                String[] detailsDescription2 = {};
                String[] detailsDescription3 = {};
                String[] detailsDescription4 = {};
                mailData.setHeader("Pera Sport Information Website");
                mailData.setHeaderDescription(savedTeam.getTeamName()+" Team Deleted From Pera Sport Information Website");
                mailData.setDescription("");
                mailData.setDetails(details);
                mailData.setDetailsDescription1(detailsDescription1);
                mailData.setDetailsDescription2(detailsDescription2);
                mailData.setDetailsDescription3(detailsDescription3);
                mailData.setDetailsDescription4(detailsDescription4);

                emailService.sendEmailWithHtmlContent(mailRequest, mailData);
            }

            return new ResponseDto("01","Team Deleted");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto("00","System Error");
        }
    }
}
