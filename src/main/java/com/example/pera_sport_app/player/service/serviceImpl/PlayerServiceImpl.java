package com.example.pera_sport_app.player.service.serviceImpl;

import com.example.pera_sport_app.Auth.dto.LoginResponseDto;
import com.example.pera_sport_app.Entity.*;
import com.example.pera_sport_app.Enum.Status;
import com.example.pera_sport_app.Mail.EmailService;
import com.example.pera_sport_app.Mail.Helper.MailService;
import com.example.pera_sport_app.Mail.dto.MailData;
import com.example.pera_sport_app.Mail.dto.MailRequest;
import com.example.pera_sport_app.player.dto.PlayerAddDto;
import com.example.pera_sport_app.player.dto.PlayerEditDto;
import com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam;
import com.example.pera_sport_app.player.dto.ResponseDto;
import com.example.pera_sport_app.player.service.PlayerService;
import com.example.pera_sport_app.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final PlayerRoleRepository playerRoleRepository;

    private final TeamRepository teamRepository;

    private final PlayerRoleMappedRepository playerRoleMappedRepository;

    private final PlayerTeamMappedRepository playerTeamMappedRepository;

    private final MasterDateRepository masterDateRepository;

    private final EmailService emailService;

    @Override
    public ResponseDto add(PlayerAddDto playerAddDto) {
        try {
            Team team = teamRepository.findByTeamName(playerAddDto.getTeam());

            if (playerRepository.findTeamCountByName(playerAddDto.getTeam()) < team.getTeamCount()) {
                if (playerAddDto.getPlayerRole().equals("Captain")) {
                    if (playerRepository.findTeamCountByRoleAndName(playerAddDto.getTeam(), 1L) < 1) {
                        Player player = new Player();
                        player.setFirstName(playerAddDto.getFirstName());
                        player.setLastName(playerAddDto.getLastName());
                        player.setFaculty(playerAddDto.getFaculty());
                        player.setBirthDay(playerAddDto.getBirthDay());
                        player.setStatus(Status.ACTIVE);
                        player.setRegNo(playerAddDto.getRegNo());


                        PlayerTeamMappedEntity playerTeamMappedEntity = new PlayerTeamMappedEntity();

                        playerTeamMappedEntity.setPlayer(player);
                        playerTeamMappedEntity.setTId(team);


                        PlayerRoleMappedEntity playerRoleMappedEntity = new PlayerRoleMappedEntity();
                        PlayerRole playerRole = playerRoleRepository.findByRoleName(playerAddDto.getPlayerRole());
                        playerRoleMappedEntity.setPlayerId(player);
                        playerRoleMappedEntity.setPlayerRoleId(playerRole);


                        playerRepository.save(player);
                        playerTeamMappedRepository.save(playerTeamMappedEntity);
                        playerRoleMappedRepository.save(playerRoleMappedEntity);

                        Team teams = teamRepository.findByTeamName(playerAddDto.getTeam());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        List<MasterData> masterData = masterDateRepository.findAllDataByType("ADMIN");
                        for(MasterData masterData1 : masterData) {

                            // Send Email
                            MailRequest mailRequest = new MailRequest();
                            mailRequest.setTo(masterData1.getEmail());
                            mailRequest.setSubject("New Player Added Successfully To "+playerAddDto.getTeam()+" Team");
                            MailData mailData = new MailData();
                            String[] details = {"Team Details :","Player Details :"};
                            String[] detailsDescription1 = {"Team Name - " + teams.getTeamName(), "Team Count - " + teams.getTeamCount(), "Year - " + teams.getTeamYear(),
                                    "Status - " + teams.getTeamStatus(), "Created Date - " + formatter.format(teams.getCreatedDate())};
                            String[] detailsDescription2 = {"Player Name - "+ playerAddDto.getFirstName()+playerAddDto.getLastName(),"Faculty - "+playerAddDto.getFaculty(),"Registration Number - "+playerAddDto.getRegNo()
                                    ,"Birth Day - "+playerAddDto.getBirthDay(),"Player Role - "+playerAddDto.getPlayerRole()};
                            String[] detailsDescription3 = {};
                            String[] detailsDescription4 = {};
                            mailData.setHeader("New Team Added To The System");
                            mailData.setHeaderDescription("");
                            mailData.setDescription("");
                            mailData.setDetails(details);
                            mailData.setDetailsDescription1(detailsDescription1);
                            mailData.setDetailsDescription2(detailsDescription2);
                            mailData.setDetailsDescription3(detailsDescription3);
                            mailData.setDetailsDescription4(detailsDescription4);

                            emailService.sendEmailWithHtmlContent(mailRequest, mailData);
                        }
                        return new ResponseDto("01", "Record Successfully Added");
                    } else {
                        return new ResponseDto("03", "Captain Already Exists");
                    }
                } else if (playerAddDto.getPlayerRole().equals("Vice Captain")) {
                    if (playerRepository.findTeamCountByRoleAndName(playerAddDto.getTeam(), 2L) < 1) {
                        Player player = new Player();
                        player.setFirstName(playerAddDto.getFirstName());
                        player.setLastName(playerAddDto.getLastName());
                        player.setFaculty(playerAddDto.getFaculty());
                        player.setBirthDay(playerAddDto.getBirthDay());
                        player.setStatus(Status.ACTIVE);
                        player.setRegNo(playerAddDto.getRegNo());


                        PlayerTeamMappedEntity playerTeamMappedEntity = new PlayerTeamMappedEntity();

                        playerTeamMappedEntity.setPlayer(player);
                        playerTeamMappedEntity.setTId(team);


                        PlayerRoleMappedEntity playerRoleMappedEntity = new PlayerRoleMappedEntity();
                        PlayerRole playerRole = playerRoleRepository.findByRoleName(playerAddDto.getPlayerRole());
                        playerRoleMappedEntity.setPlayerId(player);
                        playerRoleMappedEntity.setPlayerRoleId(playerRole);


                        playerRepository.save(player);
                        playerTeamMappedRepository.save(playerTeamMappedEntity);
                        playerRoleMappedRepository.save(playerRoleMappedEntity);
                        return new ResponseDto("01", "Record Successfully Added");
                    } else {
                        return new ResponseDto("04", "Vice Captain Already Exists");
                    }
                } else {
                    Player player = new Player();
                    player.setFirstName(playerAddDto.getFirstName());
                    player.setLastName(playerAddDto.getLastName());
                    player.setFaculty(playerAddDto.getFaculty());
                    player.setBirthDay(playerAddDto.getBirthDay());
                    player.setStatus(Status.ACTIVE);
                    player.setRegNo(playerAddDto.getRegNo());


                    PlayerTeamMappedEntity playerTeamMappedEntity = new PlayerTeamMappedEntity();

                    playerTeamMappedEntity.setPlayer(player);
                    playerTeamMappedEntity.setTId(team);


                    PlayerRoleMappedEntity playerRoleMappedEntity = new PlayerRoleMappedEntity();
                    PlayerRole playerRole = playerRoleRepository.findByRoleName(playerAddDto.getPlayerRole());
                    playerRoleMappedEntity.setPlayerId(player);
                    playerRoleMappedEntity.setPlayerRoleId(playerRole);


                    playerRepository.save(player);
                    playerTeamMappedRepository.save(playerTeamMappedEntity);
                    playerRoleMappedRepository.save(playerRoleMappedEntity);
                    return new ResponseDto("01", "Record Successfully Added");
                }
            } else {
                return new ResponseDto("02", "Team Count Exceeded");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto("00", "System Error");
        }
    }


    @Override
    public ResponseDto editPlayer(PlayerEditDto playerEditDto) {
        try {
            Player player = playerRepository.findByPlayerId(playerEditDto.getPlayerId());
            player.setFirstName(playerEditDto.getFirstName());
            player.setLastName(playerEditDto.getLastName());
            player.setFaculty(playerEditDto.getFaculty());
            player.setRegNo(playerEditDto.getRegNo());
            player.setBirthDay(playerEditDto.getBirthDay());
            player.setStatus(playerEditDto.getStatus());
            playerRepository.save(player);

            PlayerRoleMappedEntity playerRoleMappedEntity = playerRoleMappedRepository.findByPlayerIdPlayerId(playerEditDto.getPlayerId());
            PlayerRole playerRole = playerRoleRepository.findByRoleName(playerEditDto.getRole());
            playerRoleMappedEntity.setPlayerRoleId(playerRole);
            playerRoleMappedRepository.save(playerRoleMappedEntity);

            return new ResponseDto("01", "Record Successfully Edited");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseDto("00", "System Error");
        }
    }

    @Override
    public List<PlayerGetDtoAccordingToTeam> getPlayersAccordingToTeam(String teamName) {
        try {
            List<PlayerGetDtoAccordingToTeam> playerGetDtoAccordingToTeam = playerTeamMappedRepository.findPlayersAccordingToTeam(teamName);
            for (PlayerGetDtoAccordingToTeam player : playerGetDtoAccordingToTeam) {
                PlayerRoleMappedEntity playerRoleMappedEntity = playerRoleMappedRepository.findByPlayerIdPlayerId(player.getPlayerId());
                PlayerRole playerRole = playerRoleRepository.findByPlayerRoleId(playerRoleMappedEntity.getPlayerRoleId().getPlayerRoleId());
                player.setRoleName(playerRole.getRoleName());
            }
            return playerGetDtoAccordingToTeam;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
