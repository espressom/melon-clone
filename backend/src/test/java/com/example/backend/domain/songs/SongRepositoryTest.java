package com.example.backend.domain.songs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongRepositoryTest {

    @Autowired
    SongRepository songsRepository;

    @Test
    public void SONGS_CREATE_TEST() {
//        songsRepository.save(Song.builder().song_name("테스트송").genre(Genre.BALLAD).build());
//
//        Song song = songsRepository.findById(1L).orElseThrow(RuntimeException::new);
//
//        System.out.println(song.getGenre());
//        assertThat(song.getGenre()).isEqualTo(Genre.BALLAD);

    }

}
