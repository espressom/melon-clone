package com.example.backend.domain.producers;

import com.example.backend.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Producers extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producerId;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String position;
    private String photoUrl;

    @Builder
    public Producers(String email, String password, String name, String position, String photoUrl) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.position = position;
        this.photoUrl = photoUrl;
    }

}
