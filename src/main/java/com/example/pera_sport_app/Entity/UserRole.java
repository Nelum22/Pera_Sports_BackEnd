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
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Long userRoleId;

    @Column(name = "role_name", nullable = false, length = 20)
    private String userRoleName;

    @OneToMany(mappedBy = "userRoleId",cascade = CascadeType.ALL)
    private Collection<AdminUser> adminUsers;
}
