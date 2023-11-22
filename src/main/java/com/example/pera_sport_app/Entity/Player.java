package com.example.pera_sport_app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name = "birth_date")
    private Date birthDay;

    @OneToMany(mappedBy = "playerId",cascade = CascadeType.ALL)
    private Collection<PlayerRoleMappedEntity> playerRoleMappedCollection;


    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL)
    private Collection<PlayerTeamMappedEntity> teamMappedEntityCollection;
}
