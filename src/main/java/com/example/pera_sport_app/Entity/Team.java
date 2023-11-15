package com.example.pera_sport_app.Entity;

import com.example.pera_sport_app.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_count")
    private Integer teamCount;

    @Column(name = "team_year")
    private String teamYear;

    @Column(name = "team_status")
    @Enumerated(EnumType.STRING)
    private Status teamStatus;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "teamId",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<PlayerRole> playerRoleCollection;

    @OneToMany(mappedBy = "tId",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<PlayerTeamMappedEntity> playerTeamCollection;


    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Coach> coachesCollection;

}
