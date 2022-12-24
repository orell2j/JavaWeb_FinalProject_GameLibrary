package com.example.javaweb_finalproject_gamelibrary.repository;


import com.example.javaweb_finalproject_gamelibrary.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("reviewRepository")
public interface ReviewRepository extends CrudRepository<Review, Long>{

    List<Review> findAllByGameId(long id);

    @Transactional
    void deleteAllById(long id);

}
