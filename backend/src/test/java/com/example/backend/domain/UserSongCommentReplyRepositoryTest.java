package com.example.backend.domain;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.domain.users_songs_comments.UserSongComment;
import com.example.backend.domain.users_songs_comments.UserSongCommentRepository;
import com.example.backend.domain.users_songs_comments_replies.UserSongCommentReply;
import com.example.backend.domain.users_songs_comments_replies.UserSongCommentReplyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSongCommentReplyRepositoryTest {

    @Autowired
    UserSongCommentReplyRepository userSongCommentReplyRepository;

    @Autowired
    UserSongCommentRepository userSongCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 곡_대댓글_작성_테스트() {
        // given
        UserSongComment userSongComment = userSongCommentRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));

        // when
        userSongCommentReplyRepository.save(UserSongCommentReply.builder().userSongComment(userSongComment).user(user).reply("대댓글!").build());
    }

    @Test
    public void 곡_대댓글_수정_테스트() {

    }



}
