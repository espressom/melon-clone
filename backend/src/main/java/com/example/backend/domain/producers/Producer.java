package com.example.backend.domain.producers;

import com.example.backend.domain.BaseUser;
import com.example.backend.domain.Gender;
import com.example.backend.domain.Position;
import com.example.backend.domain.albums.Album;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "producers")
@AttributeOverride(name="id", column = @Column(name = "producer_id"))
public class Producer extends BaseUser {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Position position;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    private List<Album> albums = new ArrayList<>();

    @Builder
    public Producer(String password, String email, String name, String nickname, Gender gender, String photoUrl, Position position) {
        super(password, email, name, nickname, gender, photoUrl);
        this.position = position;
    }
}
