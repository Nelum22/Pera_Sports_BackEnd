package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.Player;
import com.example.pera_sport_app.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {



    @Query("SELECT s FROM Team s WHERE s.teamName LIKE %:name% AND s.teamYear IN :teamYear")
    List<Team> findTeamsByName(String name, String teamYear);

    @Query("SELECT s FROM Team s WHERE s.teamYear IN :teamYear ")
    List<Team> findTeams(String teamYear);


    Team findByTeamId(Long teamId);

    Team findByTeamName(String teamName);

    Boolean existsByTeamName(String teamName);

}
