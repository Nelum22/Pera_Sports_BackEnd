package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PlayerRoleRepository extends JpaRepository<PlayerRole, Long > {

    PlayerRole findByRoleName(String roleName);

    PlayerRole findByPlayerRoleId(Long roleId);
}
