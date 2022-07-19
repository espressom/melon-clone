package com.example.backend.domain;

import com.example.backend.domain.users.User;
import com.example.backend.domain.users.UserRepository;
import com.example.backend.domain.users_playlists.UserPlaylist;
import com.example.backend.domain.users_playlists.UserPlaylistRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPlaylistRepositoryTest {

    @Autowired
    UserPlaylistRepository userPlaylistRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 유저_플레이리스트_생성_테스트() {
        // given
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다"));

        // when
        UserPlaylist userPlaylist = userPlaylistRepository.save(UserPlaylist.builder().user(user).build());

        // then
        userPlaylistRepository.findById(userPlaylist.getId()).orElseThrow(() -> new IllegalArgumentException("해당 플레이리스트가 없습니다."));
    }

}
