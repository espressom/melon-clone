package com.example.backend.domain.users;

import com.example.backend.domain.BaseUser;
import com.example.backend.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users")
@AttributeOverride(name="id", column = @Column(name = "user_id"))
public class User extends BaseUser {

    @Builder
    public User(String password, String email, String name, String nickname, Gender gender, String photoUrl) {
        super(password, email, name, nickname, gender, photoUrl);
    }
}
