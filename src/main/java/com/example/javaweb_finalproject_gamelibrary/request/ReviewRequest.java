package com.example.javaweb_finalproject_gamelibrary.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewRequest {
    @NotBlank
    private String Comment;

    @NotBlank
    private int Rating;
}
