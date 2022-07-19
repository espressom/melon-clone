package com.example.backend.web;

import com.example.backend.service.producer.ProducerService;
import com.example.backend.service.user.UserSerivce;
import com.example.backend.web.dto.ProducerSignupRequestDto;
import com.example.backend.web.dto.ResponseDto;
import com.example.backend.web.dto.UserSignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/signup")
public class SignupController {

    private final UserSerivce userSerivce;

    private final ProducerService producerService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDto> userSignup(@RequestBody UserSignupRequestDto requestDto) {
        try {
            Long id = userSerivce.save(requestDto);
            return ResponseEntity
                    .ok()
                    .body(ResponseDto.builder()
                            .msg("회원가입 성공: "+id)
                            .status(HttpStatus.OK)
                            .build());
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(ResponseDto.builder()
                            .msg("회원가입 실패")
                            .status(HttpStatus.BAD_REQUEST)
                            .build());
        }
    }

    @PostMapping("/producer")
    public ResponseEntity<ResponseDto> producerSignup(@RequestBody ProducerSignupRequestDto requestDto) {
        try {
            Long id = producerService.save(requestDto);
            return ResponseEntity
                    .ok()
                    .body(ResponseDto.builder()
                            .msg("회원가입 성공: "+id)
                            .status(HttpStatus.OK)
                            .build());
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(ResponseDto.builder()
                            .msg("회원가입 실패")
                            .status(HttpStatus.BAD_REQUEST)
                            .build());
        }
    }


}
