package com.example.backend.domain.playlists;

import com.example.backend.domain.users_playlists.UserPlaylist;
import com.example.backend.domain.songs.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "playlists")
public class Playlist {

    @Id
    @Column(name = "playlist_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; // 식별관계와 무관하지만, JPA에서 엔티티에 @Id를 필요로 하기 때문에 만든 시퀀스 컬럼.

    @ManyToOne(optional = false)
    @JoinColumn(name = "playlist_id")
    private UserPlaylist userPlaylist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "song_id")
    private Song song;

    private int song_like_status;

    @Builder
    public Playlist(UserPlaylist userPlaylist, Song song, int song_like_status) {
        this.userPlaylist = userPlaylist;
        this.song = song;
        this.song_like_status = song_like_status;
    }
}
