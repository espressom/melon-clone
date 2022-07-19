package com.example.backend.domain.users_albums_comments_replies;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users_albums_comments.UserAlbumComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users_albums_comments_replies")
public class UserAlbumCommentReply {

    @Id
    @Column(name = "albums_reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "albums_comment_id")
    private UserAlbumComment userAlbumComment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String reply;

    @Builder
    public UserAlbumCommentReply(Long id, UserAlbumComment userAlbumComment, User user, String reply) {
        this.id = id;
        this.userAlbumComment = userAlbumComment;
        this.user = user;
        this.reply = reply;
    }
}
