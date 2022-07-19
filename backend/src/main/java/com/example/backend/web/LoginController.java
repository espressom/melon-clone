package com.example.backend.web;

import com.example.backend.config.JWTUtil;
import com.example.backend.service.producer.ProducerService;
import com.example.backend.service.user.UserSerivce;
import com.example.backend.web.dto.LoginRequestDto;
import com.example.backend.web.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserSerivce userSerivce;
    private final ProducerService producerService;

    @PostMapping({"/{role}"})
    public ResponseEntity<ResponseDto> login(@RequestBody LoginRequestDto requestDto, @PathVariable String role) {

        System.out.println(role);

        if(validLoginInfo(requestDto, role)) { // 유효한 회원인 경우
            String jwt = JWTUtil.makeAuthToken(requestDto.getEmail(), role);
            return ResponseEntity
                    .ok()
                    .header("Authorization", jwt)
                    .body(ResponseDto.builder()
                            .msg("로그인 성공")
                            .status(HttpStatus.OK)
                            .build());

        } else { // 유효하지 않은 회원인 경우
            return new ResponseEntity<>(
                    ResponseDto.builder()
                    .status(HttpStatus.FORBIDDEN)
                    .msg("로그인 실패")
                    .build(),
                    HttpStatus.FORBIDDEN);
        }
    }

    private boolean validLoginInfo(LoginRequestDto requestDto, String role) {
        if(role.equals("user")) {
            return userSerivce.isValidUser(requestDto);
        } else if (role.equals("producer")) {
            return producerService.isValidProducer(requestDto);
        } else {
            return false;
        }
    }

}
