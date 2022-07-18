package com.example.backend.web;

import com.example.backend.service.user.UserSerivce;
import com.example.backend.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSerivce userSerivce;

    @PostMapping("/registration")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userSerivce.save(requestDto);
    }

//    @PostMapping
//    public


}
