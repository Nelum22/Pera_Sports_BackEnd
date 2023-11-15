package com.example.pera_sport_app.Entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long coachId;

    @Column(name = "coach_name", nullable = false, length = 20)
    private String coachName;

    @JoinColumn(name = "team_id", referencedColumnName = "team_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private Team team;

}
