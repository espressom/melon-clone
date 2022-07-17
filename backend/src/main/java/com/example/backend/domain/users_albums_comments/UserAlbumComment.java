package com.example.backend.domain.users_albums_comments;

import com.example.backend.domain.BaseTime;
import com.example.backend.domain.albums.Album;
import com.example.backend.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users_albums_comments")
public class UserAlbumComment extends BaseTime {

    @Id
    @Column(name = "albums_comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String comment;

    @Builder
    public UserAlbumComment(Long id, Album album, User user, String comment) {
        this.id = id;
        this.album = album;
        this.user = user;
        this.comment = comment;
    }
}
