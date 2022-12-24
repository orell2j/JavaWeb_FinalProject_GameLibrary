package com.example.javaweb_finalproject_gamelibrary.entity;


import jakarta.persistence.*;

@Table(name = "Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UserName", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;


    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
    }

    public long getId() {

        return id;

    }

    public void setId(long id) {

        this.id = id;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getUserEmail() {

        return email;

    }

    public void setUserEmail(String email) {

        this.email = email;

    }

}
