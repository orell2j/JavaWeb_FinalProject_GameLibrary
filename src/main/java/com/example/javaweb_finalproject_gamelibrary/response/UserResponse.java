package com.example.javaweb_finalproject_gamelibrary.response;

import com.example.javaweb_finalproject_gamelibrary.entity.User;
import com.example.javaweb_finalproject_gamelibrary.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;

    public UserResponse(User user){
        id = user.getId();
        username = user.getUsername();
        email = user.getUserEmail();
    }
}
