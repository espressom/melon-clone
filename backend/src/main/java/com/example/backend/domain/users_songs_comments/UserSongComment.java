package com.example.backend.domain.users_songs_comments;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.songs.Song;
import com.example.backend.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users_songs_comments")
public class UserSongComment extends BaseTime {

    @Id
    @Column(name = "songs_comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;

    @Builder
    public UserSongComment(Long id, Song song, User user, String comment) {
        this.id = id;
        this.song = song;
        this.user = user;
        this.comment = comment;
    }
}
