package com.example.backend.web.dto;

import com.example.backend.domain.Gender;
import com.example.backend.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String password;
    private String email;
    private String name;
    private String nickname;
    private Gender gender;
    private String photoUrl;

    @Builder
    public UserSaveRequestDto(String password, String email, String name, String nickname, Gender gender, String photoUrl) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.gender = gender;
        this.photoUrl = photoUrl;
    }

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
