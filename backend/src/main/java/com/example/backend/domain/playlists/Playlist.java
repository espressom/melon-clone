package com.example.backend.domain.playlists;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.songs.Song;
import com.example.backend.domain.users_playlists.UserPlaylist;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "playlists")
public class Playlist {

    @ManyToOne(optional = false)
    @JoinColumn(name = "playlist_id")
    private UserPlaylist userPlaylist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "song_id")
    private Song song;

    private int song_like_status;

}
