package com.example.backend.domain;

import com.example.backend.domain.albums.Album;
import com.example.backend.domain.albums.AlbumRepository;
import com.example.backend.domain.producers.Producer;
import com.example.backend.domain.producers.ProducerRepository;
import com.example.backend.domain.songs.Song;
import com.example.backend.domain.songs.SongRepository;
import com.example.backend.web.dto.SongResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        Album album = albumRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다."));

        // when
        Song song = songRepository.save(Song.builder().genre(Genre.BALLAD).songName("별로인날").singer(producer).album(album).build());

        // then
        songRepository.findById(song.getId()).orElseThrow(() -> new IllegalArgumentException("해당 곡이 없습니다."));
    }


    @Test
    public void 곡_프로듀서_조인한_전체_곡_가져오기_테스트() {
        List<SongResponseDto> songs = songRepository.getAllSongsJoinedByProducer();

        songs.forEach(songResponseDto -> {
            System.out.println(songResponseDto.toString());
        });
    }

}
