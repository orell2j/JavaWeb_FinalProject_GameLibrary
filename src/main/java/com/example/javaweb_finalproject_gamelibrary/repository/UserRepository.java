package com.example.javaweb_finalproject_gamelibrary.repository;

import com.example.javaweb_finalproject_gamelibrary.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{

}
