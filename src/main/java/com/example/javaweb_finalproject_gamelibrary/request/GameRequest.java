package com.example.javaweb_finalproject_gamelibrary.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GameRequest {

    @NotBlank
    private long id;

    @NotBlank
    private String Title;

    @NotBlank
    private String Genre;

    @NotBlank
    private String Description;


}
