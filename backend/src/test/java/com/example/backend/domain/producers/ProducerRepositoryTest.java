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
    ProducerRepository producersRepository;

//    @After
    public void cleanUp() {
        producersRepository.deleteAll();
    }

    @Test
    public void PRODUCER_CREATE_TEST() {
        producersRepository.save(Producer.builder().password("1").position(Position.ARRANGER).name("테스트").gender(Gender.FEMALE).email("example323").build());

        List<Producer> producerList = producersRepository.findAll();

        Producer producer = producerList.get(0);
        System.out.println(producer);
    }

}
