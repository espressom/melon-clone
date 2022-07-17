package com.example.backend.domain.users_albums;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.albums.AlbumRepository;
import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAlbumRepositoryTest {

    @Autowired
    UserAlbumRepository userAlbumRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;


    @Test
    public void 유저_앨범_좋아요_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));
        UserAlbum userAlbum = userAlbumRepository.findByAlbumAndUser(album, user);

        // when
        userAlbumRepository.save(UserAlbum.builder().seq(userAlbum.getSeq()).album(album).user(user).album_like_status(0).build());
    }

    @Test
    public void 유저와_앨범으로_조회_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));
        // when
        UserAlbum userAlbum = userAlbumRepository.findByAlbumAndUser(album, user);
    }

}
