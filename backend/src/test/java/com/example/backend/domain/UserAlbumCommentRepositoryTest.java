package com.example.backend.domain;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.albums.AlbumRepository;
import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.domain.users_albums_comments.UserAlbumComment;
import com.example.backend.domain.users_albums_comments.UserAlbumCommentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAlbumCommentRepositoryTest {

    @Autowired
    UserAlbumCommentRepository userAlbumCommentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Test
    public void 앨범_댓글_작성_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));

        // when
        userAlbumCommentRepository.save(UserAlbumComment.builder().album(album).user(user).comment("댓글댓글").build());
    }

    @Test
    public void 앨범_댓글_수정_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));
        UserAlbumComment userAlbumComment = userAlbumCommentRepository.findByAlbumAndUser(album, user).orElseThrow(() -> new IllegalArgumentException("해당 앨범에 해당 유저의 댓글이 없습니다"));

        // when
        userAlbumCommentRepository.save(UserAlbumComment.builder().id(userAlbumComment.getId()).user(user).comment("수정댓글").album(album).build());

    }

    @Test
    public void 앨범_댓글_삭제_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));
        UserAlbumComment userAlbumComment = userAlbumCommentRepository.findByAlbumAndUser(album, user).orElseThrow(() -> new IllegalArgumentException("해당 앨범에 해당 유저의 댓글이 없습니다"));

        // when
        userAlbumCommentRepository.delete(userAlbumComment);
    }

}
