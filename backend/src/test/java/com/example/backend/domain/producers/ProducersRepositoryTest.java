package com.example.backend.domain.producers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducersRepositoryTest {

    @Autowired
    ProducersRepository producersRepository;

    @Test
    public void PRODUCER_CREATE_TEST() {
//        producersRepository.save();
    }

}
