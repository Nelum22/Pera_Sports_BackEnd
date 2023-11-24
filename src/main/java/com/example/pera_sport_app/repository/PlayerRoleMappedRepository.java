package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.PlayerRoleMappedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRoleMappedRepository extends JpaRepository<PlayerRoleMappedEntity, Long > {

    PlayerRoleMappedEntity findByPlayerIdPlayerIdAndPlayerRoleIdPlayerRoleId(Long playerId, Long playerRoleId);

    PlayerRoleMappedEntity findByPlayerIdPlayerId(Long playerId);

//    @Query("SELECT SUM(s.playerRoleMappedId) FROM PlayerRoleMappedEntity s INNER JOIN PlayerTeamMappedEntity p ON p.player.playerId = s.playerId.playerId WHERE p.tId.teamName IN :name AND s.playerRoleId.playerRoleId IN :playerRoleId GROUP BY s.playerId.playerId")
//    int findTeamCountByRoleAndName(String name, Long playerRoleId);



}
