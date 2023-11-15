package com.example.pera_sport_app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "player_team_mapped")
public class PlayerTeamMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_team_mapped_id")
    private Long playerTeamMappedId;


    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Team tId;

    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Player player;
}
