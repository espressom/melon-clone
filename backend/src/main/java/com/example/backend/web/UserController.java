package com.example.backend.web;

import com.example.backend.config.JWTUtil;
import com.example.backend.service.user.UserSerivce;
import com.example.backend.web.dto.UserLoginRequestDto;
import com.example.backend.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSerivce userSerivce;

    @PostMapping("/registration")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userSerivce.save(requestDto);
    }

    @PostMapping("/")
    public ResponseEntity login(@RequestBody UserLoginRequestDto requestDto) {
        System.out.println("---------------동작-------------");
        System.out.println(requestDto.getEmail());
        System.out.println(requestDto.getPassword());
        System.out.println(userSerivce.isValidUser(requestDto));

        if(userSerivce.isValidUser(requestDto)) {
            String jwt = JWTUtil.makeAuthToken(requestDto.getEmail());
            return ResponseEntity.ok().header("Authorization", jwt).build();

        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

}
