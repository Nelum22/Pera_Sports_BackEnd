package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.AuthUser;
import com.example.pera_sport_app.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthUser, Long > {

    AuthUser findByUserName(String userName);
}
