package com.example.backend.web;

import com.example.backend.service.user.UserSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserSerivce userSerivce;

}
