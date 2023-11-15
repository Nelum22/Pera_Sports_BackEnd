package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long > {
}
