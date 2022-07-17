package com.example.backend.domain.users_songs_comments_replies;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users_songs_comments.UserSongComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "users_songs_comments_replies")
public class UserSongCommentReply {

    @Id
    @Column(name = "songs_reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "songs_comment_id")
    private UserSongComment userSongComment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String reply;

    @Builder
    public UserSongCommentReply(Long id, UserSongComment userSongComment, User user, String reply) {
        this.id = id;
        this.userSongComment = userSongComment;
        this.user = user;
        this.reply = reply;
    }
}
