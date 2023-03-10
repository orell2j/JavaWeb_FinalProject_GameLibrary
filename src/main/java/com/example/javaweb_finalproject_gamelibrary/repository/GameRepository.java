package com.example.javaweb_finalproject_gamelibrary.repository;


import com.example.javaweb_finalproject_gamelibrary.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("gameRepository")
public interface GameRepository extends CrudRepository<Game, Long>{

    List<Game> findAllByTitle(String title);


}
