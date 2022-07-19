package com.example.backend.domain;

import com.example.backend.domain.songs.Song;
import com.example.backend.domain.songs.SongRepository;
import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.domain.users_songs_comments.UserSongComment;
import com.example.backend.domain.users_songs_comments.UserSongCommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSongCommentRepositoryTest {

    @Autowired
    UserSongCommentRepository userSongCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SongRepository songRepository;

    @Test
    public void 곡_댓글_작성_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Song song = songRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다"));

        // when
        userSongCommentRepository.save(UserSongComment.builder().comment("새댓글").song(song).user(user).build());
    }

    @Test
    public void 곡_댓글_수정_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Song song = songRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다"));
        UserSongComment userSongComment = userSongCommentRepository.findBySongAndUser(song, user).orElseThrow(() -> new IllegalArgumentException("해당 곡에 해당 유저의 댓글이 없습니다"));
        
        // when
        userSongCommentRepository.save(UserSongComment.builder().id(userSongComment.getId()).comment("수정 댓글").song(song).user(user).build());
    }

    @Test
    public void 곡_댓글_삭제_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Song song = songRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다"));
        UserSongComment userSongComment = userSongCommentRepository.findBySongAndUser(song, user).orElseThrow(() -> new IllegalArgumentException("해당 곡에 해당 유저의 댓글이 없습니다"));

        // when
        userSongCommentRepository.delete(userSongComment);
    }

}
