package com.example.backend.service.producer;

import com.example.backend.domain.producers.ProducerRepository;
import com.example.backend.web.dto.LoginRequestDto;
import com.example.backend.web.dto.ProducerSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProducerService {

    private final ProducerRepository producerRepository;

    @Transactional
    public Long save(ProducerSignupRequestDto requestDto) {
        return producerRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public boolean isValidProducer(LoginRequestDto requestDto) {
        return producerRepository.existsByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
    }
}
