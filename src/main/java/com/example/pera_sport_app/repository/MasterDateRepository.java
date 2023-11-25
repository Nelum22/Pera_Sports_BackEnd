package com.example.pera_sport_app.repository;

import com.example.pera_sport_app.Entity.MasterData;
import com.example.pera_sport_app.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterDateRepository extends JpaRepository<MasterData, Long > {

    @Query("SELECT s FROM MasterData s  WHERE s.type IN :type ")
    List<MasterData> findAllDataByType(String type);
}
