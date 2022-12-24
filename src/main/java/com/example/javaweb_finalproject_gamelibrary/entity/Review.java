package com.example.javaweb_finalproject_gamelibrary.entity;

import com.example.javaweb_finalproject_gamelibrary.request.ReviewRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.MapKeyMutability;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.net.ContentHandler;

@Entity
@Table(name = "Reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Comments")
    private String comment;

    @Column(name = "Rating")
    private int rating;

    private String username;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "GameId")
    private Game game;

    public Review (ReviewRequest reviewRequest){
        comment = reviewRequest.getComment();
        rating = reviewRequest.getRating();
        username = reviewRequest.getUsername();
    }

}
