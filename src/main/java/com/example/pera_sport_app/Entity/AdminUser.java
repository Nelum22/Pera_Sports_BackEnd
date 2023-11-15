package com.example.pera_sport_app.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "admin_user")
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JoinColumn(name = "user_role_id", referencedColumnName = "user_role_id", nullable = false)
    @ManyToOne
    @JsonIgnore
    private UserRole userRoleId;
}
