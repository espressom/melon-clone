package com.example.backend.domain.producers;

import com.example.backend.domain.Gender;
import com.example.backend.domain.Position;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerRepositoryTest {

    @Autowired
    ProducerRepository producerRepository;

//    @After
    public void cleanUp() {
        producerRepository.deleteAll();
    }

    @Test
    public void 프로듀서_생성_테스트() {
        producerRepository.save(Producer.builder().password("1").position(Position.ARRANGER).name("테스트").gender(Gender.FEMALE).email("exampl2sdfsddddde").build());

        List<Producer> producerList = producerRepository.findAll();

        Producer producer = producerList.get(0);
        System.out.println(producer);
    }

    @Test
    public void 프로듀서_아이디로_읽기_테스트() {
        Producer producer = producerRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 프로듀서가 없습니다"));

    }

    @Test
    public void 프로듀서_앨범목록_가져오기_테스트() {
        Producer producer = producerRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("해당 프로듀서가 없습니다"));
        producer.getAlbums().forEach( album -> System.out.println(album.getName()) );
    }

}
