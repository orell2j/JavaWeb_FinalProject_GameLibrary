package com.example.javaweb_finalproject_gamelibrary.repository;


import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javaweb_finalproject_gamelibrary.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

}