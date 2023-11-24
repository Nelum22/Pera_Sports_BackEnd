package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.Team;
import com.example.pera_sport_app.player.dto.PlayerGetDtoAccordingToTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long > {

    Player findByPlayerId(Long playerId);

    @Query("SELECT COUNT(s.player.playerId) FROM PlayerTeamMappedEntity s WHERE s.tId.teamName IN :name ")
    int findTeamCountByName(String name);

    @Query("SELECT COUNT(p.player.playerId) FROM PlayerTeamMappedEntity p INNER JOIN PlayerRoleMappedEntity s ON p.player.playerId = s.playerId.playerId WHERE p.tId.teamName IN :name AND s.playerRoleId.playerRoleId IN :playerRoleId ")
    int findTeamCountByRoleAndName(String name, Long playerRoleId);



}
