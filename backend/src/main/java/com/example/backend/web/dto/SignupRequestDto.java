package com.example.backend.web.dto;

import com.example.backend.domain.BaseUser;
import com.example.backend.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class SignupRequestDto {

    protected String password;
    protected String email;
    protected String name;
    protected String nickname;
    protected Gender gender;
    protected String photoUrl;

    abstract public BaseUser toEntity();

}
