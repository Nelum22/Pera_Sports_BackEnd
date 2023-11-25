package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.PlayerTeamMappedEntity;
import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.Enum.Status;
import com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerTeamMappedRepository extends JpaRepository<PlayerTeamMappedEntity, Long> {

    @Query("SELECT new com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam(p.player.playerId,p.player.firstName,p.player.lastName,p.player.faculty,p.player.regNo,p.player.birthDay,'-',p.player.status) " +
            "FROM PlayerTeamMappedEntity p WHERE p.tId.teamName IN :teamName AND p.player.status IN :status")
    List<PlayerGetDtoAccordingToTeam> findPlayersAccordingToTeam(String teamName, Status status);


}
