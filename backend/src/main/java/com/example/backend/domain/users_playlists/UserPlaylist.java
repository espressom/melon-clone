package com.example.backend.domain.users_playlists;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users_playlists")
public class UserPlaylist extends BaseTime {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

}
