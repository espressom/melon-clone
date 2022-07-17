package com.example.backend.domain.users_albums;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.users.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name="users_albums")
public class  UserAlbum {

    @Id
    @Column(name = "user_album_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq; // 식별관계와 무관하지만, JPA에서 엔티티에 @Id를 필요로 하기 때문에 만든 시퀀스 컬럼.

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    private int album_like_status;

    @Builder
    public UserAlbum(Long seq, User user, Album album, int album_like_status) {
        this.seq = seq;
        this.user = user;
        this.album = album;
        this.album_like_status = album_like_status;
    }
}
