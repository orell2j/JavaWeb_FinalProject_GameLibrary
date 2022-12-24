package com.example.javaweb_finalproject_gamelibrary.entity;

import com.example.javaweb_finalproject_gamelibrary.request.UserRequest;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "Username")
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name = "Email")
    private String userEmail;

    @NotBlank
    @Size(max = 100)
    @Column(name = "Password")
    private String password;

    public User(UserRequest userRequest){

        username = userRequest.getUsername();

        userEmail = userRequest.getUserEmail();

        password = userRequest.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(){
        this.username = username;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setUserEmail(){
        this.userEmail = userEmail;
    }
}
