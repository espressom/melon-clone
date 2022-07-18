package com.example.backend.domain.albums;

import com.example.backend.domain.producers.Producer;
import com.example.backend.domain.producers.ProducerRepository;
import com.querydsl.core.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRepositoryTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ProducerRepository producerRepository;

    @Test
    public void 앨범_생성_테스트() {

        Producer producer = producerRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 프로듀서가 없습니다"));
        albumRepository.save(Album.builder().name("새앨범 작업").producer(producer).releaseDate(new Date()).build());
        List<Album> albumList = albumRepository.findAll();
        Album album = albumList.get(0);
        System.out.println(album);

    }

    @Test
    public void 앨범에서_곡목록_가져오기_테스트() {

        Album album = albumRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 앨범이 없습니다"));
        album.getSongs().forEach( song -> System.out.println(song.getSongName()) );

    }

    @Test
    public void 앨범_프로듀서_조인한_전체_앨범_가져오기_테스트() {

        List<Tuple> albums = albumRepository.getAllAlbumsJoinedByProducer();

        System.out.println(albums.get(0));

    }



}
