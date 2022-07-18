package com.example.backend.service.user;

import com.example.backend.domain.users.UserRepository;
import com.example.backend.web.dto.UserLoginRequestDto;
import com.example.backend.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserSerivce {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public boolean isValidUser(UserLoginRequestDto requestDto) {
        return userRepository.existsByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());
    }

}
