package com.example.pera_sport_app.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;


@Entity
@Getter
@Setter
@Table(name = "player_role")
public class PlayerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_role_id")
    private Long playerRoleId;

    @Column(name = "role_name", nullable = false, length = 20)
    private String roleName;

    @OneToMany(mappedBy = "playerRoleId",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<PlayerRoleMappedEntity> playerRoleMappedCollection;

//    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
//    @ManyToOne
//    @JsonIgnore
//    private Team teamId;
}
