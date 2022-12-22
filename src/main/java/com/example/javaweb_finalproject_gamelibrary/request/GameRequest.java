package com.example.javaweb_finalproject_gamelibrary.request;

import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GameRequest {

    @NonNull
    private long Id;

    @NonNull
    private String Title;

    @NonNull
    private String Genre;

    @NonNull
    private String Description;


}
