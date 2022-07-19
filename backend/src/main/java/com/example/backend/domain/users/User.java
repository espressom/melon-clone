package com.example.backend.domain.users;

import com.example.backend.domain.users_playlists.UserPlaylist;
import com.example.backend.domain.BaseUser;
import com.example.backend.domain.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "users")
@AttributeOverride(name="id", column = @Column(name = "user_id"))
public class User extends BaseUser {

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserPlaylist> userPlaylists = new ArrayList<>();

    @Builder
    public User(String password, String email, String name, String nickname, Gender gender, String photoUrl) {
        super(password, email, name, nickname, gender, photoUrl);
    }
}
