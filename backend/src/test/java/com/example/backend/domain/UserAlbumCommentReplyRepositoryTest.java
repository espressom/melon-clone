package com.example.backend.domain;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.domain.users_albums_comments.UserAlbumComment;
import com.example.backend.domain.users_albums_comments.UserAlbumCommentRepository;
import com.example.backend.domain.users_albums_comments_replies.UserAlbumCommentReply;
import com.example.backend.domain.users_albums_comments_replies.UserAlbumCommentReplyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAlbumCommentReplyRepositoryTest {

    @Autowired
    UserAlbumCommentReplyRepository userAlbumCommentReplyRepository;

    @Autowired
    UserAlbumCommentRepository userAlbumCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 앨범_대댓글_작성_테스트() {
        // given
        UserAlbumComment userAlbumComment = userAlbumCommentRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));

        // when
        userAlbumCommentReplyRepository.save(UserAlbumCommentReply.builder().reply("대댓글 작성").userAlbumComment(userAlbumComment).user(user).build());
    }

}
