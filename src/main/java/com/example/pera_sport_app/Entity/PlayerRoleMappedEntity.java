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
@Table(name = "player_role_mapped")
public class PlayerRoleMappedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_role_mapped_id")
    private Long playerRoleMappedId;


    @JoinColumn(name = "player_role_id", referencedColumnName = "player_role_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private PlayerRole playerRoleId;

    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Player playerId;

}
