package com.example.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@MappedSuperclass
@NoArgsConstructor
public class BaseUser extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String name;

    protected String nickname;

    @Enumerated(value = EnumType.STRING)
    protected Gender gender;

    protected String photoUrl;


    public BaseUser(String password, String email, String name, String nickname, Gender gender, String photoUrl) {
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.email = email;
        this.name = name;
        this.photoUrl = photoUrl;
    }
}
