package com.example.backend.domain;

import com.example.backend.domain.playlists.Playlist;
import com.example.backend.domain.playlists.PlaylistRepository;
import com.example.backend.domain.songs.Song;
import com.example.backend.domain.songs.SongRepository;
import com.example.backend.domain.users_playlists.UserPlaylist;
import com.example.backend.domain.users_playlists.UserPlaylistRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaylistRepositoryTest {

    @Autowired
    PlaylistRepository playlistRepository;

    @Autowired
    UserPlaylistRepository userPlaylistRepository;

    @Autowired
    SongRepository songRepository;

    @Test
    public void 플레이리스트_곡_추가_테스트() {
        // given
        UserPlaylist userPlaylist = userPlaylistRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("해당 플레이리스트(유저)가 없습니다"));
        Song song = songRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다") );

        // when
        playlistRepository.save(Playlist.builder().userPlaylist(userPlaylist).song(song).build());

    }

    @Test
    public void 유저_플레이리스트로_곡_가져오기_테스트() {
        // given
        UserPlaylist userPlaylist = userPlaylistRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 플레이리스트(유저)가 없습니다"));
        List<Playlist> playlists = playlistRepository.getSongsByUserPlaylist(userPlaylist);
        playlists.forEach(playlist -> System.out.println(playlist.getSong().getSongName()));
    }

}
