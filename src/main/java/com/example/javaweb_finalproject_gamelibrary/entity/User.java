package com.example.javaweb_finalproject_gamelibrary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserId;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String UserEmail;


}
