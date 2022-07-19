package com.example.backend.web.dto;

import com.example.backend.domain.Gender;
import com.example.backend.domain.Position;
import com.example.backend.domain.producers.Producer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProducerSignupRequestDto extends SignupRequestDto {

    private Position position;

    @Builder
    public ProducerSignupRequestDto(String password, String email, String name, String nickname, Gender gender, String photoUrl, Position position) {
        super(password, email, name, nickname, gender, photoUrl);
        this.position = position;
    }

    @Override
    public Producer toEntity() {
        return Producer.builder()
                .password(password)
                .email(email)
                .name(name)
                .nickname(nickname)
                .gender(gender)
                .photoUrl(photoUrl)
                .position(position)
                .build();
    }
}
