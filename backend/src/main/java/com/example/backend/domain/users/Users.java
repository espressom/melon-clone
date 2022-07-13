package com.example.backend.domain.users;

import com.example.backend.domain.BaseTimeEntity;
import com.example.backend.domain.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;

    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    
    private String photoUrl;

}
