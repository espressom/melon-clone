package com.example.backend.domain.songs;

import com.example.backend.domain.Genre;
import com.example.backend.domain.albums.Album;
import com.example.backend.domain.albums.AlbumRepository;
import com.example.backend.domain.producers.Producer;
import com.example.backend.domain.producers.ProducerRepository;
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
    SongRepository songRepository;
    @Autowired
    ProducerRepository producerRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Test
    public void 곡_생성_테스트() {
        // given
        Producer producer = producerRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 프로듀서가 없습니다"));
        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다."));

        // when
        Song song = songRepository.save(Song.builder().genre(Genre.BALLAD).songName("싫은 날").singer(producer).album(album).build());

        // then
        songRepository.findById(song.getId()).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다."));
    }

}
