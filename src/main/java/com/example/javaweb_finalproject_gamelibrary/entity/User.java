package com.example.javaweb_finalproject_gamelibrary.entity;


import com.example.javaweb_finalproject_gamelibrary.request.UserRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UserName", nullable = false)
    private String username;

    @Column(name = "Email", nullable = false)
    private String email;


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
    }


    public User (UserRequest userRequest){
        username = userRequest.getUsername();
        email = userRequest.getUserEmail();

    }

    public User() {

    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = email;
    }
}
