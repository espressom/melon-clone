package com.example.backend.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginRequestDto {

    private String email;
    private String password;

//    @Builder
//    public UserLoginRequestDto(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

}
