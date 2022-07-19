package com.example.backend.web.dto;

import com.example.backend.domain.Gender;
import com.example.backend.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignupRequestDto extends SignupRequestDto{

    @Builder
    public UserSignupRequestDto(String password, String email, String name, String nickname, Gender gender, String photoUrl) {
        super(password, email, name, nickname, gender, photoUrl);
    }

    @Override
    public User toEntity() {
        return User.builder()
                .password(password)
                .email(email)
                .name(name)
                .nickname(nickname)
                .gender(gender)
                .photoUrl(photoUrl)
                .build();
    }
}
